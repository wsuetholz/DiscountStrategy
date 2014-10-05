/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos.output;

import net.suetholz.pos.api.SaleOutputStrategy;
import net.suetholz.pos.api.SaleStrategy;
import net.suetholz.pos.api.StoreStrategy;

/**
 *
 * @author wsuetholz
 */
public class ReceiptConsoleOuput implements SaleOutputStrategy {

    @Override
    public void outputReceipt(StoreStrategy store, SaleStrategy sale) {
	System.out.println(sale.getGreeting(store));
	System.out.println("---------------------------------------------------");
	int maxLineItems = sale.getLineItemsLength();
	for (int index = 0; index < maxLineItems; index++) {
	    System.out.println (sale.getLineItemId(index));
	    System.out.println (sale.getLineItemDesc(index));
	    System.out.println (sale.getLineItemQuantity(index));
	    System.out.println (sale.getLineItemUnitPrice(index));
	    System.out.println (sale.getLineItemExtendedAmount(index));
	    System.out.println (sale.getLineItemDiscountAmount(index));
	    System.out.println ("-------");
	    System.out.println (sale.getLineItemExtendedAmount(index) - sale.getLineItemDiscountAmount(index));
	    System.out.println();
	}
	System.out.println("====================================================");
	System.out.println(sale.getSubTotalAmount());
	System.out.println(sale.getTotalDiscountAmount());
	System.out.println(sale.getTotalDiscountAmount());
	System.out.println(sale.getTotalSaleAmount());
	System.out.println(sale.getTotalTaxAmount(store));
	System.out.println(sale.getTotalAmountDue(store));
	System.out.println("====================================================");
	System.out.println(sale.getAmountTenderd());
	System.out.println("----------------------------------------------------");
	System.out.println(sale.getChangeAmount(store));
    }
    
}
