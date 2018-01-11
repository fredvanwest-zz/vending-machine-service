package com.vanwest.Vending.Machine.Service;

import java.util.ArrayList;
import java.util.List;

public class Sleeve {
	
	private List<Item> items = new ArrayList<>();
	
	public Sleeve(Item item, int qty) throws Exception {
		if(items == null) {
			items = new ArrayList<>();
		}
		if(qty <0) {
			throw new Exception("Invalid Quantity [" +qty + "]" );
		}
		for(int k=0; k<qty; k++) {
			items.add(item);
		}
	}
	
	public List<Item> getItems() {
		return items;
	}
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public Item removeItem() {
		if(items.size() > 0) {
			return items.remove(items.size()-1);
		} else {
			return null;
		}
	}

}
