package com.coforge.microservices.Customersservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("customerservices")
@Component
public class LimitConfiguration {

	int minimum;
	int maximum;
	
	public LimitConfiguration(int maximum, int minimum) {
		this.minimum = minimum;
		this.maximum = maximum;

	}
	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	public int getMaximum() {
		return maximum;
	}
	
	

}
