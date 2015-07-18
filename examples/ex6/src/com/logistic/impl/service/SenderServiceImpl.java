package com.logistic.impl.service;

import com.logistic.api.model.person.Address;
import com.logistic.api.model.post.*;
import com.logistic.api.model.post.Package;
import com.logistic.api.model.transport.Transit;
import com.logistic.api.service.SenderService;
import com.logistic.impl.model.exception.PackageNotFound;
import com.logistic.impl.model.exception.TransitNotFound;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 */
public class SenderServiceImpl implements SenderService {
    private static final int LOST_THRESHOLD = 80;
    private static final int LOST_MAX_THRESHOLD = 100;

    @Override
    public List<PostOffice> getAllOffices() {
        return StorageHelper.getAllOffices();
    }

    private Transit reverseTransit(Transit transit) {
        List<PostOffice> reversedOffices = new ArrayList(transit.getTransitOffices());
        Collections.reverse(reversedOffices);
        Transit result = new com.logistic.impl.model.transport.Transit(reversedOffices, transit.getPrice());
        return result;
    }

    private boolean hasBeenLost() {
        Random random = new Random();
        return LOST_THRESHOLD < random.nextInt(LOST_MAX_THRESHOLD);
    }

    @Override
    //и нам не нужен параметр  PostOffice senderOffice
    public List<Transit> calculatePossibleTransits(com.logistic.api.model.post.Package parcel) {
        List<Transit> result = new ArrayList<>();
        for(Transit transit : StorageHelper.getTransits()) {
            List<PostOffice> transitOffices = transit.getTransitOffices();
            int maxWeightLimit = Integer.MAX_VALUE;
            for(PostOffice office : transitOffices) {
                if(maxWeightLimit > office.getMaxWeight()) {
                    maxWeightLimit = office.getMaxWeight();
                }
                //тут можно проверять office.getAcceptableTypes() == parcel.getType()
            }
            if((transitOffices.get(transitOffices.size() - 1).getAddress().equals(parcel.getReceiverAddress()) &&
                    transitOffices.get(0).getAddress().equals(parcel.getSenderAddress())) &&
                    maxWeightLimit >= parcel.getWeight()) {
                result.add(transit);
            }
            if((transitOffices.get(0).getAddress().equals(parcel.getReceiverAddress()) &&
                    transitOffices.get(transitOffices.size() - 1).getAddress().equals(parcel.getSenderAddress())) &&
                    maxWeightLimit >= parcel.getWeight()) {
                result.add(reverseTransit(transit));
            }
        }
        return result;
    }

    @Override
    public boolean sendPackage(Package parcel, Transit transit) {
        if(parcel == null) throw new PackageNotFound();
        if(transit == null) throw new TransitNotFound();
        StorageHelper.saveParcelTransit(parcel, transit);
        if(transit.getTransitOffices().size() == 0) {
            return false;
        }
        boolean send = true;
        for(PostOffice office : transit.getTransitOffices()) {
            office.receivePackage(parcel);
            if(hasBeenLost()) {
                System.out.println("Package has been lost");
                return true;
            }
            //тут можно подкрутить отсылку так чтобы полылка не всегда доходила до точки назначения
            send = office.sendPackage(parcel);
            if(!send) {
                System.out.println("Package has been rich destination place");
                break;
            }
        }
        return send;
    }

    @Override
    public PostOffice getPackageCurrentPosition(String id) {
        Package parcel = StorageHelper.getPackage(id);
        Transit transit = StorageHelper.getTransit(id);
        if(parcel == null) {
            throw new PackageNotFound();
        }
        if(transit == null) {
            throw new TransitNotFound();
        }

        List<Stamp> stamps = parcel.getStamps();
        Address lastOfficeAddress = stamps.get(stamps.size() - 1).getPostOfficeAddress();
        for(PostOffice office : transit.getTransitOffices()) {
            if(lastOfficeAddress.equals(office.getAddress())) {
                return office;
            }
        }

        return null;
    }

    @Override
    public double getMilesToDestination(String id) {
        PostOffice currentOffice = getPackageCurrentPosition(id);
        Package parcel = StorageHelper.getPackage(id);
        if(currentOffice.getAddress().equals(parcel.getReceiverAddress())) {
            return 0;
        }
        Transit transit = StorageHelper.getTransit(id);
        boolean isOnTheWay = false;
        int miles = 0;
        PostOffice previousOffice = null;
        for(PostOffice office : transit.getTransitOffices()) {
            if(isOnTheWay) {
                miles += office.getGeolocation().distance(previousOffice.getGeolocation());
            }

            if(currentOffice.getAddress().equals(office.getAddress())) {
                isOnTheWay = true;
            }
            previousOffice = office;
        }
        return miles;
    }
}
