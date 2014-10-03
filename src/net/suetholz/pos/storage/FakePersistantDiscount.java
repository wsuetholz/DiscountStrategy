/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos.storage;

import net.suetholz.pos.api.DiscountStrategy;

/**
 *
 * @author wsuetholz
 */
public class FakePersistantDiscount {

    private String id;
    private FakePersistantDiscountType discType;
    private String description;
    private int discNumber;
    private double discDouble;
    private DiscountStrategy discount;
    

    public FakePersistantDiscount(String id, FakePersistantDiscountType discType, String description, int discNumber, double discDouble) {
	this.id = id;
	this.discType = discType;
	this.description = description;
	this.discNumber = discNumber;
	this.discDouble = discDouble;
	this.discount = null;
    }

    public FakePersistantDiscountType getDiscType() {
	return discType;
    }

    public String getId() {
	return id;
    }
    
    public String getDescription() {
	return description;
    }
    
    public int getDiscNumber() {
	return discNumber;
    }

    public double getDiscDouble() {
	return discDouble;
    }

    public DiscountStrategy getDiscount() {
	return discount;
    }
   
    public void setDiscount(DiscountStrategy discount) {
	this.discount = discount;
    }
    
}
