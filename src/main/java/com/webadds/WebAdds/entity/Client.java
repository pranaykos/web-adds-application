package com.webadds.WebAdds.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String email;
	private String companyName;
	private String username;
	private String password;
	private int totalAdds;
	private String address;
	private String role;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
	private List<Advertise> advertises;

	public Client() {
		super();
		advertises = new ArrayList<Advertise>();
	}

	public Client(int id, String email, String companyName, String username, String password, String role,
			String address) {
		super();
		this.id = id;
		this.email = email;
		this.companyName = companyName;
		this.username = username;
		this.password = password;
		this.role = role;
		this.advertises = new ArrayList<>();
		this.address = address;
		this.totalAdds = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Advertise> getAdvertises() {
		return advertises;
	}

	public void setAdvertises(List<Advertise> advertises) {
		this.advertises = advertises;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getTotalAdds() {
		return totalAdds;
	}

	public void setTotalAdds(int totalAdds) {
		this.totalAdds = totalAdds;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", email=" + email + ", companyName=" + companyName + ", username=" + username
				+ ", password=" + password + ", role=" + role + "]";
	}

}
