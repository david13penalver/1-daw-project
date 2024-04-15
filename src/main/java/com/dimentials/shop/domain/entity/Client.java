package com.dimentials.shop.domain.entity;

public class Client {
    private Integer clientId;
    private String firstName;
    private String lastName1;
    private String lastName2;
    private String email;
    private Boolean isAdmin;
    private String country;
    private String city;
    private String street;
    private String buildingNumber;
    private String floor;
    private String door;

    public Client(Integer clientId, String firstName, String lastName1, String lastName2, String email, Boolean isAdmin) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName1 = lastName1;
        this.lastName2 = lastName2;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    public Client(Integer clientId, String firstName, String lastName1, String lastName2, String email, Boolean isAdmin, String country, String city, String street, String buildingNumber, String floor, String door) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName1 = lastName1;
        this.lastName2 = lastName2;
        this.email = email;
        this.isAdmin = isAdmin;
        this.country = country;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.floor = floor;
        this.door = door;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName1() {
        return lastName1;
    }

    public void setLastName1(String lastName1) {
        this.lastName1 = lastName1;
    }

    public String getLastName2() {
        return lastName2;
    }

    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", firstName='" + firstName + '\'' +
                ", lastName1='" + lastName1 + '\'' +
                ", lastName2='" + lastName2 + '\'' +
                ", email='" + email + '\'' +
                ", isAdmin=" + isAdmin +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                ", floor='" + floor + '\'' +
                ", door='" + door + '\'' +
                '}';
    }
}