package com.cdl.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="category")
public class Category {
	
	public Category(){}
	
	public Category(String cat_name,String cat_code,String cat_description,String created_date,String modified_date,int created_user,int modified_user,Boolean is_delete){
		this.cat_name=cat_name;
		this.cat_code=cat_code;
		this.cat_description=cat_description;
		this.created_date=created_date;
		this.modified_date=modified_date;
		this.modified_user=modified_user;
		this.created_user=created_user;
		this.is_delete=is_delete;
	}
	
	//cat_id,cat_name,cat_code,cat_description,created_date,modified_date,created_user,modified_user,is_delete
	
	@Id
	@GeneratedValue
	@Column(name="cat_id")
	private int cat_id;
	
	@NotEmpty
	@Column(name="cat_name")
	private String cat_name;
	
	@NotEmpty
	@Column(name="cat_code")
	private String cat_code;

	@Column(name="cat_description")
	private String cat_description;	
	
	
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

	public int getCat_id() {
		return cat_id;
	}
	public String getCat_name() {
		return cat_name;
	}
	public String getCat_code() {
		return cat_code;
	}
	public String getCat_description() {
		return cat_description;
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
	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	public void setCat_code(String cat_code) {
		this.cat_code = cat_code;
	}
	public void setCat_description(String cat_description) {
		this.cat_description = cat_description;
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
