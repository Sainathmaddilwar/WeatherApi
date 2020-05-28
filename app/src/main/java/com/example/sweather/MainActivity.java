package com.example.sweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    globle globe;
    Button button;
    EditText city;
    //Context mcontext=getApplicationContext();
    //http://api.openweathermap.org/data/2.5/weather?q=Paris&appid=5f56d525d1619d0a2cd2eac4ce55588e

    String baseURL ="https://api.openweathermap.org/data/2.5/weather?q=";
    String API ="&appid=577b7d3e60200e91c523139eecab4f8b";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        city = (EditText) findViewById(R.id.editText);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myURL=baseURL+city.getText().toString()+API;


                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, myURL, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject jsonObject) {
                                Log.i("JSON", "JSON: " + jsonObject);
                                try {

                                    globe=new globle();
                                    String info = jsonObject.getString("weather");
                                    Log.i("INFO", "INFO: " + info);

                                    JSONArray ar = new JSONArray(info);
                                    String t = jsonObject.getString("main");
                                    JSONObject to = new JSONObject(t);
                                    int temp = to.getInt("temp");
                                    temp = temp - 273;
                                    String s=Integer.toString(temp);
                                    globe.setTemp(s);

                                    for (int i = 0; i < ar.length(); i++) {
                                        JSONObject parObj = ar.getJSONObject(i);
                                        String wet = parObj.getString("main");
                                        Log.i("main", "Main: " + wet);
                                        globe.setWeather(wet);

                                    }

                                    Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                                    intent.putExtra("tt",globe.getTemp());
                                    intent.putExtra("weather",globe.getWeather());
                                    startActivity(intent);
                                }
                                catch(JSONException e){
                                    e.printStackTrace();
                                }


//                                try {
//                                    String coor = jsonObject.getString("coord");
//                                    Log.i("COOR", "COOR: " + coor);
//                                    JSONObject co = new JSONObject(coor);
//
//                                    String lon = co.getString("lon");
//                                    String lat = co.getString("lat");
//
//                                    Log.i("LON", "LON: " + lon);
//                                    Log.i("LAT", "LAT: " + lat);
//
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                }


                            }
                        },

                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse (VolleyError volleyError){
                                Log.i("Error", "Something went wrong" + volleyError);

                            }
                        }




                );
                //   Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                // startActivity(intent);
             Mysingalton.getInstance(MainActivity.this).addToRequestQue(jsonObjectRequest);



            }

        });

    }

}
