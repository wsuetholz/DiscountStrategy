/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos.customer;

import net.suetholz.pos.api.CustomerStrategy;
import net.suetholz.pos.api.StoreStrategy;

/**
 *
 * @author wsuetholz
 */
public class PreferredCustomer implements CustomerStrategy {

    private final String DEFAULT_CCLASTFOUR = "";
    private final int CCLASTFOUR_MIN_LENGTH = 4;

    private String id;
    private String name;    // For our purposes, we just do not need this split into First, Middle, and Last
    private String ccLastFour;

    public PreferredCustomer(String id, String name) {
	setId(id);
	setName(name);
	ccLastFour = DEFAULT_CCLASTFOUR;
    }

    /**
     * Get the last 4 of the credit card number
     * 
     * @return last 4 of credit card number
     */
    public final String getCcLastFour() {
	return ccLastFour;
    }

    /**
     * Set the last 4 of the credit card number
     * 
     * @param ccLastFour 
     * @throws IllegalArgumentException when ccLastFour length < 4
     */
    public final void setCcLastFour(String ccLastFour) {
	if (ccLastFour == null || ccLastFour.length() < CCLASTFOUR_MIN_LENGTH) {
	    throw new IllegalArgumentException();
	}
	this.ccLastFour = ccLastFour;
    }

    /** 
     * Set the Preferred Customer ID
     * 
     * @param id 
     * @throws IllegalArgumentException if Id is null.
     */
    public final void setId(String id) {
	if (id == null) {
	    throw new IllegalArgumentException();
	}
	this.id = id;
    }
    
    /**
     * Get the Preferred Customer ID
     * 
     * @return customer ID
     */
    public final String getId() {
	return id;
    }
    
    /**
     * Set the Customer Name
     * 
     * @param name 
     * @throws IllegalArgumentException when name is null
     */
    public final void setName(String name) {
	if (name == null) {
	    throw new IllegalArgumentException();
	}
	this.name = name;
    }

    /**
     * Get the customer's name
     *
     * @return
     */
    @Override
    public String getName() {
	return this.name;
    }

    /** 
     * Get the last 4 of the credit card number
     * 
     * @return last 4 of the credit card number
     */
    @Override
    public String getCreditCardLastFour() {
	return this.ccLastFour;
    }

    /**
     * Get the customer greeting message
     * 
     * @param store
     * @return customer greeting
     */
    @Override
    public String getCustomerGreeting(StoreStrategy store) {
	StringBuilder str = new StringBuilder("");
	if (store != null) {
	    str.append(store.getGreeting());
	    str.append(" ");
	}
	if (this.name.length() > 0) {
	    str.append(this.name);
	}
	return str.toString();
    }

    /**
     * get the customer thank you message
     * @param store
     * @return customer thank you message
     */
    @Override
    public String getCustomerThankYou(StoreStrategy store) {
	StringBuilder str = new StringBuilder("");
	if (store != null) {
	    str.append(store.getThankYou());
	    str.append(" ");
	}
	return str.toString();
    }
    
}
