package com.example.manager.model;

public class Manager {
   public String actyp;
   public int minbalance;
   public int roi;
   public Manager() {
	   
   }
public Manager(String actyp, int minbalance, int roi) {
	super();
	this.actyp = actyp;
	this.minbalance = minbalance;
	this.roi = roi;
}
public String getActyp() {
	return actyp;
}
public void setActyp(String actyp) {
	this.actyp = actyp;
}
public int getMinbalance() {
	return minbalance;
}
public void setMinbalance(int minbalance) {
	this.minbalance = minbalance;
}
public int getRoi() {
	return roi;
}
public void setRoi(int roi) {
	this.roi = roi;
}
   
}
