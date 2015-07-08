package com.logistic.impl.model.person;

/**
 *
 */
public class Address implements com.logistic.api.model.person.Address {
    private String street;
    private String city;
    private String country;
    private int code;

    public Address(String street, String city, String country, int code) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.code = code;
    }

    @Override
    public String getStreet() {
        return this.street;
    }

    @Override
    public String getCity() {
        return this.city;
    }

    @Override
    public String getCountry() {
        return this.country;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String toString() {
        return "[" + country + " " + city + " " + street + "]";
    }

    public boolean equals(Object o) {
        if(o == null) return false;
        if(!(o instanceof Address)) return false;

        Address a = (Address) o;
        return street.equalsIgnoreCase(a.street) &&
                city.equalsIgnoreCase(a.city) &&
                country.equalsIgnoreCase(a.country) &&
                code == a.code;
    }
}
