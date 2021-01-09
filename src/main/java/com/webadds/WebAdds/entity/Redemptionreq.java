package com.webadds.WebAdds.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="redemptions")
public class Redemptionreq {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int userId;
	private int amount;
	private Date requestedOn;
	private int isAccepted;

	public Redemptionreq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Redemptionreq(int id, int userId, int amount) {
		super();
		this.id = id;
		this.userId = userId;
		this.amount = amount;
		this.requestedOn = new Date();
		this.isAccepted = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getRequestedOn() {
		return requestedOn;
	}

	public void setRequestedOn(Date requestedOn) {
		this.requestedOn = requestedOn;
	}

	public int getIsAccepted() {
		return isAccepted;
	}

	public void setIsAccepted(int isAccepted) {
		this.isAccepted = isAccepted;
	}

	@Override
	public String toString() {
		return "Redemptionreq [id=" + id + ", userId=" + userId + ", amount=" + amount + ", requestedOn=" + requestedOn
				+ ", isAccepted=" + isAccepted + "]";
	}

}
