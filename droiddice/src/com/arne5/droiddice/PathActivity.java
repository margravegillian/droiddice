package com.arne5.droiddice;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class PathActivity extends Activity implements OnClickListener{

	
	DiceSpinListener misc = new DiceSpinListener();
	DieGroup Die = new DieGroup();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_path);
		
		
		
		Button rolld8 = (Button) findViewById(R.id.btnroll);
        
	    rolld8.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.path, menu);
		return true;
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Die.Sides=8;
		Die.Quantity = 1;
		Die.Adder=0;
		Die.Multiplier=0;
		int diceTotal = Die.roll();
		
		EditText d8total = (EditText) findViewById(R.id.etResult);
		StringBuilder d8TotalStr = new StringBuilder();
		d8TotalStr.append(diceTotal);
		d8total.setText(d8TotalStr);
		
		
		
	}

}
