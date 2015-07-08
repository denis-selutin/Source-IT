package com.logistic.impl.model.transport;

import com.logistic.api.model.post.PostOffice;

/**
 *
 */
public class DeliveryTransport implements com.logistic.api.model.transport.DeliveryTransport {
    private Type type;
    private PostOffice startOffice;
    private PostOffice destinationOffice;

    public DeliveryTransport(Type type, PostOffice startOffice, PostOffice destinationOffice) {
        this.type = type;
        this.startOffice = startOffice;
        this.destinationOffice = destinationOffice;
    }

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public PostOffice getStartPostOffice() {
        return this.startOffice;
    }

    @Override
    public PostOffice getDestinationPostOffice() {
        return this.destinationOffice;
    }
}
