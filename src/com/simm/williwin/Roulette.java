package com.simm.williwin;

import java.util.Random;

public class Roulette {

	public Event nextEvent(){
		Random r = new Random();
		int number = r.nextInt(37);
		RouletteColour colour;
		if (number == 0)
			colour = RouletteColour.GREEN;
		else if (number < 17)
			colour = RouletteColour.RED;
		else
			colour = RouletteColour.BLACK;
		return new Event(number, colour);
	}
}
