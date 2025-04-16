package org.example.sjindividuellainlamning.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Address {

// ATTRIBUTER ----------------------------------------------------------------------------------------------------------

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 20, nullable = false)
    private String street;

    @Column(length = 6, nullable = false)
    private String postalCode;

    @Column(length = 15, nullable = false)
    private String city;

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Member> listOfMembersInAddress;

// KONSTRUKTOR ---------------------------------------------------------------------------------------------------------

    public Address() {}
    public Address(String street, String postalCode, String city) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
    }

// TO STRING -----------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", members=" + listOfMembersInAddress +
                '}';
    }

// GETTERS & SETTERS ---------------------------------------------------------------------------------------------------


    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getStreet() {return street;}
    public void setStreet(String street) {this.street = street;}

    public String getPostalCode() {return postalCode;}
    public void setPostalCode(String postalCode) {this.postalCode = postalCode;}

    public String getCity() {return city;}
    public void setCity(String city) {this.city = city;}

    public List<Member> getListOfMembersInAddress() {return listOfMembersInAddress;}
    public void setListOfMembersInAddress(List<Member> members) {this.listOfMembersInAddress = members;}

}
