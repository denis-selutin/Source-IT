package com.logistic.api.model.post;

import com.logistic.api.model.person.Address;

import java.util.Date;

/**
 * Created by Denis on 5/25/2015.
 */
public interface Stamp {
    public Address getPostOfficeAddress();
    public Date getStampDate();
}
