package com.example.andreimuja.electricianIndex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;
import java.util.Vector;

public class IstoricIndecsi extends AppCompatActivity {

    ListView listView;
    List<String> lista=new Vector<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_istoric_indecsi);
        listView=(ListView)findViewById(R.id.listaIndescsi);

        ordonare();
        populare();

        ListAdapter listAdapter=new ArrayAdapter<>(IstoricIndecsi.this,R.layout.support_simple_spinner_dropdown_item,lista);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(IstoricIndecsi.this,getString(R.string.numarKilowati)+""+MainActivity.list.get(position).getNrKilowati()
                +getString(R.string.tipInregistrare)+""+MainActivity.list.get(position).getTipInregistrare().toString()
                +getString(R.string.data)+""+MainActivity.list.get(position).getData().getTime(),Toast.LENGTH_LONG).show();
            }
        });
    }

    private void ordonare() {
        boolean ok;
        IndexContor indexContor;
        do {
            ok=true;
            for (int i = 0; i < MainActivity.list.size() - 1; i++) {
                if (MainActivity.list.get(i).getData().compareTo(MainActivity.list.get(i + 1).getData()) == -1) {
                    indexContor = MainActivity.list.get(i);
                    MainActivity.list.set(i, MainActivity.list.get(i + 1));
                    MainActivity.list.set(i + 1, indexContor);
                    ok=false;
                }
            }
        }while(!ok);
    }

    private void populare() {
        for(int i=0;i<MainActivity.list.size();i++){
            lista.add(MainActivity.list.get(i).getNume());
        }
    }
}
