package com.simm.williwin;

public class Statistics {
	
	public int firstBet,
				money,
				maxBet,
				minMoney,
				maxMoney,
				numOfIterations,
				numOfWins,
				numOfLoses;
	
	public Statistics(int firstBet){
		this.firstBet = firstBet;
		reset();
	}
	
	public void reset(){
		money = 0;
		maxBet = 0;
		numOfIterations = 0;
	}
	
	public void updateLose(Bet bet){
		numOfIterations++;
		maxBet = Math.max(maxBet, bet.money);
		money -= bet.money;
		minMoney = Math.min(minMoney, money);
		maxMoney = Math.max(maxMoney, money);
		numOfLoses++;
	}

	
	public void updateWin(Bet bet){
		numOfIterations++;
		maxBet = Math.max(maxBet, bet.money);
		money += bet.money;
		minMoney = Math.min(minMoney, money);
		maxMoney = Math.max(maxMoney, money);
		numOfWins++;
	}

	@Override
	public String toString() {
		int sum = numOfLoses + numOfWins;
		int winPct = sum == 0 ? 0 : numOfWins * 100 / sum;
		int losePct = sum == 0 ? 0 : numOfLoses * 100 / sum;
		return "Statistics [firstBet=" + firstBet + ", money=" + money
				+ ", maxBet=" + maxBet + ", minMoney=" + minMoney
				+ ", maxMoney=" + maxMoney + ", numOfIterations="
				+ numOfIterations + ", numOfWins=" + numOfWins + " (" + winPct + "%)" 
				+ ", numOfLoses=" + numOfLoses  + " (" + losePct + "%)" + "]";
	}


}
