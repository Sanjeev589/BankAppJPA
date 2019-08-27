package com.cg.bankapplication.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Transaction")
public class Transaction {
	@Id
	@Column(name="TRANSACTIONID")
	private String transactionId;
	
	@Column(name="TRANSACTIONTYPE")
	private String transactionType;
	
	@Column(name="CUSTOMERID")
	private long customerId;
	
	@Column(name="CUSTOMERACCOUNTNO")
	private long customerAccountNo;
	
	@Column(name="RECEIVERACCOUNTNO")
	private long receiverAccountNo;
	
	@Column(name="AMOUNT")
	private double amount;
	
	@Column(name="TRANSACTIONDETAILS")
	private String transactionDetails;
	
	
	@Column(name="TIME", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false, updatable=false)
	private String date;
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(String transactionId, String transactionType, long customerId, long customerAccountNo,
			long receiverAccountNo, double amount, String transactionDetails) {
		super();
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.customerId = customerId;
		this.customerAccountNo = customerAccountNo;
		this.receiverAccountNo = receiverAccountNo;
		this.amount = amount;
		this.transactionDetails = transactionDetails;
		//this.date = date;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public long getCustomerAccountNo() {
		return customerAccountNo;
	}
	public void setCustomerAccountNo(long customerAccountNo) {
		this.customerAccountNo = customerAccountNo;
	}
	public long getReceiverAccountNo() {
		return receiverAccountNo;
	}
	public void setReceiverAccountNo(long receiverAccountNo) {
		this.receiverAccountNo = receiverAccountNo;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTransactionDetails() {
		return transactionDetails;
	}
	public void setTransactionDetails(String transactionDetails) {
		this.transactionDetails = transactionDetails;
	}
	public String getDate() {
		return date;
	}
	/*public void setDate(String date) {
		this.date = date;
	}*/
	@Override
	public String toString() {
		return transactionId + "\t" + transactionType + "\t"
				+ customerId + "\t" + customerAccountNo + "\t" + receiverAccountNo
				+ "\t\t" + amount + "\t" + transactionDetails + "\t\t" + date + "\n";
		
	}
}
