/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos.storage;

import net.suetholz.pos.Product;
import net.suetholz.pos.api.CustomerStrategy;
import net.suetholz.pos.api.PersistantStorageStrategy;

/**
 *
 * @author wsuetholz
 */
public class FakePerstantStorage implements PersistantStorageStrategy {

    @Override
    public CustomerStrategy lookupCustomer(String customerId) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product lookupProduct(String productId) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
