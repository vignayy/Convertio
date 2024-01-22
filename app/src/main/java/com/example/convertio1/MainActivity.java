package com.example.convertio1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Spinner sp1,sp2;
    EditText ed1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp1 = findViewById(R.id.spfrom);
        sp2 = findViewById(R.id.spto);
        ed1 = findViewById(R.id.txtamt);


        String[] from = {"INR","USD", "EUR", "CNY", "JPY", "AUD"};
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, from);
        sp1.setAdapter(ad);


        String[] to = {"USD", "EUR", "CNY", "JPY", "AUD","INR"};
        ArrayAdapter<String> ad1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, to);
        sp2.setAdapter(ad1);


        b1 = findViewById(R.id.btn1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(ed1.getText().toString())){
                    ed1.setError("Enter Amount");
                    return;
                }
                Double tot = null;

                Double amt = Double.parseDouble(ed1.getText().toString());

                if(sp1.getSelectedItem().toString() == "INR"){
                    if(sp2.getSelectedItem().toString() == "USD") tot = amt * 0.012;
                    else if(sp2.getSelectedItem().toString() == "EUR") tot = amt * 0.011;
                    else if(sp2.getSelectedItem().toString() == "CNY") tot = amt * 0.088;
                    else if(sp2.getSelectedItem().toString() == "JPY") tot = amt * 1.75;
                    else if(sp2.getSelectedItem().toString() == "AUD") tot = amt * 0.018;
                    else if(sp2.getSelectedItem().toString() == "INR") tot = amt * 1;
                }else if(sp1.getSelectedItem().toString() == "USD"){
                    if(sp2.getSelectedItem().toString() == "USD") tot = amt * 1;
                    else if(sp2.getSelectedItem().toString() == "EUR") tot = amt * 0.92;
                    else if(sp2.getSelectedItem().toString() == "CNY") tot = amt * 7.24;
                    else if(sp2.getSelectedItem().toString() == "JPY") tot = amt * 143.59;
                    else if(sp2.getSelectedItem().toString() == "AUD") tot = amt * 1.50;
                    else if(sp2.getSelectedItem().toString() == "INR") tot = amt * 82.03;
                }else if(sp1.getSelectedItem().toString() == "EUR"){
                    if(sp2.getSelectedItem().toString() == "USD") tot = amt * 1.09;
                    else if(sp2.getSelectedItem().toString() == "EUR") tot = amt * 1;
                    else if(sp2.getSelectedItem().toString() == "CNY") tot = amt * 7.89;
                    else if(sp2.getSelectedItem().toString() == "JPY") tot = amt * 156.52;
                    else if(sp2.getSelectedItem().toString() == "AUD") tot = amt * 1.63;
                    else if(sp2.getSelectedItem().toString() == "INR") tot = amt * 89.42;
                }else if(sp1.getSelectedItem().toString() == "CNY"){
                    if(sp2.getSelectedItem().toString() == "USD") tot = amt * 0.14;
                    else if(sp2.getSelectedItem().toString() == "EUR") tot = amt * 0.13;
                    else if(sp2.getSelectedItem().toString() == "CNY") tot = amt * 1;
                    else if(sp2.getSelectedItem().toString() == "JPY") tot = amt * 19.84;
                    else if(sp2.getSelectedItem().toString() == "AUD") tot = amt * 0.21;
                    else if(sp2.getSelectedItem().toString() == "INR") tot = amt * 11.33;
                }else if(sp1.getSelectedItem().toString() == "JPY"){
                    if(sp2.getSelectedItem().toString() == "USD") tot = amt * 0.0070;
                    else if(sp2.getSelectedItem().toString() == "EUR") tot = amt * 0.0064;
                    else if(sp2.getSelectedItem().toString() == "CNY") tot = amt * 0.050;
                    else if(sp2.getSelectedItem().toString() == "JPY") tot = amt * 1;
                    else if(sp2.getSelectedItem().toString() == "AUD") tot = amt * 0.010;
                    else if(sp2.getSelectedItem().toString() == "INR") tot = amt * 0.57;
                }else if(sp1.getSelectedItem().toString() == "AUD"){
                    if(sp2.getSelectedItem().toString() == "USD") tot = amt * 0.67;
                    else if(sp2.getSelectedItem().toString() == "EUR") tot = amt * 0.61;
                    else if(sp2.getSelectedItem().toString() == "CNY") tot = amt * 4.83;
                    else if(sp2.getSelectedItem().toString() == "JPY") tot = amt * 95.84;
                    else if(sp2.getSelectedItem().toString() == "AUD") tot = amt * 1;
                    else if(sp2.getSelectedItem().toString() == "INR") tot = amt * 54.76;
                }
                assert tot != null;
                Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}