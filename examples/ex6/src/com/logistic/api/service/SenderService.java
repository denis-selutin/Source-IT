package com.logistic.api.service;

import com.logistic.api.model.post.Package;
import com.logistic.api.model.post.PostOffice;
import com.logistic.api.model.transport.Transit;

/**
 * Created by Denis on 5/25/2015.
 */
public interface SenderService {
    public PostOffice[] getAllOffices();
    public Transit[] calculatePossibleTransits(Package parcel, PostOffice senderOffice);
    public boolean sendPackage(Package parcel, Transit transit);
    public PostOffice getPackageCurrentPosition(String id);
    public double getMilesToDestination(String id);

}
