package com.udacity.sandwichclub.utils;

import android.content.ContentValues;
import android.content.Context;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        Sandwich parsedSandwichData = new Sandwich();

        try {
            // Creates the base for the parsing of the sandwich data into an Object

            JSONObject parseSandwich = new JSONObject(json);

            // Begins parsing objects through the JSON into Objects

            JSONObject name = parseSandwich.getJSONObject("name");
            String mainName = name.getString("mainName");

            JSONArray altNames = name.getJSONArray("alsoKnownAs");
            ArrayList<String> altNamesList = new ArrayList<>();
            for (int i=0; i<altNames.length(); i++) {
                altNamesList.add(altNames.getString(i));
            }

            JSONArray ingredients = parseSandwich.getJSONArray("ingredients");
            ArrayList<String> ingredientsList = new ArrayList<>();
            for (int i=0; i<ingredients.length(); i++) {
                ingredientsList.add(ingredients.getString(i));
            }

            // Begins parsing keys through the JSON into keys
            String placeOfOrign = parseSandwich.getString("placeOfOrigin");
            String description = parseSandwich.getString("description");
            String image = parseSandwich.getString("image");

            // Return new Sandwich

            parsedSandwichData = new Sandwich(mainName, altNamesList, ingredientsList, placeOfOrign, description, image);



        } catch (JSONException e) {
            e.printStackTrace();
        }

        return parsedSandwichData;

    }
}
