package com.sgatson.diceroll;

import java.util.Random;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;

public class DiceRollActivity extends Activity {

	Random Generator = new Random();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dice_roll);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dice_roll, menu);
		return true;
	}

	public void rollDice(View view) {
		EditText diceNumEditText = (EditText) findViewById(R.id.diceNumber);
        Spinner diceTypeSpinner = (Spinner) findViewById(R.id.diceType);
        EditText diceModEditText = (EditText) findViewById(R.id.diceMod);
        TextView rollTotalTextView = (TextView) findViewById(R.id.diceTotal);
        
        int diceNumber = Integer.parseInt(diceNumEditText.getText().toString());
        String diceType = diceTypeSpinner.getSelectedItem().toString();
        int diceModifier = Integer.parseInt(diceModEditText.getText().toString());
        
        int total = 0;
        
        if(diceType.equals("d4")) {
                total = roll(4, diceModifier, diceNumber);
        }
        else if(diceType.equals("d6")) {
                total = roll(6, diceModifier, diceNumber);
        }
        else if(diceType.equals("d8")) {
                total = roll(8, diceModifier, diceNumber);
        }
        else if(diceType.equals("d10")) {
                total = roll(10, diceModifier, diceNumber);
        }
        else if(diceType.equals("d12")) {
                total = roll(12, diceModifier, diceNumber);
        }
        else if(diceType.equals("d20")) {
                total = roll(20, diceModifier, diceNumber);
        }
        else if(diceType.equals("d100")) {
                total = roll(100, diceModifier, diceNumber);
        }
        
        rollTotalTextView.setText("" + Integer.toString(total));
	}
	
	public int roll(int DiceFaces, int DiceModifier) {
		return Generator.nextInt(DiceFaces) + 1 + DiceModifier;
	}
	
	public int roll(int DiceFaces, int DiceModifier, int NumberOfRolls) {
        int i = 0;
        int total = 0;
        while (i < NumberOfRolls) {
                total += Generator.nextInt(DiceFaces) + 1 + DiceModifier;
                i++;
        }
        return total;
	}
}
