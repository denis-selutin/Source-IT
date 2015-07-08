package com.logistic.impl.model.post;

import com.logistic.api.model.person.Address;

import java.util.Date;

/**
 *
 */
public class Stamp implements com.logistic.api.model.post.Stamp {
    private Address postOfficeAddress;
    private Date stampDate;

    public Stamp(Address address, Date date) {
        this.postOfficeAddress = address;
        this.stampDate = date;
    }

    @Override
    public Address getPostOfficeAddress() {
        return this.postOfficeAddress;
    }

    @Override
    public Date getStampDate() {
        return this.stampDate;
    }
}
