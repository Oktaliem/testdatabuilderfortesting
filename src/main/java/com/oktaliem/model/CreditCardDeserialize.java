package com.oktaliem.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class CreditCardDeserialize {
    public CreditCardDeserialize(){}

    @JsonProperty("firstname")
    String firstname;
    public String getFirstname(){ return this.firstname; }

    @JsonProperty("lastname")
    String lastname;
    public String getLastName() { return this.lastname; }

    @JsonProperty("email")
    String email;
    public String getEmail(){ return this.email; }

    @JsonProperty("date")
    String date;
    public String getDate(){ return this.date; }

    @JsonProperty("address")
    String address;
    public String getAddress(){ return this.address; }

    @JsonProperty("cc")
    CC cc;
    public CC getCc(){ return this.cc;}
    public static class CC {
        @JsonProperty("number")
        String number;
        public String getNumber(){ return this.number;}

        @JsonProperty("bank")
        String bank;
        public String getBank(){ return this.bank;}
    }

    @JsonProperty("product")
    Product product;
    public Product getProduct(){ return this.product;}
    public static class Product {
        @JsonProperty("type")
        String type;
        public String getType(){ return this.type;}
    }

    public static CreditCardDeserialize get(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filename), CreditCardDeserialize.class);
    }
}
