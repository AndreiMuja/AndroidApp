package com.example.andreimuja.bilet1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class IndexNou extends AppCompatActivity {

    EditText nume;
    EditText nrKilowati;
    DatePicker datePicker;
    RadioGroup tip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_nou);
        nume=(EditText)findViewById(R.id.nume);
        nrKilowati=(EditText)findViewById(R.id.numarKilowati);
        datePicker=(DatePicker)findViewById(R.id.datePicker);
        tip=(RadioGroup)findViewById(R.id.radioGroup);
    }

    public void adauga(View view) {
        if(nume.getText().toString().equals("")||nrKilowati.getText().toString().equals("")||tip.getCheckedRadioButtonId()==-1)
            Toast.makeText(IndexNou.this,getString(R.string.eroareDate),Toast.LENGTH_LONG).show();
        else{
            Calendar calendar=Calendar.getInstance();
            IndexContor i=new IndexContor();
            i.setNume(nume.getText().toString());
            i.setNrKilowati(Integer.parseInt(nrKilowati.getText().toString()));
            if(((RadioButton)findViewById(tip.getCheckedRadioButtonId())).getText().toString().equals("Citit")){
                i.setTipInregistrare(TipInregistrare.citit);
            }else if(((RadioButton)findViewById(tip.getCheckedRadioButtonId())).getText().toString().equals("Estimat")){
                i.setTipInregistrare(TipInregistrare.estimat);
            }
            calendar.set(datePicker.getYear(),datePicker.getMonth(),datePicker.getDayOfMonth());
            i.setData(calendar);
            MainActivity.list.add(i);
            Toast.makeText(IndexNou.this,getString(R.string.confirmareAdaugat),Toast.LENGTH_LONG).show();
            nume.setText("");
            nrKilowati.setText("");
            tip.clearCheck();
        }
    }
}
