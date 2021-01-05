package com.webadds.WebAdds.pojos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.webadds.WebAdds.validation.MatchField;

@MatchField(firstFieldName="password", 
secondFieldName="confirmPassword", 
message="Password and Confirm password should be same")
public class ApplicationUser {

	private int id;
	
	@NotNull(message="Name is Required")
	@Size(min=1, message="Name is Required")
	private String name;
	
	@NotNull(message="Email is Required")
	@Size(min=1, message="Email is Required")
	private String emailId;
	
	@NotNull(message="Password is Required")
	@Size(min=1, message="Password is Required")
	private String password;
	
	@NotNull(message="Confirm password is Required")
	@Size(min=1, message="Confirm password is Required")
	private String confirmPassword;
	
	@NotNull(message="First name is Required")
	@Size(min=1, message="Firts name is Required")
	private String firstName;
	
	@NotNull(message="Last name is Required")
	@Size(min=1, message="Last name is Required")
	private String lastName;
	
	@NotNull(message="Address is Required")
	@Size(min=1, message="Address is Required")
	private String address;
	
	@NotNull(message="Country is Required")
	@Size(min=1, message="Country is Required")
	private String country;
	
	@NotNull(message="Mobile No is Required")
	@Size(min=1, message="Mobile No is Required")
	private String mobileNo;
	
	private int points;

	public ApplicationUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApplicationUser(int id, String name, String emailId, String password, String firstName, String lastName,
			String address, String country, String mobileNo, String confirmCassword, int points) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.country = country;
		this.mobileNo = mobileNo;
		this.confirmPassword = confirmCassword;
		this.points = points;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "ApplicationUser [id=" + id + ", name=" + name + ", emailId=" + emailId + ", password=" + password
				+ ", confirmCassword=" + confirmPassword + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", country=" + country + ", mobileNo=" + mobileNo + "]";
	}

}
