package com.devmountain.PetPortal.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "pet_profile")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pet_id;
    private String pet_name;
    private String pet_type;
    private String breed;
    private String color;
    private Date DOB;
    private Date DOA;
    private String sex;
    private Boolean spayed_neutered;
    private Integer weight;
    private Integer current_vet;
    private String microchip_number;
    private String license_number;
    private String about;

    @ManyToMany(mappedBy = "pets")
    @JsonIgnore
    private List<User> users;

    public Pet() {

    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getPet_id() {
        return pet_id;
    }

    public void setPet_id(Integer pet_id) {
        this.pet_id = pet_id;
    }

    public String getPet_name() {
        return pet_name;
    }

    public void setPet_name(String pet_name) {
        this.pet_name = pet_name;
    }

    public String getPet_type() {
        return pet_type;
    }

    public void setPet_type(String pet_type) {
        this.pet_type = pet_type;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @DateTimeFormat(pattern = "MM-dd-YYYY")
    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    @DateTimeFormat(pattern = "MM-dd-YYYY")
    public Date getDOA() {
        return DOA;
    }

    public void setDOA(Date DOA) {
        this.DOA = DOA;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Boolean getSpayed_neutered() {
        return spayed_neutered;
    }

    public void setSpayed_neutered(Boolean spayed_neutered) {
        this.spayed_neutered = spayed_neutered;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getCurrent_vet() {
        return current_vet;
    }

    public void setCurrent_vet(Integer current_vet) {
        this.current_vet = current_vet;
    }

    public String getMicrochip_number() {
        return microchip_number;
    }

    public void setMicrochip_number(String microchip_number) {
        this.microchip_number = microchip_number;
    }

    public String getLicense_number() {
        return license_number;
    }

    public void setLicense_number(String license_number) {
        this.license_number = license_number;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

}

