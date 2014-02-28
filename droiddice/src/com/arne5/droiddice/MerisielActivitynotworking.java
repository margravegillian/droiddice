package com.arne5.droiddice;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MerisielActivitynotworking extends Activity implements OnClickListener {
	DiceSpinListener misc = new DiceSpinListener(); // need this to implement the dice spinner listener
	DieGroup Die = new DieGroup();
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.optionmenu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	    case R.id.menuAbout:
	    	Intent about = new Intent("org.openintents.action.SHOW_ABOUT_DIALOG");
	    	try {
	    		startActivityForResult(about, 0);
	    	}
	    	catch(ActivityNotFoundException e) {
	    		AlertDialog.Builder notFoundBuilder = new AlertDialog.Builder(this);
	    		notFoundBuilder.setMessage(R.string.aboutNotFoundText)
	    				.setTitle(R.string.aboutNotFoundTitle)
	    				.setPositiveButton(R.string.commonYes, new DialogInterface.OnClickListener() {
	    					public void onClick(DialogInterface dialog, int id) {
	    						try{
	    							Intent getApp = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.urlAboutMarket)));
	    							startActivity(getApp);
	    						}
	    						catch(ActivityNotFoundException e) {
	    							Intent getAppAlt = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.urlAboutWeb)));
	    							startActivity(getAppAlt);
	    						}
	    					}
	    				})
	    				.setNegativeButton(R.string.commonNo, new DialogInterface.OnClickListener() {
	 	    	           public void onClick(DialogInterface dialog, int id) {
	 	    	                dialog.cancel();
	 	    	           }
	 	    	       });
	    		AlertDialog notFound = notFoundBuilder.create();
	    		notFound.show();
	    	}
	    	return true;
	    case R.id.menuHelp:
	    	AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
	    	builder1.setMessage(R.string.menuHelpDice)
	    	       .setTitle(R.string.menuHelp)
	    	       .setNegativeButton(R.string.commonClose, new DialogInterface.OnClickListener() {
	    	           public void onClick(DialogInterface dialog, int id) {
	    	                dialog.cancel();
	    	           }
	    	       });
	    	AlertDialog help = builder1.create();
	    	help.show();
	    default:
	        return super.onOptionsItemSelected(item);
	    }
	}
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.merisiel); // set layout
        
        // capture spinner and attach listener
        Spinner dieSpinner = (Spinner) findViewById(R.id.rollSidesSpin);
        dieSpinner.setOnItemSelectedListener(misc);
        
        // ditto with the button
        Button rolld8 = (Button) findViewById(R.id.btnrolld8);
        
        rolld8.setOnClickListener(this);
        
    }
}
