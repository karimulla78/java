package com.rest.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "student_address")
public class StudentAddress {

 @Id
 @Column(name = "student_id")
 @GeneratedValue(generator = "gen")
 @GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "student"))
 private long id;

 @Column(name = "address")
 private String address;

 @Column(name = "city")
 private String city;

 @Column(name = "state")
 private String state;

 @Column(name = "country")
 private String country;

 @OneToOne
 @PrimaryKeyJoinColumn
 private Student student;
 
 public StudentAddress(){
  
 }

 public StudentAddress(String address, String city, String state,
   String country) {
  this.address = address;
  this.city = city;
  this.state = state;
  this.country = country;
 }

 public long getId() {
  return id;
 }

 public void setId(long id) {
  this.id = id;
 }

 public String getAddress() {
  return address;
 }

 public void setAddress(String address) {
  this.address = address;
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

 public String getCountry() {
  return country;
 }

 public void setCountry(String country) {
  this.country = country;
 }

 public Student getStudent() {
  return student;
 }

 public void setStudent(Student student) {
  this.student = student;
 }

}