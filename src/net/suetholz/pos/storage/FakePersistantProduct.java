/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos.storage;

import net.suetholz.pos.Product;

/**
 *
 * @author wsuetholz
 */
public class FakePersistantProduct {

    private String id;
    private String description;
    private String department;
    private double unitPrice;
    private String discId;
    private Product product;

    public FakePersistantProduct(String id, String description, String department, double unitPrice, String discId ) {
	this.id = id;
	this.description = description;
	this.department = department;
	this.unitPrice = unitPrice;
	this.discId = discId;
	this.product = null;
    }

    public String getId() {
	return id;
    }

    public String getDescription() {
	return description;
    }

    public String getDepartment() {
	return department;
    }

    public double getUnitPrice() {
	return unitPrice;
    }

    public String getDiscId() {
	return discId;
    }

    public void setProduct(Product product) {
	this.product = product;
    }

    public Product getProduct() {
	return product;
    }
    
}
