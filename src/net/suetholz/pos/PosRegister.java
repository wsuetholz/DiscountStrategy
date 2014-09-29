/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
employee/clerk
store id
register id
sale id
total sales by store and by customer
daily sales by store and customer
buy 3 get 1 discount
special discounts by customer
special store discounts
 */
package net.suetholz.pos;

import net.suetholz.pos.api.SaleInputStrategy;
import net.suetholz.pos.api.SaleOutputStrategy;
import net.suetholz.pos.api.SaleStrategy;
import net.suetholz.pos.api.StoreStrategy;

/**
 *
 * @author wsuetholz
 */
public class PosRegister {

    StoreStrategy store;
    SaleStrategy currentSale;
    SaleInputStrategy lineInput;
    SaleOutputStrategy receiptOutput;

    public PosRegister(StoreStrategy store, SaleInputStrategy lineInput, SaleOutputStrategy receiptOutput) {
	setStore(store);
	setLineInput(lineInput);
	setReceiptOutput(receiptOutput);
	currentSale = null;
    }

    public StoreStrategy getStore() {
	return store;
    }

    public void setStore(StoreStrategy store) {
	if (store == null) {
	    throw new IllegalArgumentException("Store can not be null!");
	}
	this.store = store;
    }

    public SaleStrategy getCurrentSale() {
	return currentSale;
    }

    public SaleInputStrategy getLineInput() {
	return lineInput;
    }

    public void setLineInput(SaleInputStrategy lineInput) {
	if (receiptOutput == null) {
	    throw new IllegalArgumentException("Receipt Output can not be null!");
	}
	this.lineInput = lineInput;
    }

    public SaleOutputStrategy getReceiptOutput() {
	return receiptOutput;
    }

    public void setReceiptOutput(SaleOutputStrategy receiptOutput) {
	if (receiptOutput == null) {
	    throw new IllegalArgumentException("Receipt Output can not be null!");
	}
	this.receiptOutput = receiptOutput;
    }

    public void beginNewSale() {
	
	// If there is an existing sale, then have the store object either 
	// save it or void it depending on if it was completed.  The Store
	// will want to keep a history of sales.
	if (currentSale != null) {
	    if (currentSale.isComplete()) {
		store.saveSale(currentSale);
	    } else {
		store.voidSale(currentSale);
	    }
	}
	
	// The Store object knows the proper way to start a new sale.
	currentSale = store.newSale();

    }
}
