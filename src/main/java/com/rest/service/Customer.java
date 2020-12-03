package com.rest.service;

import javax.xml.bind.annotation.XmlRootElement;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@XmlRootElement
@XmlRootElement(name = "customer")
@Entity
@Table(name="customer")
public class Customer {
    
	@Id
	@Column(name="no")
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
    private int custNo;
	
	@Column(name="name")
    private String custName;
    
	@Column(name="country")
    private String custCountry;
    
    public Customer() {
    }

    public Customer(int no, String name, String country) {
        this.custNo = no;
        this.custName = name;
        this.custCountry = country;
    }
    
    @XmlAttribute
    public int getCustNo() {
        return custNo;
    }
    public void setCustNo(int custNo) {
        this.custNo = custNo;
    }
    @XmlElement
    public String getCustName() {
        return custName;
    }
    public void setCustName(String custName) {
        this.custName = custName;
    }
    @XmlElement
    public String getCustCountry() {
        return custCountry;
    }
    public void setCustCountry(String custCountry) {
        this.custCountry = custCountry;
    }    
    
    @Override
	public String toString(){
		return "id="+custNo+", name="+custName+", country="+custCountry;
	}
}