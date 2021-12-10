package com.devmountain.PetPortal.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "vet")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Vet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vet_id;
    private String vet_name;
    private String practice_name;
    private String street_address;
    private String city;
    private String state;
    private Integer zip_code;
    private String vet_phone;
    private String vet_fax;
    private String website;
    private String vet_email;

    @OneToMany(mappedBy = "vet")
    private List<Pet> petList;


    public Vet() {

    }

    public List<Pet> getPetList() {
        if(petList == null)
            petList = new ArrayList<>();
        return petList;
    }

    public void setPetList(List<Pet> petList) {
        this.petList = petList;
    }

    public Integer getVet_id() {
        return vet_id;
    }

    public void setVet_id(Integer vet_id) {
        this.vet_id = vet_id;
    }

    public String getVet_name() {
        return vet_name;
    }

    public void setVet_name(String vet_name) {
        this.vet_name = vet_name;
    }

    public String getPractice_name() {
        return practice_name;
    }

    public void setPractice_name(String practice_name) {
        this.practice_name = practice_name;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZip_code() {
        return zip_code;
    }

    public void setZip_code(Integer zip_code) {
        this.zip_code = zip_code;
    }

    public String getVet_phone() {
        return vet_phone;
    }

    public void setVet_phone(String vet_phone) {
        this.vet_phone = vet_phone;
    }

    public String getVet_fax() {
        return vet_fax;
    }

    public void setVet_fax(String vet_fax) {
        this.vet_fax = vet_fax;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getVet_email() {
        return vet_email;
    }

    public void setVet_email(String vet_email) {
        this.vet_email = vet_email;
    }
}
