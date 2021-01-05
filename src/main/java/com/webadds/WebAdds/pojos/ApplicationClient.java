package com.webadds.WebAdds.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.webadds.WebAdds.entity.Advertise;
import com.webadds.WebAdds.validation.MatchField;

@MatchField(firstFieldName="password", 
secondFieldName="confirmPassword", 
message="Password and Confirm password should be same")
public class ApplicationClient {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotNull(message="Email is Required")
	@Size(min=1, message="Email is Required")
	private String email;
	
	@NotNull(message="Company name is Required")
	@Size(min=1, message="Company name is Required")
	private String companyName;
	
	@NotNull(message="Username is Required")
	@Size(min=1, message="Username is Required")
	private String username;
	
	@NotNull(message="Password is Required")
	@Size(min=1, message="Password is Required")
	private String password;
	
	@NotNull(message="Confirm password is Required")
	@Size(min=1, message="Confirm password is Required")
	private String confirmPassword;
	
	private String role;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="client")
	private List<Advertise> advertises;
	public ApplicationClient() {
		super();
		advertises = new ArrayList<Advertise>();
	}
	public ApplicationClient(int id, String email, String companyName, String username, String password, String role) {
		super();
		this.id = id;
		this.email = email;
		this.companyName = companyName;
		this.username = username;
		this.password = password;
		this.role = role;
		this.advertises = new ArrayList<>();
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
	@Override
	public String toString() {
		return "Client [id=" + id + ", email=" + email + ", companyName=" + companyName + ", username=" + username
				+ ", password=" + password + ", role=" + role + "]";
	}
	
}
