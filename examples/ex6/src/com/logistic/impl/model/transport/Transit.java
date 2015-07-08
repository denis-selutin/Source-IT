package com.logistic.impl.model.transport;

import com.logistic.api.model.post.PostOffice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class Transit implements com.logistic.api.model.transport.Transit {
    private final List<PostOffice> offices;
    private final double price;

    public Transit(List<PostOffice> offices, double price) {
        this.price = price;
        this.offices = Collections.unmodifiableList(new ArrayList(offices));
    }

    @Override
    public List<PostOffice> getTransitOffices() {
        return this.offices;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Transit {" + price + "}" + this.offices;
    }
}
