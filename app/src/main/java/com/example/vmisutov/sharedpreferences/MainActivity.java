package com.example.vmisutov.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView currScore;
    private TextView hiScore;
    private int cur;
    private int highestRate;
    public static final String PREFSZ = "ScorePrefz";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SharedPreferences storedData = getSharedPreferences(PREFSZ, 0);
        cur = storedData.getInt("currentRate", 0);
        highestRate = storedData.getInt("highestRate", 0);
        Log.e("err", "curr = " + cur);
        Log.e("err", "cur2r = " + highestRate);

        currScore = (TextView) findViewById(R.id.currScore);
        hiScore = (TextView) findViewById(R.id.hiScore);


        //currScore.setText(cur + "");
          currScore.setText(Integer.toString(cur));

      //  currScore.setText(cur);
    }

    public void add(View view) {
        cur++;
        currScore = (TextView) findViewById(R.id.currScore);
        currScore.setText(Integer.toString(cur));
    }

    protected void save() {
        SharedPreferences storedData = getSharedPreferences(PREFSZ, 0);
        SharedPreferences.Editor storedDataEditor = storedData.edit();
        storedDataEditor.putInt("currentRate", cur);
        storedDataEditor.putInt("highestRate", highestRate);
        Log.e("err", "t1 = " + cur);
        Log.e("err", "t2 = " + highestRate);
        storedDataEditor.commit();

    }
    @Override    protected void onStop() {
        super.onStop();
        this.save();
    }
    public void clearcurr(View view) {
        cur=0;
        currScore = (TextView) findViewById(R.id.currScore);
        currScore.setText(Integer.toString(cur));
    }
    public void clearall(View view) {
        highestRate =0;
        hiScore = (TextView) findViewById(R.id.currScore);
        hiScore.setText(Integer.toString(highestRate));
    }


}
