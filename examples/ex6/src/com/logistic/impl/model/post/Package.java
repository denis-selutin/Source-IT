package com.logistic.impl.model.post;

import com.logistic.api.model.person.Address;
import com.logistic.api.model.person.FullName;
import com.logistic.api.model.person.Person;
import com.logistic.api.model.post.Stamp;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 */
public class Package implements com.logistic.api.model.post.Package {
    private String id;
    private int weight;
    private Type type;
    private Person receiver;
    private Person sender;
    private List<Stamp> stamps;

    public Package(int weight, Type type, Person receiver, Person sender) {
        this.stamps = new ArrayList<>();
        this.id = UUID.randomUUID().toString();
        this.weight = weight;
        this.type = type;
        this.receiver = receiver;
        this.sender = sender;
    }

    @Override
    public String getPackageId() {
        return this.id;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public Address getReceiverAddress() {
        return this.receiver.getAddress();
    }

    @Override
    public Address getSenderAddress() {
        return this.sender.getAddress();
    }

    @Override
    public FullName getSenderFullName() {
        return this.sender.getFullName();
    }

    @Override
    public FullName getReceiverFullName() {
        return this.receiver.getFullName();
    }

    @Override
    public List<Stamp> getStamps() {
        return this.stamps;
    }

    @Override
    public String toString() {
        return "Package " + type + " {" + id + "} weight {" + weight + "} from {" + sender + "} to {" + receiver + "}";
    }
}
