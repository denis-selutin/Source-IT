package com.logistic.impl;

import com.logistic.api.model.post.*;
import com.logistic.api.model.transport.Transit;
import com.logistic.api.service.SenderService;
import com.logistic.impl.model.exception.PackageNotFound;
import com.logistic.impl.model.exception.TransitNotFound;
import com.logistic.impl.model.person.Person;
import com.logistic.impl.model.post.Package;
import com.logistic.impl.service.SenderServiceImpl;
import com.logistic.impl.service.StorageHelper;

import java.util.List;
import java.util.Random;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
        StorageHelper.initializeData();
        SenderService service = new SenderServiceImpl();
        for(int i = 0; i < 10; i++) {
            System.out.println("----------Iteration " + i + "----------");

            try {
                com.logistic.api.model.post.Package parcel = generateRandomPackage();
                System.out.println("Package to send " + parcel);
                List<Transit> transitList = service.calculatePossibleTransits(parcel);
                Transit transit = generateRandomTransit(transitList);
                System.out.println("Has been chosen " + transit);
                service.sendPackage(parcel, transit);
                System.out.println("Package is here " + service.getPackageCurrentPosition(parcel.getPackageId()));
                System.out.println("Miles to destination " + service.getMilesToDestination(parcel.getPackageId()));
            } catch(TransitNotFound | PackageNotFound e) {
                i--;
                System.out.println("Wrong package....retrying");
            }
        }
    }

    public static com.logistic.api.model.post.Package generateRandomPackage() {
        Random random = new Random();
        com.logistic.api.model.post.Package result = new Package(random.nextInt(100),
                com.logistic.api.model.post.Package.Type.getRandomType(),
                new Person.PersonBuilder()
                        .address(StorageHelper.getRandomAddress())
                        .firstName("receiver f name 1")
                        .lastName("receiver l name 1")
                        .middleName("receiver m name 1")
                        .build(),
                new Person.PersonBuilder()
                        .address(StorageHelper.getRandomAddress())
                        .firstName("sender f name 1")
                        .lastName("sender l name 1")
                        .middleName("sender m name 1")
                        .build()
                );
        return result;
    }

    public static Transit generateRandomTransit(List<Transit> transits) {
        if(transits.size() == 0) return null;
        Random random = new Random();
        return transits.get(random.nextInt(transits.size()));
    }
}
