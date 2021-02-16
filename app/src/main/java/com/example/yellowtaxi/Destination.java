package com.example.yellowtaxi;

public class Destination {
    private String name;
    private String address;
    private String phone;
    private String website;
    private String pic_main;
    private String description;
    private int price;
    private int rating;
    private String extra_pics_1;
    private String extra_pics_2;
    private String extra_pics_3;
    private String extra_pics_4;


    public Destination(String name, String address, String pic_main) {
        this.name = name;
        this.address = address;
        this.pic_main = pic_main;
    }

    public Destination(String name, String address, String phone, String website, String pic_main, String description, int price, int rating, String extra_pics_1, String extra_pics_2, String extra_pics_3, String extra_pics_4) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.pic_main = pic_main;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.extra_pics_1 = extra_pics_1;
        this.extra_pics_2 = extra_pics_2;
        this.extra_pics_3 = extra_pics_3;
        this.extra_pics_4 = extra_pics_4;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPic_main() {
        return pic_main;
    }

    public void setPic_main(String pic_main) {
        this.pic_main = pic_main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getExtra_pics_1() {
        return extra_pics_1;
    }

    public void setExtra_pics_1(String extra_pics_1) {
        this.extra_pics_1 = extra_pics_1;
    }

    public String getExtra_pics_2() {
        return extra_pics_2;
    }

    public void setExtra_pics_2(String extra_pics_2) {
        this.extra_pics_2 = extra_pics_2;
    }

    public String getExtra_pics_3() {
        return extra_pics_3;
    }

    public void setExtra_pics_3(String extra_pics_3) {
        this.extra_pics_3 = extra_pics_3;
    }

    public String getExtra_pics_4() {
        return extra_pics_4;
    }

    public void setExtra_pics_4(String extra_pics_4) {
        this.extra_pics_4 = extra_pics_4;
    }





}
