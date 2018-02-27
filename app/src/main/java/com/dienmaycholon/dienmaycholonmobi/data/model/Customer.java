package com.dienmaycholon.dienmaycholonmobi.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Customer {
    private int gender;
    private String name;
    @PrimaryKey
    @NonNull
    private String phone;
    private String email;
    private String note;
    private String ship;
    private String city;
    private String district;
    private String myaddress;
    private String code_company;
    private String name_company;
    private String address_company;
    private int branch;
    private String storebranch;
    private String getday;

    public Customer() {
    }

    Customer(CustomerBuilder customerBuilder) {
        this.gender = customerBuilder.gender;
        this.name = customerBuilder.name;
        this.phone = customerBuilder.phone;
        this.email = customerBuilder.email;
        this.note = customerBuilder.note;
        this.ship = customerBuilder.ship;
        this.city = customerBuilder.city;
        this.district = customerBuilder.district;
        this.myaddress = customerBuilder.myaddress;
        this.code_company = customerBuilder.code_company;
        this.name_company = customerBuilder.name_company;
        this.address_company = customerBuilder.address_company;
        this.branch = customerBuilder.branch;
        this.storebranch = customerBuilder.storebranch;
        this.getday = customerBuilder.getday;
    }

    public int getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    @NonNull
    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getNote() {
        return note;
    }

    public String getShip() {
        return ship;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getMyaddress() {
        return myaddress;
    }

    public String getCode_company() {
        return code_company;
    }

    public String getName_company() {
        return name_company;
    }

    public String getAddress_company() {
        return address_company;
    }

    public int getBranch() {
        return branch;
    }

    public String getStorebranch() {
        return storebranch;
    }

    public String getGetday() {
        return getday;
    }

    public static class CustomerBuilder{
        private int gender;
        private String name;
        private String phone;
        private String email;
        private String note;
        private String ship;
        private String city;
        private String district;
        private String myaddress;
        private String code_company;
        private String name_company;
        private String address_company;
        private int branch;
        private String storebranch;
        private String getday;

        public CustomerBuilder() {
        }

        public Customer build(){
            return new Customer(this);
        }

        public CustomerBuilder setGender(int gender) {
            this.gender = gender;
            return this;
        }

        public CustomerBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public CustomerBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public CustomerBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public CustomerBuilder setNote(String note) {
            this.note = note;
            return this;
        }

        public CustomerBuilder setShip(String ship) {
            this.ship = ship;
            return this;
        }

        public CustomerBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public CustomerBuilder setDistrict(String district) {
            this.district = district;
            return this;
        }

        public CustomerBuilder setMyaddress(String myaddress) {
            this.myaddress = myaddress;
            return this;
        }

        public CustomerBuilder setCode_company(String code_company) {
            this.code_company = code_company;
            return this;
        }

        public CustomerBuilder setName_company(String name_company) {
            this.name_company = name_company;
            return this;
        }

        public CustomerBuilder setAddress_company(String address_company) {
            this.address_company = address_company;
            return this;
        }

        public CustomerBuilder setBranch(int branch) {
            this.branch = branch;
            return this;
        }

        public CustomerBuilder setStorebranch(String storebranch) {
            this.storebranch = storebranch;
            return this;
        }

        public CustomerBuilder setGetday(String getday) {
            this.getday = getday;
            return this;
        }
    }
}
