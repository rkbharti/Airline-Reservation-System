package com.hamidur.springBootRESTfulWebservices.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity  //part of database table
@Table(name = "airlines")       // to change or rename the table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})     //store data in json format
public class Airline implements Serializable
{
    @Id     // primary key of table
    @Column(name = "airline_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // by default name ke basis pe  but  for this data is form
    private Integer airlineId;
    @Column(name = "airline_name")
    private String airlineName;
    @JsonIgnore  // to remove general errors
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "airline")    // relationship
    private Set<Airplane> airplanes;   //genric data airplane  and set use to dont put duplicate values

    public Integer getAirlineId() {
        return airlineId;
    }  //create method getairline and return airlineid i.e mention above in line 27

    public void setAirlineId(Integer airlineId) {
        this.airlineId = airlineId;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public Set<Airplane> getAirplanes() {
        return airplanes;
    }

    public void setAirplanes(Set<Airplane> airplanes) {
        this.airplanes = airplanes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airline)) return false;
        Airline airline = (Airline) o;
        return Objects.equals(getAirlineId(), airline.getAirlineId()) &&
                Objects.equals(getAirlineName(), airline.getAirlineName());
    }

    @Override
    public int hashCode() {  //object class and is used to get a unique integer value, called the hash code
        return Objects.hash(getAirlineId(), getAirlineName());
    }

    @Override // method in a subclass is intended to override a method in its superclass.
    public String toString() {   // convert an object to a string representation
        return "Airline{" +
                "airlineId=" + airlineId +
                ", airlineName='" + airlineName + '\'' +
                ", airplanes=" + airplanes +
                '}';
    }
}
