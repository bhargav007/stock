package com.cdl.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="purchase")
public class Purchase {
	
	public Purchase(){}
	
	public Purchase(int item_id,int quantity,String purchase_date,int userid){
		this.item_id=item_id;
		this.quantity=quantity;
		this.purchase_date=purchase_date;
		this.userid=userid;
	}
	
	//purchase_id,item_id,quantity,purchase_date,userid  
	
	@Id
	@GeneratedValue
	@Column(name="purchase_id")
	private int purchase_id;
	
	@Column(name="item_id")
	private int item_id;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="purchase_date")
	private String purchase_date;

	
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

	public int getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
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

	public String getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
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
