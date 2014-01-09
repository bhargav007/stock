package com.cdl.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="customer")
public class Customer {
	
	public Customer(){}
	
	public Customer(String cust_name,String cust_code,String cust_address,String cust_contact,String cust_email,String cust_country,String cust_city,String created_date,String modified_date,int created_user,int modified_user,Boolean is_delete){
		this.cust_name=cust_name;
		this.cust_code=cust_code;
		this.cust_address=cust_address;
		
		this.cust_contact=cust_contact;
		this.cust_email=cust_email;
		this.cust_country=cust_country;
		this.cust_city=cust_city;
		
		this.created_date=created_date;
		this.modified_date=modified_date;
		this.modified_user=modified_user;
		this.created_user=created_user;
		this.is_delete=is_delete;
	}
	
	//cust_id,cust_name,cust_code,cust_address,cust_contact,cust_email,cust_country,cust_city,created_date,created_user,modified_date,modified_user
	
	@Id
	@GeneratedValue
	@Column(name="cust_id")
	private int cust_id;
	
	@NotEmpty
	@Column(name="cust_name")
	private String cust_name;
	
	@NotEmpty
	@Column(name="cust_code")
	private String cust_code;

	@Column(name="cust_address")
	private String cust_address;	
	
	
	@Column(name="cust_contact")
	private String cust_contact;
	
	@Column(name="cust_email")
	private String cust_email;
	
	@Column(name="cust_country")
	private String cust_country;
	
	
	@Column(name="cust_city")
	private String cust_city;
	
	@Column(name="created_date")
	private String created_date;	
	
	@Column(name="modified_date")
	private String modified_date;	
	
	@Column(name="created_user")
	private int created_user;
	
	@Column(name="modified_user")
	private int modified_user;

	@Column(name="is_delete")
	private Boolean is_delete;

	public int getCust_id() {
		return cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public String getCust_code() {
		return cust_code;
	}

	public String getCust_address() {
		return cust_address;
	}

	public String getCust_contact() {
		return cust_contact;
	}

	public String getCust_email() {
		return cust_email;
	}

	public String getCust_country() {
		return cust_country;
	}

	public String getCust_city() {
		return cust_city;
	}

	public String getCreated_date() {
		return created_date;
	}

	public String getModified_date() {
		return modified_date;
	}

	public int getCreated_user() {
		return created_user;
	}

	public int getModified_user() {
		return modified_user;
	}

	public Boolean getIs_delete() {
		return is_delete;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public void setCust_code(String cust_code) {
		this.cust_code = cust_code;
	}

	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}

	public void setCust_contact(String cust_contact) {
		this.cust_contact = cust_contact;
	}

	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}

	public void setCust_country(String cust_country) {
		this.cust_country = cust_country;
	}

	public void setCust_city(String cust_city) {
		this.cust_city = cust_city;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public void setModified_date(String modified_date) {
		this.modified_date = modified_date;
	}

	public void setCreated_user(int created_user) {
		this.created_user = created_user;
	}

	public void setModified_user(int modified_user) {
		this.modified_user = modified_user;
	}

	public void setIs_delete(Boolean is_delete) {
		this.is_delete = is_delete;
	}

	
}
