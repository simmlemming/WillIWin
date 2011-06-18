package com.simm.williwin;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class Main extends Activity {
	private final String TAG = "WillIWin";
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				go();
				
			}
		});
        
        
        go();
    }
    
    private void go(){
//      
        Roulette roulette = new Roulette();
//        for (int i = 0; i < 10; i++){
//        	Log.i(TAG, i + ". " + roulette.nextEvent());
//        }
//        
        
        int firstBet = 1;
        GameSystem system = GameSystemFactory.create(0);
        Bet bet = system.getFirstBet(firstBet);
        Statistics st = new Statistics(firstBet);
        for (int i = 0; i < 25; i++){
        	Event e = roulette.nextEvent();
        	Log.i(TAG, i + ". " + bet + ", " + e);
        	if (bet.event.equals(e)){
        		st.updateWin(bet);
        		bet = system.getFirstBet(firstBet);
        	} else {
        		st.updateLose(bet);
        		system.modifyBet(bet);
        	}
        	Log.i(TAG, "     " + st + "");
        }
        //Log.i(TAG, st + "");
    }
}