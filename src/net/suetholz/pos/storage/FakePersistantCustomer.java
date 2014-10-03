/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos.storage;

import net.suetholz.pos.api.CustomerStrategy;

/**
 *
 * @author wsuetholz
 */
public class FakePersistantCustomer {
    
    private String id;
    private String name;
    private FakePersistantCustomerType custType;
    private String discId;
    private CustomerStrategy customer;
    
    public FakePersistantCustomer ( String id, String name, FakePersistantCustomerType custType, String discId ) {
	this.id = id;
	this.name = name;
	this.custType = custType;
	this.discId = discId;
	this.customer = null;
    }

    public String getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public FakePersistantCustomerType getCustType() {
	return custType;
    }

    public String getDiscId() {
	return discId;
    }

    public void setCustomer(CustomerStrategy customer) {
	this.customer = customer;
    }
    
    public CustomerStrategy getCustomer() {
	return customer;
    }

}
