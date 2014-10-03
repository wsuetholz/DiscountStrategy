/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos.sales;

import net.suetholz.pos.api.CustomerStrategy;
import net.suetholz.pos.api.LineItemStrategy;
import net.suetholz.pos.api.SaleStrategy;

/**
 *
 * @author wsuetholz
 */
public class BasicSale implements SaleStrategy {

    private static final int ARRAY_ELEMENTS = 10;
    private CustomerStrategy customer;
    private LineItemStrategy[] lineItems;
    private int numItems;
    private boolean complete;
    
    public BasicSale () {
	complete = false;
	lineItems = new LineItemStrategy[ARRAY_ELEMENTS];
	numItems = 0;
	customer = null;
    }
    
    @Override
    public CustomerStrategy getCustomer() {
	return customer;
    }

    @Override
    public void setCustomer(CustomerStrategy customer) {
	if (customer == null) {
	    throw new IllegalArgumentException();
	}
	this.customer = customer;
    }

    @Override
    public LineItemStrategy[] getLineItems() {
	return lineItems;
    }

    @Override
    public void addLineItem(LineItemStrategy lineItem) {
	if (lineItem == null) {
	    throw new IllegalArgumentException();
	}
	if (numItems >= lineItems.length) {
	    LineItemStrategy[] tempLineItems = new LineItemStrategy[lineItems.length+ARRAY_ELEMENTS];
	    for (int i = 0; i < numItems; i++) {
		tempLineItems[i] = lineItems[i];
	    }
	    lineItems = tempLineItems;
	}
	lineItems[numItems++] = lineItem;
    }

    @Override
    public double getSubTotalAmount() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getTotalTaxAmount() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getTotalDiscountAmount() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getTotalSaleAmount() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAmountTendered(double amountTendered) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getAmountTenderd() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getChangeAmount() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isComplete() {
	return complete;
    }
    
    @Override
    public void clearSale() {
	
    }
    
}
