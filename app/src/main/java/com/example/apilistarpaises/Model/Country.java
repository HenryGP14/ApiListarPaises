package com.example.apilistarpaises.Model;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Country {
    private String country,  countryCode, slug, newConfirmed, totalConfirmed, newDeaths,
            totalDeaths, newRecovered, totalRecovered, date;

    public Country(String country, String totalConfirmed, String totalDeaths, String date) {
        this.country = country;
        this.totalConfirmed = totalConfirmed;
        this.totalDeaths = totalDeaths;
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getSlug() {
        return slug;
    }

    public String getNewConfirmed() {
        return newConfirmed;
    }

    public String getTotalConfirmed() {
        return totalConfirmed;
    }

    public String getNewDeaths() {
        return newDeaths;
    }

    public String getTotalDeaths() {
        return totalDeaths;
    }

    public String getNewRecovered() {
        return newRecovered;
    }

    public String getTotalRecovered() {
        return totalRecovered;
    }

    public String getDate() {
        return date;
    }
}
