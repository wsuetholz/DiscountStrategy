/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos.store;

import net.suetholz.pos.api.SaleStrategy;
import net.suetholz.pos.api.StoreStrategy;
import net.suetholz.pos.sales.BasicSale;

/**
 *
 * @author wsuetholz
 */
public class BasicStore implements StoreStrategy {

    private String greeting;
    private String thankYou;
    private String name;
    private String location;
    private double taxRate;
    
    public BasicStore (String name, String location, String greeting, String thankYou, double taxRate) {
	setName(name);
	setLocation(location);
	setGreeting(greeting);
	setThankYou(thankYou);
	setTaxRate(taxRate);
    }
 
    public void setGreeting(String greeting) {
	if (greeting == null) {
	    throw new IllegalArgumentException();
	}

	this.greeting = greeting;
    }

    public void setThankYou(String thankYou) {
	if (thankYou == null) {
	    throw new IllegalArgumentException();
	}

	this.thankYou = thankYou;
    }

    public void setName(String name) {
	if (name == null) {
	    throw new IllegalArgumentException();
	}

	this.name = name;
    }

    public void setLocation(String location) {
	if (location == null) {
	    throw new IllegalArgumentException();
	}

	this.location = location;
    }

    public void setTaxRate(double taxRate) {
	if (taxRate < 0.0) {
	    throw new IllegalArgumentException();
	}

	this.taxRate = taxRate;
    }

    @Override
    public String getGreeting() {
	return greeting;
    }

    @Override
    public String getThankYou() {
	return thankYou;
    }

    @Override
    public String getName() {
	return name;
    }

    @Override
    public String getLocation() {
	return location;
    }

    @Override
    public double getTaxRate() {
	return taxRate;
    }

    @Override
    public SaleStrategy allocateSale() {
	BasicSale newSale = new BasicSale();
	
	return newSale;
    }

    @Override
    public void newSale(SaleStrategy sale) {
	if (sale == null) {
	    throw new IllegalArgumentException();
	}
	
	sale.clearSale();
    }

    @Override
    public void saveSale(SaleStrategy sale) {
	if (sale == null) {
	    throw new IllegalArgumentException();	    
	}
    }

    @Override
    public void voidSale(SaleStrategy sale) {
	if (sale == null) {
	    throw new IllegalArgumentException();	    
	}
    }
    
}
