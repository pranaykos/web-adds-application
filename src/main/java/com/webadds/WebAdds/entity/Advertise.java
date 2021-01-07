package com.webadds.WebAdds.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "advertises")
public class Advertise {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String titleName;
	private String description;
	private String imagePath;
	private int points;
	private String createdBy;
	private int isAssigned;
	private Date createdOn;
	private int totalAssigned;
	private int totalView;

	@ManyToOne
	private Client client;

	public Advertise() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Advertise(int id, String titleName, String description, String imagePath, int points, String createdBy) {
		super();
		this.id = id;
		this.titleName = titleName;
		this.description = description;
		this.imagePath = imagePath;
		this.points = points;
		this.createdBy = createdBy;
		this.isAssigned = 0;
		this.createdOn = new Date();
		this.totalAssigned = 0;
		this.totalView = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getIsAssigned() {
		return isAssigned;
	}

	public void setIsAssigned(int isAssigned) {
		this.isAssigned = isAssigned;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public int getTotalAssigned() {
		return totalAssigned;
	}

	public void setTotalAssigned(int totalAssigned) {
		this.totalAssigned = totalAssigned;
	}

	public int getTotalView() {
		return totalView;
	}

	public void setTotalView(int totalView) {
		this.totalView = totalView;
	}

	@Override
	public String toString() {
		return "Advertise [id=" + id + ", titleName=" + titleName + ", description=" + description + ", imagePath="
				+ imagePath + ", points=" + points + ", createdBy=" + createdBy + ", isAssigned=" + isAssigned + "]";
	}

}
