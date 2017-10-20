package com.example.ina.eai;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DetailActivity extends AppCompatActivity {

    private TextView title, cost, capacity, dek1, dek2, dek3, dek4, dek5,
            dek6;
    private ImageView thumbnail;

    public static final String URL = "http://169.254.235.251/eai/getdatajualan.php?tagger=";
    public static final String ARRAY = "result";
    public static final String NAMA = "nama";
    public static final String HARGA = "harga";
    public static final String UNTUK = "untuk";
    public static final String DESK1 = "des1";
    public static final String DESK2 = "des2";
    public static final String DESK3 = "des3";
    public static final String DESK4 = "des3";
    public static final String DESK5 = "des4";
    public static final String DESK6 = "des5";
    public static final String ID = "id";

    Intent intent;
    Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        title = (TextView) findViewById(R.id.name);
        cost = (TextView) findViewById(R.id.price);
        capacity = (TextView) findViewById(R.id.note);
        dek1 = (TextView) findViewById(R.id.d1);
        dek2 = (TextView) findViewById(R.id.d2);
        dek3 = (TextView) findViewById(R.id.d3);
        dek4 = (TextView) findViewById(R.id.d4);
        dek5 = (TextView) findViewById(R.id.d5);
        dek6 = (TextView) findViewById(R.id.d6);
        thumbnail = (ImageView) findViewById(R.id.thumbnail);

        intent = getIntent();
        bundle = intent.getExtras();

        getData();
    }

    public void getData() {
        String tagger = bundle.get("tag").toString();
        String url = URL + tagger;
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String x = "";
                String xx = "";
                String xxx = "";
                String xxxx = "";
                String xxxxx = "";
                String xxxxxx = "";
                String xxxxxxx = "";
                String xxxxxxxx = "";
                String xxxxxxxxx = "";

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray result = jsonObject.getJSONArray(ARRAY);
                    JSONObject coldata = result.getJSONObject(0);
                    x = coldata.getString(NAMA);
                    xx = coldata.getString(HARGA);
                    xxx = coldata.getString(UNTUK);
                    xxxx = coldata.getString(DESK1);
                    xxxxx = coldata.getString(DESK2);
                    xxxxxx = coldata.getString(DESK3);
                    xxxxxxx = coldata.getString(DESK4);
                    xxxxxxxx = coldata.getString(DESK5);
                    xxxxxxxxx = coldata.getString(DESK6);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                title.setText(x);
                cost.setText(xx);
                capacity.setText(xxx);
                dek1.setText(xxxx);
                dek2.setText(xxxxx);
                dek3.setText(xxxxxx);
                dek4.setText(xxxxxxx);
                dek5.setText(xxxxxxxx);
                dek6.setText(xxxxxxxxx);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(DetailActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

}
