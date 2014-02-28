package com.arne5.droiddice;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MerisielActivity extends Activity implements OnClickListener {
	DiceSpinListener misc = new DiceSpinListener(); // need this to implement the dice spinner listener
	DieGroup Die = new DieGroup();
	public void onClick(View v) {
		

		// capture text boxes
				//TextView tNumDice = (TextView) findViewById(R.id.rollNumDice);
				//TextView tAdder = (TextView) findViewById(R.id.rollAdd);
				//TextView tMult = (TextView) findViewById(R.id.rollMult);
				
				// grab values from text boxes and spinner
				//Die.Sides = misc.getSelValue();
				try { // catch blank strings in the text boxes
					//Die.Quantity = Integer.valueOf(tNumDice.getText().toString());
					//Die.Adder = Integer.valueOf(tAdder.getText().toString());
					//Die.Multiplier = Integer.valueOf(tMult.getText().toString());
					Die.Sides=8;
					Die.Quantity = 1;
					Die.Adder=0;
					Die.Multiplier=0;
				}
				catch (NumberFormatException e) {
					Toast.makeText(this, R.string.errorInvalidEntry, Toast.LENGTH_SHORT).show();
				}
					
				if(Die.Quantity < 1) {
					// we can't roll less than one die
					Toast.makeText(this, R.string.errorNotEnoughDice, Toast.LENGTH_SHORT).show();
				}
				else {
					int diceTotal = Die.roll();
					
					EditText d8total = (EditText) findViewById(R.id.edResultd8);
					StringBuilder d8TotalStr = new StringBuilder();
					d8TotalStr.append(diceTotal);
					d8total.setText(d8TotalStr);
					
					// capture TextView for result and output total
					//TextView grandTotal = (TextView) findViewById(R.id.rollResult);
					//StringBuilder grandTotalStr = new StringBuilder();
					//grandTotalStr.append(diceTotal);
					//grandTotal.setText(grandTotalStr);
				}
		
		
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.optionmenu, menu);
		return true;
	}
	
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.merisiel); // set layout
        
        // capture spinner and attach listener
        Spinner dieSpinner = (Spinner) findViewById(R.id.rollSidesSpin);
        dieSpinner.setOnItemSelectedListener(misc);
        
        // ditto with the button
       // Button rolld8 = (Button) findViewById(R.id.btnrolld8);
        
       // rolld8.setOnClickListener(this);
        
    }
}
