package com.arne5.droiddice;

import android.media.SoundPool;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.media.MediaPlayer;

import static android.media.MediaPlayer.*;

public class PathActivity extends Activity implements OnClickListener{

	
	DiceSpinListener misc = new DiceSpinListener();
	DieGroup Die = new DieGroup();
    MediaPlayer mp;


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
		
//		Die.Sides=12;
//		Die.Quantity = 1;
//		Die.Adder=0;
//		Die.Multiplier=0;
//		int diceTotal = Die.roll();
//
//		EditText d8total = (EditText) findViewById(R.id.etResult);
//		StringBuilder d8TotalStr = new StringBuilder();
//		d8TotalStr.append(diceTotal);
//		d8total.setText(d8TotalStr);


        // capture text boxes
       // TextView tNumDice = (TextView) findViewById(R.id.rollNumDice);
       // TextView tAdder = (TextView) findViewById(R.id.rollAdd);
       // TextView tMult = (TextView) findViewById(R.id.rollMult);

        //create sound
        MediaPlayer mp = MediaPlayer.create(this,R.raw.diethrow1);
        mp.start();

        // grab values from text boxes and spinner
        Die.Sides = 8 ; // misc.getSelValue();
        try { // catch blank strings in the text boxes
            Die.Quantity = 1;//Integer.valueOf(tNumDice.getText().toString());
            Die.Adder = 0; // Integer.valueOf(tAdder.getText().toString());
            Die.Multiplier = 1; //Integer.valueOf(tMult.getText().toString());
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

            // capture TextView for result and output total
           // TextView grandTotal = (TextView) findViewById(R.id.rollResult);
          //  StringBuilder grandTotalStr = new StringBuilder();
           // grandTotalStr.append(diceTotal);
          //  grandTotal.setText(grandTotalStr);

           	EditText d8total = (EditText) findViewById(R.id.etResult);
		    StringBuilder d8TotalStr = new StringBuilder();
        	d8TotalStr.append(diceTotal);
	    	d8total.setText(d8TotalStr);





        }
		
		
		
	}

}
