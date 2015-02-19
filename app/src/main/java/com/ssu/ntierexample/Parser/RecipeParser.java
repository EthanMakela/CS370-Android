package com.ssu.ntierexample.Parser;

import com.google.gson.Gson;
import com.ssu.ntierexample.Model.RecipeModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

//
public class RecipeParser {
    // Converts a JSON string to a RecipeModel
    static public RecipeModel JSONtoModel(String input) throws JSONException {

        JSONObject json;
        Gson gson = new Gson();
        json = (JSONObject) new JSONTokener(input).nextValue();
        JSONArray array = json.getJSONArray("results");
        JSONObject recipe = array.getJSONObject(0);

        RecipeModel model = gson.fromJson(recipe.toString(), RecipeModel.class);

        return model;
    }
}
