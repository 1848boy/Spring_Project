package com.project.Shopping.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customerdetails")
public class Users {

	private String name;
	@Id
	private String email;
	private String password;
	private String mobileno;
	private String address;
	private String pincode;

	public Users() {
		super();
	}

	public Users(String name, String email, String password, String mobileno, String address, String pincode) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileno = mobileno;
		this.address = address;
		this.pincode = pincode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getmobileno() {
		return mobileno;
	}

	public void setmobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Users [name=" + name + ", email=" + email + ", password=" + password + ", mobileno=" + mobileno
				+ ", address=" + address + ", pincode=" + pincode + "]";
	}

}
