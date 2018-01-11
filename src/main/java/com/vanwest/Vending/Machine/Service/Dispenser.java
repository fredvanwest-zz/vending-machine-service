package com.vanwest.Vending.Machine.Service;

import java.util.List;

import java.util.ArrayList;

public class Dispenser {
	
	List<Sleeve> sleeves = new ArrayList<>();
	
	public Dispenser() {}
	
	public Dispenser(List<Sleeve> sleeves) {
		this.sleeves = sleeves;
	}

	public List<Sleeve> getSleeves() {
		return sleeves;
	}

	public void setSleeves(List<Sleeve> sleeves) {
		this.sleeves = sleeves;
	}

	public void addSleeve(Sleeve sleeve) {
		this.sleeves.add(sleeve);
	}
	
	public Item dispense(int button) throws Exception {
		if(button < 0 || button >= sleeves.size()) {
			throw new Exception("Nothing corresponds to that button.");
		}
		if(sleeves.size() == 0) {
			// Light the empty button.
			return null;
		} 
		Sleeve sleeve = sleeves.get(button);
		return sleeve.removeItem();
	}
}
