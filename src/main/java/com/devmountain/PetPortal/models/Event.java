package com.devmountain.PetPortal.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "event")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer entry_id;
    private Date event_date;
    private String event_type;
    private String description;

    public Event() {
    }

    public Integer getEntry_id() {
        return entry_id;
    }

    public void setEntry_id(Integer entry_id) {
        this.entry_id = entry_id;
    }

    public Date getEvent_date() {
        return event_date;
    }

    public void setEvent_date(Date event_date) {
        this.event_date = event_date;
    }

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
