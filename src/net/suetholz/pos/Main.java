/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos;

import net.suetholz.pos.api.PersistantStorageStrategy;
import net.suetholz.pos.api.StoreStrategy;
import net.suetholz.pos.api.SaleInputStrategy;
import net.suetholz.pos.api.SaleOutputStrategy;
import net.suetholz.pos.input.FakeRegisterInput;
import net.suetholz.pos.output.ReceiptConsoleOuput;
import net.suetholz.pos.store.BasicStore;
import net.suetholz.pos.storage.FakePerstantStorage;


/**
 *
 * @author wsuetholz
 */
public class Main {
    public static void main(String[] args) {
	StoreStrategy store = new BasicStore();
	PersistantStorageStrategy storage = new FakePerstantStorage();
	SaleInputStrategy input = new FakeRegisterInput (storage);
	SaleOutputStrategy output = new ReceiptConsoleOuput ();
	PosRegister register = new PosRegister(100, store, input, output);
	
	FakeRegisterInput finput = (FakeRegisterInput)input;
	finput.addClearKey();
	finput.addCustomer("101");
	finput.addProductNQuantity("Prod001", 10);
	finput.addProductNQuantity("Prod002", 2);
	finput.addProductNQuantity("Prod001", 1);
	finput.addAmountTendered(10.00);
	finput.addClearKey();
	finput.addCustomer("102");
	finput.addProductNQuantity("Prod001", 10);
	finput.addProductNQuantity("Prod002", 2);
	finput.addProductNQuantity("Prod001", 1);
	finput.addAmountTendered(10.00);
	
	register.run();
    }
}
