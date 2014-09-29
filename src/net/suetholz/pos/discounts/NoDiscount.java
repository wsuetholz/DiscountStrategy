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
public class NoDiscount implements DiscountStrategy {

    @Override
    public double getDiscountAmount(int quantityPurchased, double unitCost) {
	return 0.0;
    }

}
