package com.simm.williwin;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class Main extends Activity {
	private final String TAG = "WillIWin";
	TextView mTxtMoneyMin, mTxtMoneyMax, mTxtMoneyNow, mTxtBetFirst, mTxtBetMax, mTxtIterations;
    EditText mEditIterations, mEditFirstBet;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mTxtBetFirst = (TextView) findViewById(R.id.txtBetFirst);
        mTxtBetMax = (TextView) findViewById(R.id.txtBetMax);
        mTxtMoneyMax = (TextView) findViewById(R.id.txtMoneyMax);
        mTxtMoneyMin = (TextView) findViewById(R.id.txtMoneyMin);
        mTxtMoneyNow = (TextView) findViewById(R.id.txtMoneyNow);
        mEditFirstBet = (EditText) findViewById(R.id.editFirstBet);
        mEditIterations = (EditText) findViewById(R.id.editIterations);
        mTxtIterations = (TextView) findViewById(R.id.txtIterations);
        
        findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				go();
			}
		});
        go();
    }
    
    private void go(){
        Roulette roulette = new Roulette();
        int firstBet = Integer.parseInt(mEditFirstBet.getText().toString());
        int iterations = Integer.parseInt(mEditIterations.getText().toString());
        
        GameSystem system = GameSystemFactory.create(0);
        Bet bet = system.getFirstBet(firstBet);
        Statistics st = new Statistics(firstBet);
        for (int i = 0; i < iterations; i++){
        	Event e = roulette.nextEvent();
        	//Log.i(TAG, i + ". " + bet + ", " + e);
        	if (bet.event.equals(e)){
        		st.updateWin(bet);
        		bet = system.getFirstBet(firstBet);
        	} else {
        		st.updateLose(bet);
        		system.modifyBet(bet);
        	}
        	//Log.i(TAG, "     " + st + "");
        }
        showStatistisc(st);
        //Log.i(TAG, st + "");
    }
    
    private void showStatistisc(Statistics statistics){
    	mTxtBetFirst.setText(String.valueOf(statistics.firstBet));
    	mTxtBetMax.setText(String.valueOf(statistics.maxBet));
    	mTxtMoneyMax.setText(String.valueOf(statistics.maxMoney));
    	mTxtMoneyMin.setText(String.valueOf(statistics.minMoney));
    	mTxtMoneyNow.setText(String.valueOf(statistics.money));
    	mTxtIterations.setText(String.valueOf(statistics.numOfIterations));
    }
    
}