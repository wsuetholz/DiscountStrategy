/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos.discounts;

import net.suetholz.pos.api.DiscountStrategy;

/**
 * Provide a Flat Dollar Amount Discount
 * 
 * @author wsuetholz
 * @version 1.0
 */
public class DiscountByFlatRate implements DiscountStrategy {

    double discountAmount;

    /**
     * Constructor for DiscountByFlatRate
     * 
     * @param discountAmount 
     */
    public DiscountByFlatRate(double discountAmount) {
	setDiscountAmount(discountAmount);
    }

    /** 
     * Get the Flat Discount Amount
     * 
     * @return discount amount
     */
    public final double getDiscountAmount() {
	return discountAmount;
    }

    /**
     * Set the flat discount amount
     * 
     * Validate discount amount >= 0.0, set to 0.0 if invalid
     * 
     * @param discountAmount 
     */
    public final void setDiscountAmount(double discountAmount) {
	if (discountAmount < 0.0) {
	    discountAmount = 0.0;
	}
	this.discountAmount = discountAmount;
    }

    /**
     * Calculate and return the total discount amount for this discount
     * 
     * @param quantityPurchased
     * @param unitCost
     * @return total calculated discount amount
     */
    @Override
    public double getDiscountAmount(int quantityPurchased, double unitCost) {
	if (quantityPurchased < 0) {
	    throw new IllegalArgumentException("QuantityPurchased must be greater then 0");
	}
	if (unitCost < 0.0) {
	    throw new IllegalArgumentException("UnitCost must be greater then 0.0");
	}

	return discountAmount;
    }

}
