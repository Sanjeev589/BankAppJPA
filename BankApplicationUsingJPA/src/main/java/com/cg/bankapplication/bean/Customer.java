package com.cg.bankapplication.bean;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="Customers")
public class Customer {
	@Column(name="CUSTOMERID")
	private long customerId;
	
	
	@Column(name="CUSTOMERNAME")
	private String customerName;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="MOBILE")
	private long mobile;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Id
	@Column(name="ACCOUNTNO")
	@SequenceGenerator(name="accountNoSeq",sequenceName = "accountNoSeq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "accountNoSeq")
	private long accountNo;
	
	
	/**/
	
	
	@Column(name="BALANCE")
	private double balance;
	
	@Column(name="PIN")
	private int pin;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(long customerId, String customerName, String email, long mobile, String address, long accountNo,
			double balance, int pin) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.accountNo = accountNo;
		this.balance = balance;
		this.pin = pin;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "Customer\n [CustomerId=" + customerId + "\n CustomerName=" + customerName + "\n Email=" + email
				+ "\n Mobile=" + mobile + "\n Address=" + address + "\n AccountNo=" + accountNo + "\n Balance=" + balance
				+ "\n Pin=" + pin +"]\n\n";
	}	
}
