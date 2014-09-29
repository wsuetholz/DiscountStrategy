/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos.discounts;

import net.suetholz.pos.api.DiscountStrategy;

/**
 *
 * @author wsuetholz
 */
public class DiscountByQuantity implements DiscountStrategy {
    int minQuantity;
    double discountAmount;

    public DiscountByQuantity(int minQuantity, double discountAmount) {
	setMinQuantity(minQuantity);
	setDiscountAmount(discountAmount);
    }

    public int getMinQuantity() {
	return minQuantity;
    }

    public void setMinQuantity(int minQuantity) {
	if (minQuantity < 0) {
	    minQuantity = 0;
	}
	this.minQuantity = minQuantity;
    }

    public double getDiscountAmount() {
	return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
	if (discountAmount < 0.0) {
	    discountAmount = 0.0;
	}
	this.discountAmount = discountAmount;
    }

    @Override
    public double getDiscountAmount(int quantityPurchased, double unitCost) {
	if (quantityPurchased < 0) {
	    throw new IllegalArgumentException("QuantityPurchased must be greater then 0");
	}
	if (unitCost < 0.0) {
	    throw new IllegalArgumentException("UnitCost must be greater then 0.0");
	}

	double result = 0.0;
	if (quantityPurchased < minQuantity) {
	    return result;
	}

	result = discountAmount;

	return result;
    }
    
}
