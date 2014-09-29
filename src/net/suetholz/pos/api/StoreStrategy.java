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
public interface StoreStrategy {

    public abstract String getGreeting();

    public abstract String getThankYou();

    public abstract String getName();

    public abstract String getLocation();

    public abstract SaleStrategy newSale();
    
    public abstract void saveSale ( SaleStrategy sale );
    
    public abstract void voidSale ( SaleStrategy sale );
}
