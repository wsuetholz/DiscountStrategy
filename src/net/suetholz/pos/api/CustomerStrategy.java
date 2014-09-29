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
public interface CustomerStrategy {

    public abstract String getName();

    public abstract String getCreditCardLastFour();

    public abstract String getCustomerGreeting(StoreStrategy store);

    public abstract String getCustomerThankYou(StoreStrategy store);
}
