package com.logistic.api.model.post;

import com.logistic.api.model.person.Address;

import java.awt.*;

/**
 * Created by Denis on 5/25/2015.
 */
public interface PostOffice {
    public Stamp getStamp();
    public Address getAddress();
    public Package.Type getAcceptableTypes();
    public int getMaxWeight();
    public boolean sendPackage(Package parcel);
    public boolean receivePackage(Package parcel);
    public int getCode();
    public Point getGeolocation();
}
