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
 * This class encapsulates the Point of Sale Register Information
 *
 * @author wsuetholz
 * @version 1.00
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

    /**
     * Returns the current value of what store this register is assigned to
     *
     * @return store
     */
    public final StoreStrategy getStore() {
	return store;
    }

    /**
     * Sets the current store this register is assigned to.
     *
     * Validates store to be non-null
     *
     * @param store
     *
     * @throws IllegalArgumentException if store is null.
     */
    public final void setStore(StoreStrategy store) {
	if (store == null) {
	    throw new IllegalArgumentException("Store can not be null!");
	}
	this.store = store;
    }

    /**
     * Gets the sale being currently rung up.
     *
     * @return current sale
     */
    public final SaleStrategy getCurrentSale() {
	return currentSale;
    }

    /**
     * Get the current input strategy for a sale line item for this register.
     *
     * @return Current Line Item Input Strategy
     */
    public final SaleInputStrategy getLineInput() {
	return lineInput;
    }

    /**
     * Sets the input strategy for a sale line item for this register.
     *
     * Validates lineInput to be non-null
     *
     * @param lineInput
     *
     * @throws IllegalArgumentException if lineInput is null.
     */
    public final void setLineInput(SaleInputStrategy lineInput) {
	if (receiptOutput == null) {
	    throw new IllegalArgumentException("Receipt Output can not be null!");
	}
	this.lineInput = lineInput;
    }

    /**
     * Gets the receipt output strategy
     *
     * @return current receipt output strategy
     */
    public SaleOutputStrategy getReceiptOutput() {
	return receiptOutput;
    }

    /**
     * Sets the current receipt output strategy for this register
     *
     * @param receiptOutput
     */
    public final void setReceiptOutput(SaleOutputStrategy receiptOutput) {
	if (receiptOutput == null) {
	    throw new IllegalArgumentException("Receipt Output can not be null!");
	}
	this.receiptOutput = receiptOutput;
    }

    /**
     * Sets up the register for starting a new sale.
     */
    public final void beginNewSale() {

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
