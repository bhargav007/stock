package com.cdl.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sale")
public class Sale {
	
	public Sale(){}
	
	public Sale(int item_id,int quantity,String sale_date,int userid){
		this.item_id=item_id;
		this.quantity=quantity;
		this.sale_date=sale_date;
		this.userid=userid;
	}
	
	//sale_id,item_id,quantity,sale_date,userid   
	
	@Id
	@GeneratedValue
	@Column(name="sale_id")
	private int sale_id;
	
	@Column(name="item_id")
	private int item_id;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="sale_date")
	private String sale_date;

	
	@Column(name="userid")
	private int userid;

	@Column(name="created_date")
	private String created_date;	
	
	@Column(name="modified_date")
	private String modified_date;	
	
	@Column(name="created_user")
	private int created_user;
	
	@Column(name="modified_user")
	private int modified_user;

	public int getSale_id() {
		return sale_id;
	}

	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSale_date() {
		return sale_date;
	}

	public void setSale_date(String sale_date) {
		this.sale_date = sale_date;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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


}
