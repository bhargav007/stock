package com.cdl.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="items")
public class Items {
	
	public Items(){}
	
	public Items(int cat_id,String item_name,String item_code,String item_description,String created_date,String modified_date,int created_user,int modified_user,Boolean is_delete){
		this.cat_id=cat_id;
		this.item_name=item_name;
		this.item_code=item_code;
		this.item_description=item_description;
		this.created_date=created_date;
		this.modified_date=modified_date;
		this.modified_user=modified_user;
		this.created_user=created_user;
		this.is_delete=is_delete;
	}
	
	//item_id,cat_id,item_name,item_code,item_description,created_date,modified_date,created_user,modified_user,is_delete
	
	@Id
	@GeneratedValue
	@Column(name="item_id")
	private int item_id;
	
	@Column(name="cat_id")
	private int cat_id;
	
	@NotEmpty
	@Column(name="item_name")
	private String item_name;
	
	@NotEmpty
	@Column(name="item_code")
	private String item_code;

	@Column(name="item_description")
	private String item_description;	
	
	
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

	public int getItem_id() {
		return item_id;
	}

	public int getCat_id() {
		return cat_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public String getItem_code() {
		return item_code;
	}

	public String getItem_description() {
		return item_description;
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

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	public void setItem_description(String item_description) {
		this.item_description = item_description;
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
