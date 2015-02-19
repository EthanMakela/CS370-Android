package com.ssu.ntierexample.Parser;

import com.ssu.ntierexample.Model.RecipeModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

//
public class RecipeParser {
    // Converts a JSON string to a RecipeModel
    static public RecipeModel JSONtoModel(String input){
        RecipeModel model = new RecipeModel();
        JSONObject json;
        try {
            json = (JSONObject) new JSONTokener(input).nextValue();
            JSONArray array = json.getJSONArray("results");
            JSONObject recipe = array.getJSONObject(0);

            model.setName((String)recipe.get("name"));

        }catch(JSONException exception){
            exception.getCause();
        }

        return model;
    }
}
