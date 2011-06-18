package com.simm.williwin;

public class GameSystemFactory {
	
	public static final int TYPE_DOUBLE_2 = 1;
	
	private GameSystemFactory() {}
	public static GameSystem create(int type){
		return new GameSystem() {
			
			private RouletteColour nextColour = RouletteColour.BLACK;
			
			@Override
			public void modifyBet(Bet bet) {
				bet.money = bet.money * 2;
			}
			
			@Override
			public Bet getFirstBet(int money) {
				if (nextColour == RouletteColour.RED)
					nextColour = RouletteColour.BLACK;
				else
					nextColour = RouletteColour.RED;
				return new Bet(new Event(nextColour), money);
			}
		};
	};
}
