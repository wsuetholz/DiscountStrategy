/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos.lineitem;

import net.suetholz.pos.Product;
import net.suetholz.pos.api.LineItemStrategy;

/**
 *
 * @author wsuetholz
 */
public class BasicLineItem implements LineItemStrategy {

    private Product product;
    private int quantity;

    public BasicLineItem (Product product, int quantity) {
	setProduct(product);
	setQuantity(quantity);
    }
    
    public void setProduct(Product product) {
	if (product == null) {
	    throw new IllegalArgumentException();
	}
	this.product = product;
    }
    
    @Override
    public Product getProduct() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getProductId() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getProductDesc() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setQuantity(int quantity) {
	if (quantity < 0) { 
	    throw new IllegalArgumentException();
	}
	this.quantity = quantity;
    }
    
    @Override
    public int getQuantity() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getUnitCost() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getDiscountAmount() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getExtendedAmount() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
