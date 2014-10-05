/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos.sales;

import net.suetholz.pos.api.CustomerStrategy;
import net.suetholz.pos.api.LineItemStrategy;
import net.suetholz.pos.api.SaleStrategy;
import net.suetholz.pos.api.StoreStrategy;

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
    private double amountTendered;
    
    public BasicSale () {
	complete = false;
	lineItems = new LineItemStrategy[ARRAY_ELEMENTS];
	numItems = 0;
	customer = null;
	amountTendered = 0.0;
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
    public String getGreeting(StoreStrategy store) {
	return customer.getGreeting(store);
    }

    @Override
    public String getThankYou(StoreStrategy store) {
	return customer.getThankYou(store);
    }

    @Override
    public int getLineItemsLength() {
	return numItems;
    }

    @Override
    public String getLineItemId(int index) {
	if (index < 0 || index >= numItems) {
	    throw new IllegalArgumentException();
	}
	
	return lineItems[index].getProductId();
    }

    @Override
    public String getLineItemDesc(int index) {
	if (index < 0 || index >= numItems) {
	    throw new IllegalArgumentException();
	}
	
	return lineItems[index].getProductDesc();
    }

    @Override
    public double getLineItemUnitPrice(int index) {
	if (index < 0 || index >= numItems) {
	    throw new IllegalArgumentException();
	}
	
	return lineItems[index].getUnitCost();
    }

    @Override
    public int getLineItemQuantity(int index) {
	if (index < 0 || index >= numItems) {
	    throw new IllegalArgumentException();
	}
	
	return lineItems[index].getQuantity();
    }

    @Override
    public double getLineItemExtendedAmount(int index) {
	if (index < 0 || index >= numItems) {
	    throw new IllegalArgumentException();
	}
	
	return lineItems[index].getExtendedAmount();
    }

    @Override
    public double getLineItemDiscountAmount(int index) {
	if (index < 0 || index >= numItems) {
	    throw new IllegalArgumentException();
	}
	
	return lineItems[index].getDiscountAmount();
    }

    @Override
    public double getSubTotalAmount() {
	double subTotal = 0.0;
	
	for (int i = 0; i < numItems; i++) {
	    subTotal += lineItems[i].getExtendedAmount();
	}
	
	return subTotal;
    }

    @Override
    public double getTotalTaxAmount(StoreStrategy store) {
	if (store == null) {
	    throw new IllegalArgumentException();
	}

	return ((getTotalSaleAmount() * store.getTaxRate()) / 100.0);
    }

    @Override
    public double getTotalDiscountAmount() {
	double discountAmount = 0.0;
	
	for (int i = 0; i < numItems; i++) {
	    discountAmount += lineItems[i].getDiscountAmount();
	}
	
	return discountAmount;
    }

    @Override
    public double getTotalSaleAmount() {
	return (getSubTotalAmount() - getTotalDiscountAmount());
    }

    @Override
    public double getTotalAmountDue(StoreStrategy store) {
	if (store == null) {
	    throw new IllegalArgumentException();
	}

	return (getTotalSaleAmount() + getTotalTaxAmount(store)) ;
    }

    @Override
    public void setAmountTendered(double amountTendered) {
	if (amountTendered < 0.0) {
	    throw new IllegalArgumentException();
	}
	
	this.amountTendered = amountTendered;
	this.complete = true;
    }

    @Override
    public double getAmountTenderd() {
	return amountTendered;
    }

    @Override
    public double getChangeAmount(StoreStrategy store) {
	if (store == null) {
	    throw new IllegalArgumentException();
	}

	double amountDue = getTotalAmountDue(store);
	if (amountTendered < amountDue) {
	    throw new IllegalArgumentException();
	}
	
	return (amountDue - amountTendered);
    }

    @Override
    public boolean isComplete() {
	return complete;
    }
    
    @Override
    public void clearSale() {
	complete = false;
	amountTendered = 0.0;
	for (int i = 0; i < numItems; i++) {
	    lineItems[i] = null;
	}
	numItems = 0;
    }
    
}
