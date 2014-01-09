package com.cdl.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stock_transaction")
public class Stock_Transaction {
	
	public Stock_Transaction(){}
	
	public Stock_Transaction(int item_id,String type,int quantity,String trans_date,String reason,int userid,float unit_cost ){
		this.item_id=item_id;
		this.type=type;
		this.quantity=quantity;
		this.trans_date=trans_date;
		this.reason=reason;
		this.userid=userid;
		this.unit_cost=unit_cost;
	}
	
	//stock_id,item_id,type,quantity,trans_date,reason,userid,unit_cost 
	
	@Id
	@GeneratedValue
	@Column(name="stock_id")
	private int stock_id;
	
	@Column(name="item_id")
	private int item_id;
	
	
	@Column(name="type")
	private String type;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="trans_date")
	private String trans_date;

	@Column(name="reason")
	private String reason;	
	
	@Column(name="userid")
	private int userid;
	
	@Column(name="unit_cost")
	private float unit_cost;

	public int getStock_id() {
		return stock_id;
	}

	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getTrans_date() {
		return trans_date;
	}

	public void setTrans_date(String trans_date) {
		this.trans_date = trans_date;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public float getUnit_cost() {
		return unit_cost;
	}

	public void setUnit_cost(float unit_cost) {
		this.unit_cost = unit_cost;
	}		
}
