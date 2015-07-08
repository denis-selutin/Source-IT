package com.logistic.impl.model.person;

import com.logistic.api.model.person.*;
import com.logistic.api.model.person.Address;

/**
 *
 */
public class Person implements com.logistic.api.model.person.Person, FullName {
    private Address address;
    private String firstName;
    private String lastName;
    private String middleName;


    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String getMiddleName() {
        return this.middleName;
    }

    @Override
    public Address getAddress() {
        return this.address;
    }

    @Override
    public FullName getFullName() {
        return this;
    }

    @Override
    public String toString() {
        return "Person [" + firstName + " " + lastName + " " + middleName + "] " + address;
    }

    public static final class PersonBuilder {
        private String street;
        private String city;
        private String country;
        private int code;
        private String firstName;
        private String lastName;
        private String middleName;
        private Address address;

        public PersonBuilder address(Address address) {
            this.address = address;
            return this;
        }
        public PersonBuilder street(String val) {
            this.street = val;
            return this;
        }
        public PersonBuilder city(String val) {
            this.city = val;
            return this;
        }
        public PersonBuilder country(String val) {
            this.country = val;
            return this;
        }
        public PersonBuilder code(int val) {
            this.code = val;
            return this;
        }
        public PersonBuilder firstName(String val) {
            this.firstName = val;
            return this;
        }
        public PersonBuilder lastName(String val) {
            this.lastName = val;
            return this;
        }
        public PersonBuilder middleName(String val) {
            this.middleName = val;
            return this;
        }
        public Person build() {
            Address address = null;
            if(this.address != null) {
                address = this.address;
            } else {
                address = new com.logistic.impl.model.person.Address(street, city, country, code);
            }
            Person person = new Person();
            person.address = address;
            person.firstName = firstName;
            person.lastName = lastName;
            person.middleName = middleName;
            return person;
        }
    }
}
