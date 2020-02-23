package com.example.andreimuja.electricianIndex;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    static List<IndexContor> list;
    Context context;
    boolean ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.textDespre);
        list=new Vector<>();
        context=this;
        ok=true;
    }

    public void indexNou(View view) {
        Intent intent=new Intent(MainActivity.this,IndexNou.class);
        startActivity(intent);
    }

    public void istoricIndescsi(View view) {
        Intent intent=new Intent(MainActivity.this,IstoricIndecsi.class);
        startActivity(intent);
    }

    public void despre(View view) {
        Toast.makeText(MainActivity.this,getString(R.string.anunt)+" "+textView.getText().toString().subSequence(10,textView.getText().toString().length()-5),Toast.LENGTH_LONG).show();
    }

    public void preluare(View view) {
        if(ok){
            CitireDateJSON citireDateJSON=new CitireDateJSON();
            citireDateJSON.execute("link");
            ok=false;
        }else{
            Toast.makeText(MainActivity.this,getString(R.string.eroareDate),Toast.LENGTH_LONG).show();
        }
    }
}
