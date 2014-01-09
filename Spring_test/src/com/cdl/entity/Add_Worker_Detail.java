package com.cdl.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
//worker_detail_id,worker_id,working_date,fullday,halfday,`hour`,calculated_salary,deduction,created_date,modified_date,created_user,modified_user

@Entity
@Table(name="worker_detail")
public class Add_Worker_Detail {
	
	public Add_Worker_Detail(){}
	public Add_Worker_Detail(int worker_id,String working_date,String fullday,String halfday,String hour,float calculated_salary,float deduction, String created_date,String modified_date, int created_user,int modified_user){
		this.worker_id=worker_id;
		this.working_date=working_date;
		this.fullday=fullday;
		this.halfday=halfday;
		this.hour=hour;
		this.calculated_salary=calculated_salary;
		this.deduction=deduction;
		this.created_date=created_date;
		this.modified_date=modified_date;
		this.created_user=created_user;
		this.modified_user=modified_user;
	}
	
	@Id
	@GeneratedValue
	@Column(name="worker_detail_id")
	private int worker_detail_id;
	
	@Column(name="worker_id")
	private int worker_id;
	
	@NotEmpty
	@Column(name="working_date")
	private String working_date;

	@Column(name="fullday")
	private String fullday;
	
	@Column(name="halfday")
	private String halfday;
	
	@Column(name="hour")
	private String hour;
	
	@Column(name="calculated_salary")
	private float calculated_salary;
	
	@Column(name="deduction")
	private float deduction;
	
	@Column(name="created_date")
	private String created_date;	
	
	@Column(name="modified_date")
	private String modified_date;	
	
	@Column(name="created_user")
	private int created_user;
	
	@Column(name="modified_user")
	private int modified_user;

	public int getWorker_detail_id() {
		return worker_detail_id;
	}
	public void setWorker_detail_id(int worker_detail_id) {
		this.worker_detail_id = worker_detail_id;
	}
	public int getWorker_id() {
		return worker_id;
	}
	public void setWorker_id(int worker_id) {
		this.worker_id = worker_id;
	}
	public String getWorking_date() {
		return working_date;
	}
	public void setWorking_date(String working_date) {
		this.working_date = working_date;
	}

	public float getCalculated_salary() {
		return calculated_salary;
	}
	public void setCalculated_salary(float calculated_salary) {
		this.calculated_salary = calculated_salary;
	}
	public float getDeduction() {
		return deduction;
	}
	public void setDeduction(float deduction) {
		this.deduction = deduction;
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
	public String getFullday() {
		return fullday;
	}
	public void setFullday(String fullday) {
		this.fullday = fullday;
	}
	public String getHalfday() {
		return halfday;
	}
	public void setHalfday(String halfday) {
		this.halfday = halfday;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
}
