package com.example.golfscore;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class GolfScore extends Activity implements OnClickListener{

	private static final String TAG = "GolfScore";
	Button buttonSub, buttonAdd, buttonOK, buttonPref;
	TextView Score, textScoreCard;
    int score = 0;
    
	@SuppressWarnings("unused")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_golf_score);
        
        
        //debug tagging
        Log.d(TAG, "onCreate started");
     
      //declaration of xml variables     
        buttonOK = (Button)findViewById(R.id.buttonOK);
        buttonAdd= (Button)findViewById(R.id.buttonAdd);
        buttonSub=(Button)findViewById(R.id.buttonSub);
        buttonPref=(Button)findViewById(R.id.Pref);
        Score=(TextView)findViewById(R.id.Score);
        textScoreCard=(TextView)findViewById(R.id.textScoreCard);
        
     //initialize text views
        Score.setText(String.valueOf(score));
        textScoreCard.setText("");
        
     //Define button listeners
        buttonOK.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonPref.setOnClickListener(this);
        
     // Set preference
        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(this);
        
    }


  
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.golf_score, menu);
        return true;
    }

@Override
	public void onClick(View src) {
		switch(src.getId()){
		case R.id.buttonOK:
			textScoreCard.append("\nYou played " + score);
			score=0;
			Score.setText(String.valueOf(score));
			break;
		case R.id.buttonSub:
			score--;
			Score.setText(String.valueOf(score));
			break;
		case R.id.buttonAdd:
			Score.setText(String.valueOf(score));
			score++;
			break;
		case R.id.Pref:
			Intent i = new Intent(this, Preference.class);
			startActivity(i);
			break;
	}
	}   
}
