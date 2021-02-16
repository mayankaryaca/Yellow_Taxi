package com.example.yellowtaxi;

public class Destination {
    private String name;
    private String address;
    private String pic_main;

    public Destination(String name, String address, String pic_main) {
        this.name = name;
        this.address = address;
        this.pic_main = pic_main;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPic_main() {
        return pic_main;
    }



}
