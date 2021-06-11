package com.senior.dto;

import com.senior.model.Address;

import java.util.Objects;

public class AddressDTO {

    private Long id;
    private String CEP;
    private String country;
    private String state;
    private String city;
    private String district;
    private String patio;
    private int number;

    public AddressDTO() {
    }

    public AddressDTO(Long id, String CEP, String country, String state, String city, String district, String patio, int number) {
        this.id = id;
        this.CEP = CEP;
        this.country = country;
        this.state = state;
        this.city = city;
        this.district = district;
        this.patio = patio;
        this.number = number;
    }

    public AddressDTO(Address update) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPatio() {
        return patio;
    }

    public void setPatio(String patio) {
        this.patio = patio;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDTO that = (AddressDTO) o;
        return number == that.number && Objects.equals(id, that.id) && Objects.equals(CEP, that.CEP) && Objects.equals(country, that.country) && Objects.equals(state, that.state) && Objects.equals(city, that.city) && Objects.equals(district, that.district) && Objects.equals(patio, that.patio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, CEP, country, state, city, district, patio, number);
    }
}
