package com.simm.williwin;

public class Event {
	public final int number;
	public final RouletteColour colour;
	
	public Event(int number, RouletteColour colour) {
		this.number = number;
		this.colour = colour;
	}

	public Event(int number) {
		this(number, RouletteColour.ANY);
		}
	public Event(RouletteColour colour) {
		this(-1, colour);
	}
	
	@Override
	public boolean equals(Object o) {
		if ( ! (o instanceof Event) ){
			return false;
		}
		Event e = (Event) o;
		boolean isNumberEquals = (this.number == -1) || (e.number == -1) || (this.number == e.number);
		boolean isColourEquals = (this.colour == RouletteColour.ANY) || (e.colour == RouletteColour.ANY) || (this.colour == e.colour);
		return isNumberEquals && isColourEquals;
	}

	@Override
	public int hashCode() {
		return 42;
	}

	@Override
	public String toString() {
		return "Event [number=" + number + ", colour=" + colour + "]";
	}
	
}
