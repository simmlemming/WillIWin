package com.simm.williwin;

public class Bet {
	public final Event event;
	public int money;
	
	public Bet(Event event, int money) {
		this.event = event;
		this.money = money;
	}

	@Override
	public String toString() {
		return "Bet [event=" + event + ", money="
				+ money + "]";
	}
	
	
}
