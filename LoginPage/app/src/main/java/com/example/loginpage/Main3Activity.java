package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    EditText et1,et2;
    Button clearbtn,backbtn,convertBtn;
    Spinner sp1,sp2;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        sp1 =findViewById(R.id.spin1);
        sp2 =findViewById(R.id.spin2);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        clearbtn = findViewById(R.id.ClBtn);
        backbtn = findViewById(R.id.BackBtn);
        convertBtn = findViewById(R.id.ConBtn);

        List<String> currency = new ArrayList<String>();
        currency.add("CAD");
        currency.add("USD");
        currency.add("AUS");
        currency.add("INR");
        currency.add("EURO");
        currency.add("POUND");

        ArrayAdapter<String> curAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, currency);
        curAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        sp1.setAdapter(curAdapter);
        sp1.setOnItemSelectedListener(this);

        sp2.setAdapter(curAdapter);
        sp2.setOnItemSelectedListener(this);
        clearbtn.setOnClickListener(this);
        backbtn.setOnClickListener(this);
        convertBtn.setOnClickListener(this);


    }


    public void onClick(View v) {




        switch (v.getId())
        {
            case R.id.ConBtn:
                String sp00 = sp1.getSelectedItem().toString();
                String sp11 = sp2.getSelectedItem().toString();
                double amtTo;
                double amtFrom;

                if(!et1.getText().toString().trim().equals("")) {
                    switch (sp00) {
                        case "CAD":

                            switch (sp11) {

                                case "CAD":
                                    amtFrom = Double.parseDouble(et1.getText().toString());
                                    amtTo = amtFrom * 1;
                                    result = amtTo;

                                case "USD":
                                    amtFrom = Double.parseDouble(et1.getText().toString());
                                    amtTo = amtFrom * 0.75;
                                    result = amtTo;

                                case "AUS":
                                    amtFrom = Double.parseDouble(et1.getText().toString());
                                    amtTo = amtFrom * 1.11;
                                    result = amtTo;

                                case "INR":
                                    amtFrom = Double.parseDouble(et1.getText().toString());
                                    amtTo = amtFrom * 53.91;
                                    result = amtTo;

                                case "EURO":
                                    amtFrom = Double.parseDouble(et1.getText().toString());
                                    amtTo = amtFrom * 0.68;
                                    result = amtTo;

                                case "POUND":
                                    amtFrom = Double.parseDouble(et1.getText().toString());
                                    amtTo = amtFrom * 0.58;
                                    result = amtTo;


                            }
                    }
                }



            case R.id.ClBtn:
                Double Amt = new Double(result);
                et1.setText("");
                result = 0 ;
                break;

            case R.id.BackBtn:
                //making intent, intent is a transition between two activities
                Intent act = new Intent(getApplicationContext(),MainActivity.class);
                //starting an intent
                startActivity(act);

                // Toast.makeText(getApplicationContext(),"Invalid username and password", Toast.LENGTH_SHORT).show()

        }


    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
