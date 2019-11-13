package com.example.iletisimdeneme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Calendar;
import java.util.TimeZone;


public class MainActivity extends AppCompatActivity {
    isSwearing Sw;
    dateDatabase myDb;
    int deger;
    String tarih;
    EditText kullaniciAd, kullaniciMail , kullaniciMesaj , kullaniciKonu;
    Button gonderButton;
    String emailPattern = "[a-zA-Z0-9._-]+@[gmail]+\\.+[com]+";
    String emailPatternH = "[a-zA-Z0-9._-]+@[hotmail]+\\.+[com]+";
    String URL_POST = "http://89.252.178.118/iletisim";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Sw = new isSwearing();
        Date date1 = new Date();
        DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yy");
        final String tarih1 = dateFormat1.format(date1);
        myDb = new dateDatabase(getApplicationContext());
        kullaniciKonu = findViewById(R.id.kullaniciKonu);
        kullaniciAd = findViewById(R.id.kullaniciAd);
        kullaniciMail = findViewById(R.id.kullaniciMail);
        kullaniciMesaj = findViewById(R.id.kullaniciMesaj);
        gonderButton = findViewById(R.id.gonderButton);


        gonderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(kullaniciAd.length()==0){
                    kullaniciAd.setError("İsim kısmını lütfen doldurunuz!");
                }
                else if(kullaniciMail.length()==0){
                    kullaniciMail.setError("Mail kısmını lütfen doldurunuz!");
                }
                else if(kullaniciMesaj.length()==0){
                    kullaniciMesaj.setError("Lütfen mesaj giriniz!");
                }
                else if(kullaniciKonu.length()==0){
                    kullaniciKonu.setError("Lütfen konu kısmını doldurunuz!");
                }
                else{
                    if(kullaniciMail.getText().toString().trim().matches(emailPattern) || kullaniciMail.getText().toString().trim().matches(emailPatternH)){

                        if(Sw.isaFenasi(kullaniciAd.getText().toString())){
                            Intent intent = new Intent(getApplicationContext(),easterEgg.class);
                            startActivity(intent);
                            finish();
                        }


                        else if(Sw.ayazdaKalmisBekci(kullaniciMesaj.getText().toString()) && Sw.ayazdaKalmisBekci(kullaniciAd.getText().toString()) &&  Sw.ayazdaKalmisBekci(kullaniciKonu.getText().toString())){
                            // android volley
                            deger = myDb.getDB();
                            tarih = myDb.getDate();

                            //System.out.println("DEGERRRRRRRRRR ve TARİHHHHHHHHHHH" +deger+ "--" +tarih);
                            if(!tarih1.equals(tarih)){
                                deger = 0;
                                myDb.writeDb(deger);
                                apiConnect();
                                deger++;
                                myDb.writeDb(deger);
                            }else{
                                if(deger < 3){
                                    apiConnect();
                                    deger++;
                                    myDb.writeDb(deger);
                                }else{
                                    Toast.makeText(getApplicationContext(),"24 saat içinde sadece 3 kez mesaj atabilirsiniz", Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                        else
                            Toast.makeText(getApplicationContext(),"Küfürlü mesaj göndermediğiniz için teşekkür ederiz :)) ",Toast.LENGTH_SHORT).show();





                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Lütfen geçerli bir e-mail adresi giriniz.",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    private void apiConnect(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_POST, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Mesajınız iletilmiştir en kısa zamanda dönüş yapılacaktır", Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplication(),response,Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(),"basarili",Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error+"",Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(),"hatali",Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<String, String>();
                String kad = kullaniciAd.getText().toString();
                String kma = kullaniciMail.getText().toString();
                String mes = kullaniciMesaj.getText().toString();
                String konu = kullaniciKonu.getText().toString();
                String tar = "asdasd";
                //Date currentTime = Calendar.getInstance().getTime(); // Date veri tipi stirnge cast olabilir mi bir bak!!!!
                Date date = new Date();
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
                //dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+3:00"));
                String strDate =  dateFormat.format(date);
                //System.out.println(strDate);
                params.put("kad",kad);
                params.put("kma",kma);
                params.put("mes",mes);
                params.put("konu",konu);
                params.put("tar",strDate);
                return params;

            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }
}
