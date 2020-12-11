package com.example.apilistarpaises;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.VoiceInteractor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.apilistarpaises.Adapter.AdapterCountry;
import com.example.apilistarpaises.Model.Country;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ActividadPrincipal extends AppCompatActivity {

    public ArrayList<Country> pais;
    String URL = "https://api.covid19api.com/summary";

    ListView lstCountry;

    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestQueue = Volley.newRequestQueue(this);

        EjecutarVolley();

    }

    public void EjecutarVolley ()
    {
        pais = new ArrayList<>();

        JsonObjectRequest datosVolley = new JsonObjectRequest(
                Request.Method.GET,URL,null,
                response ->
                {
                    try {
                        JSONArray arrayCountry = response.getJSONArray("Countries");
                        int size = arrayCountry.length();
                        for (int i = 0; i < size; i++)
                        {
                            JSONObject arrayCountryObjet = arrayCountry.getJSONObject(i);
                            pais.add(new Country(arrayCountryObjet.getString("Country"), arrayCountryObjet.getString("TotalConfirmed"),
                                    arrayCountryObjet.getString("TotalDeaths"), arrayCountryObjet.getString("Date")));
                        }

                        AdapterCountry adapterCountry = new AdapterCountry(this, pais);

                        lstCountry = findViewById(R.id.lvCountry);

                        lstCountry.setAdapter(adapterCountry);

                    } catch (JSONException e) {
                        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);
                    }
                },
                error ->
                {
                    String msj = "Mensaje de error: " + error.getMessage();
                    Toast.makeText(this, msj, Toast.LENGTH_LONG);
                }
        );

        requestQueue.add(datosVolley);
    }
}