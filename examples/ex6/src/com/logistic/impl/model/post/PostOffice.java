package com.logistic.impl.model.post;

import com.logistic.api.model.person.Address;
import com.logistic.api.model.post.*;
import com.logistic.api.model.post.Package;
import com.logistic.api.model.post.Stamp;

import java.awt.*;
import java.util.Date;

/**
 *
 */
public class PostOffice implements com.logistic.api.model.post.PostOffice {
    private Address address;
    private Package.Type acceptableType;
    private int maxWeight;
    private Point coordinates;

    public PostOffice(Address address, Package.Type acceptableType, int maxWeight, Point coordinates) {
        this.address = address;
        this.acceptableType = acceptableType;
        this.maxWeight = maxWeight;
        this.coordinates = coordinates;
    }

    @Override
    public Stamp getStamp() {
        return new com.logistic.impl.model.post.Stamp(this.address, new Date());
    }

    @Override
    public Address getAddress() {
        return this.address;
    }

    @Override
    public Package.Type getAcceptableTypes() {
        return this.acceptableType;
    }

    @Override
    public int getMaxWeight() {
        return this.maxWeight;
    }

    @Override
    public boolean sendPackage(Package parcel) {
        return !parcel.getReceiverAddress().equals(address);
    }

    @Override
    public boolean receivePackage(Package parcel) {
        //не самый лучший вариант, поскольку getStamps может возвращать немодифицируемую коллекция
        //лучше добавить в интерфейс метод для добавления штампа
        parcel.getStamps().add(getStamp());
        return true;
    }

    @Override
    public int getCode() {
        return this.address.getCode();
    }

    @Override
    public Point getGeolocation() {
        return this.coordinates;
    }

    @Override
    public String toString() {
        return "Office " + this.address.getCode() + " ["+ this.address + "] on {" + this.coordinates + "}";
    }
}
