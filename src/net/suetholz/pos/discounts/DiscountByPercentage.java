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
public class DiscountByPercentage implements DiscountStrategy {

    double pctgDiscountPerItem;

    public DiscountByPercentage(double pctgDiscountPerItem) {
	setPctgDiscountPerItem(pctgDiscountPerItem);
    }

    public double getPctgDiscountPerItem() {
	return pctgDiscountPerItem;
    }

    public void setPctgDiscountPerItem(double pctgDiscountPerItem) {
	if (pctgDiscountPerItem < 0.0) {
	    pctgDiscountPerItem = 0.0;
	}
	this.pctgDiscountPerItem = pctgDiscountPerItem;
    }

    @Override
    public double getDiscountAmount(int quantityPurchased, double unitCost) {
	if (quantityPurchased < 0) {
	    throw new IllegalArgumentException("QuantityPurchased must be greater then 0");
	}
	if (unitCost < 0.0) {
	    throw new IllegalArgumentException("UnitCost must be greater then 0.0");
	}

	return ((unitCost * pctgDiscountPerItem) * quantityPurchased);
    }

}
