package com.vanwest.Vending.Machine.Service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DispenserController {
	
	private Dispenser dispenser = new Dispenser();
	
	public DispenserController() {
		Item coke = new Item("can", "Coke");
		Item dietCoke = new Item("can", "Diet Coke");
		Item sprite = new Item("can", "Sprite");
		Item drPepper = new Item("can", "Dr. Pepper");
		Item dasani = new Item("bottle", "Dasani");
		try {
			dispenser.addSleeve(new Sleeve(coke, 3));
			dispenser.addSleeve(new Sleeve(dietCoke, 2));
			dispenser.addSleeve(new Sleeve(sprite, 1));
			dispenser.addSleeve(new Sleeve(drPepper, 2));
			dispenser.addSleeve(new Sleeve(dasani, 4));

		} catch (Exception e) {
			System.out.println("Something went wrong [" + e + "]");
		}
	}
	
	@RequestMapping(path="/beverage/{button}")
	public Item getBeverage(@PathVariable int button) throws Exception {
		return dispenser.dispense(button);
	}
	
	@RequestMapping(path="/inventory")
	public Dispenser inventory() {
		return dispenser;
	}
}
