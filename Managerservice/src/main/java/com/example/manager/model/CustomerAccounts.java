package com.example.manager.model;

public class CustomerAccounts {
	public int accno;
	public int cid;
	public String accttype;
	public int balance;
	
	public CustomerAccounts() {
		
	}

	public CustomerAccounts(int accno, int cid, String accttype, int balance) {
		super();
		this.accno = accno;
		this.cid = cid;
		this.accttype = accttype;
		this.balance = balance;
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getAccttype() {
		return accttype;
	}

	public void setAccttype(String accttype) {
		this.accttype = accttype;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
