/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos.api;

/**
 *
 * @author wsuetholz
 */
public interface SaleStrategy {

    public abstract CustomerStrategy getCustomer();

    public abstract void setCustomer(CustomerStrategy customer);

    public abstract LineItemStrategy[] getLineItems();

    public abstract void addLineItem(LineItemStrategy lineItem);

    public abstract double getSubTotalAmount();

    public abstract double getTotalTaxAmount();

    public abstract double getTotalDiscountAmount();

    public abstract double getTotalSaleAmount();

    public abstract void setAmountTendered(double amountTendered);

    public abstract double getAmountTenderd();

    public abstract double getChangeAmount();

    public abstract boolean isComplete();
}
