package com.webadds.WebAdds.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="assignrecords")
public class AssignRecord {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private int userId;
	private int addId;
	private int points;
	private int isSeen;
	private int isClaimed;
	public AssignRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AssignRecord(int id, int userId, int addId, int points, int isClaimed) {
		super();
		this.id = id;
		this.userId = userId;
		this.addId = addId;
		this.points = points;
		this.isClaimed = isClaimed;
		this.isSeen = 0;
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
	public int getAddId() {
		return addId;
	}
	public void setAddId(int addId) {
		this.addId = addId;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int isClaimed() {
		return isClaimed;
	}
	public void setClaimed(int isClaimed) {
		this.isClaimed = isClaimed;
	}
	public int getIsSeen() {
		return isSeen;
	}
	public void setIsSeen(int isSeen) {
		this.isSeen = isSeen;
	}
	public int getIsClaimed() {
		return isClaimed;
	}
	public void setIsClaimed(int isClaimed) {
		this.isClaimed = isClaimed;
	}
	@Override
	public String toString() {
		return "AssignRecord [id=" + id + ", userId=" + userId + ", addId=" + addId + ", points=" + points + ", isSeen="
				+ isSeen + ", isClaimed=" + isClaimed + "]";
	}
	
	
	
	
}
