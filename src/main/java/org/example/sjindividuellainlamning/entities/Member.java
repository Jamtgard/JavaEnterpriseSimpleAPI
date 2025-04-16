package org.example.sjindividuellainlamning.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class Member {

// ATTRIBUTER ----------------------------------------------------------------------------------------------------------

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 15, nullable = false)
    private String firstName;

    @Column(length = 15, nullable = false)
    private String lastName;

    @Column(length = 30, nullable = false)
    private String email;

    @Column(length = 15)
    private String phone;

    @Column(length = 12, nullable = false)
    private String dateOfBirth;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", nullable = false)
    @JsonIgnoreProperties("listOfMembersInAddress")
    private Address address;

// KONSTRUKTUR ---------------------------------------------------------------------------------------------------------

    public Member() {}
    public Member(String firstName, String lastName, String email, String phone, String dateOfBirth, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

// TO STRING -----------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", address=" + address +
                '}';
    }

// GETTERS & SETTERS ---------------------------------------------------------------------------------------------------


    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}

    public String getDateOfBirth() {return dateOfBirth;}
    public void setDateOfBirth(String dateOfBirth) {this.dateOfBirth = dateOfBirth;}

    public Address getAddress() {return address;}
    public void setAddress(Address address) {this.address = address;}

}
