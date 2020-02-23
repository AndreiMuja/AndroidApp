package com.example.andreimuja.electricianIndex;

import android.os.AsyncTask;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.StringTokenizer;

public class CitireDateJSON extends AsyncTask<String,Integer,Boolean>{

    @Override
    protected Boolean doInBackground(String... strings) {
        StringTokenizer stringTokenizer;
        try{
            URL url=new URL(strings[0]);
            HttpURLConnection conn= (HttpURLConnection) url.openConnection();
            InputStream stream=conn.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(stream));
            StringBuilder json=new StringBuilder();
            String line;
            while((line=reader.readLine())!=null){
                json.append(line);
            }
            JSONArray jsonArray=new JSONArray(json.toString());
            for(int i=0;i<jsonArray.length();i++){
                JSONObject obj= (JSONObject) jsonArray.get(i);
                Calendar calendar=Calendar.getInstance();
                IndexContor indexContor=new IndexContor();
                indexContor.setNume((String) obj.get("nume"));
                indexContor.setNrKilowati((Integer) obj.get("nrKilowati"));
                if(obj.get("tip").equals("citit")){
                    indexContor.setTipInregistrare(TipInregistrare.citit);
                }else if(obj.get("tip").equals("estimat")){
                    indexContor.setTipInregistrare(TipInregistrare.estimat);
                }
                stringTokenizer=new StringTokenizer((String) obj.get("data"),":");
                calendar.set(Integer.parseInt(stringTokenizer.nextToken()),Integer.parseInt(stringTokenizer.nextToken()),Integer.parseInt(stringTokenizer.nextToken()));
                indexContor.setData(calendar);
                MainActivity.list.add(indexContor);
            }
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
