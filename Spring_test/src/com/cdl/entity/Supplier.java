package com.cdl.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="supplier")
public class Supplier {
	
	public Supplier(){}
	
	public Supplier(String sup_name,String sup_code,String sup_address,String sup_contact,String sup_email,String sup_country,String sup_city,String created_date,String modified_date,int created_user,int modified_user,Boolean is_delete){
		this.sup_name=sup_name;
		this.sup_code=sup_code;
		this.sup_address=sup_address;
		
		this.sup_contact=sup_contact;
		this.sup_email=sup_email;
		this.sup_country=sup_country;
		this.sup_city=sup_city;
		
		this.created_date=created_date;
		this.modified_date=modified_date;
		this.modified_user=modified_user;
		this.created_user=created_user;
		this.is_delete=is_delete;
	}
	
	//cust_id,cust_name,cust_code,cust_address,cust_contact,cust_email,cust_country,cust_city,created_date,created_user,modified_date,modified_user
	
	@Id
	@GeneratedValue
	@Column(name="sup_id")
	private int sup_id;
	
	@NotEmpty
	@Column(name="sup_name")
	private String sup_name;
	
	@NotEmpty
	@Column(name="sup_code")
	private String sup_code;

	@Column(name="sup_address")
	private String sup_address;	
	
	
	@Column(name="sup_contact")
	private String sup_contact;
	
	@Column(name="sup_email")
	private String sup_email;
	
	@Column(name="sup_country")
	private String sup_country;
	
	
	@Column(name="sup_city")
	private String sup_city;
	
	@Column(name="created_date")
	private String created_date;	
	
	@Column(name="modified_date")
	private String modified_date;	
	
	@Column(name="created_user")
	private int created_user;
	
	@Column(name="modified_user")
	private int modified_user;
	
	public int getSup_id() {
		return sup_id;
	}

	public String getSup_name() {
		return sup_name;
	}

	public String getSup_code() {
		return sup_code;
	}

	public String getSup_address() {
		return sup_address;
	}

	public String getSup_contact() {
		return sup_contact;
	}

	public String getSup_email() {
		return sup_email;
	}

	public String getSup_country() {
		return sup_country;
	}

	public String getSup_city() {
		return sup_city;
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

	public void setSup_id(int sup_id) {
		this.sup_id = sup_id;
	}

	public void setSup_name(String sup_name) {
		this.sup_name = sup_name;
	}

	public void setSup_code(String sup_code) {
		this.sup_code = sup_code;
	}

	public void setSup_address(String sup_address) {
		this.sup_address = sup_address;
	}

	public void setSup_contact(String sup_contact) {
		this.sup_contact = sup_contact;
	}

	public void setSup_email(String sup_email) {
		this.sup_email = sup_email;
	}

	public void setSup_country(String sup_country) {
		this.sup_country = sup_country;
	}

	public void setSup_city(String sup_city) {
		this.sup_city = sup_city;
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

	@Column(name="is_delete")
	private Boolean is_delete;

	
}
