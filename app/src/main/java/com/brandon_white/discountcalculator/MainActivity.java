package com.brandon_white.discountcalculator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.text.DecimalFormat;


public class MainActivity extends ActionBarActivity {

    EditText eText1, eText2;
    Button btn1;
    TextView answerView, answerView2;
    double uInput1,discountPercent, uInput2, itemPrice, calcAnswer, discountAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        eText1 = (EditText)findViewById(R.id.userDiscount);//user input for discount amount
        eText2 = (EditText)findViewById(R.id.userPrice);//user input for item amount
        answerView = (TextView)findViewById(R.id.discountAnswer);
        answerView2 = (TextView)findViewById(R.id.discountAnswer2);
        btn1 = (Button)findViewById(R.id.calcBtn);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat formatter = new DecimalFormat("$#,##0.00");

                uInput1 = Double.valueOf(eText1.getText().toString());
                discountPercent = uInput1 * .01;

                uInput2 = Double.valueOf(eText2.getText().toString());
                itemPrice = uInput2;

                calcAnswer = itemPrice - (itemPrice * discountPercent);
                discountAmount = itemPrice * discountPercent;

                answerView.setText("Your discount is: " + formatter.format(discountAmount));
                answerView2.setText("Price after discount: " + formatter.format(calcAnswer));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
