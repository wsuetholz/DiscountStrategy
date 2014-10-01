/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos.entries;

import net.suetholz.pos.api.LineItemStrategy;
import net.suetholz.pos.api.PosEntryStrategy;
import net.suetholz.pos.api.SaleOutputStrategy;
import net.suetholz.pos.api.SaleStrategy;
import net.suetholz.pos.api.StoreStrategy;

/**
 *
 * @author wsuetholz
 */
public class PosEntryProductNQuantity implements PosEntryStrategy {

    LineItemStrategy lineItem;

    public PosEntryProductNQuantity(LineItemStrategy lineItem) {
	setLineItem(lineItem);
    }

    public LineItemStrategy getLineItem() {
	return lineItem;
    }

    public void setLineItem(LineItemStrategy lineItem) {
	if (lineItem == null) {
	    throw new IllegalArgumentException();
	}
	this.lineItem = lineItem;
    }

    @Override
    public void processEntry(StoreStrategy store, SaleStrategy sale, SaleOutputStrategy receiptOutput) {
	if (sale == null) {
	    throw new IllegalArgumentException();
	}
	sale.addLineItem(lineItem);
    }

}
