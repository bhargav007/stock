package com.cdl.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

//worker_id,worker_name,address,contact,licenceNo,salary_per_day,created_date,modified_date,created_user,modified_user
@Entity
@Table(name="worker")
public class Add_Worker {
	
	public Add_Worker(){}
	public Add_Worker(int id,String worker_name,float salary_per_day){
		this.worker_id=id;
		this.worker_name=worker_name;
		this.salary_per_day=salary_per_day;
	}
	public Add_Worker(String worker_name,String address,String contact,String licenceNo,float salary_per_day,String created_date,String modified_date,int created_user,Boolean is_delete){
		this.worker_name=worker_name;
		this.address=address;
		this.contact=contact;
		this.licenceNo=licenceNo;
		this.salary_per_day=salary_per_day;
		this.created_date=created_date;
		this.modified_date=modified_date;
		this.created_user=created_user;
		this.is_delete=is_delete;
	}
	
	
	
	@Id
	@GeneratedValue
	@Column(name="worker_id")
	private int worker_id;
	
	@NotEmpty
	@Column(name="worker_name")
	private String worker_name;
	
	@Column(name="address")
	private String address;

	@Column(name="contact")
	private String contact;	
	
	@Column(name="licenceNo")
	private String licenceNo;	
	
	@Column(name="salary_per_day")
	private float salary_per_day;
	
	@Column(name="created_date")
	private String created_date;	
	
	@Column(name="modified_date")
	private String modified_date;	
	
	@Column(name="created_user")
	private int created_user;
	
	@Column(name="is_delete")
	private Boolean is_delete;
	
	public Boolean getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(Boolean is_delete) {
		this.is_delete = is_delete;
	}

	public int getWorker_id() {
		return worker_id;
	}

	public void setWorker_id(int worker_id) {
		this.worker_id = worker_id;
	}

	public String getWorker_name() {
		return worker_name;
	}

	public void setWorker_name(String worker_name) {
		this.worker_name = worker_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	public float getSalary_per_day() {
		return salary_per_day;
	}

	public void setSalary_per_day(float salary_per_day) {
		this.salary_per_day = salary_per_day;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public String getModified_date() {
		return modified_date;
	}

	public void setModified_date(String modified_date) {
		this.modified_date = modified_date;
	}

	public int getCreated_user() {
		return created_user;
	}

	public void setCreated_user(int created_user) {
		this.created_user = created_user;
	}

	public int getModified_user() {
		return modified_user;
	}

	public void setModified_user(int modified_user) {
		this.modified_user = modified_user;
	}

	@Column(name="modified_user")
	private int modified_user;
	
}
