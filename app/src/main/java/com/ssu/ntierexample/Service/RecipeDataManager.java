package com.ssu.ntierexample.Service;

import android.os.AsyncTask;

import com.ssu.ntierexample.Interface.IHttpCallbackListener;
import com.ssu.ntierexample.Model.RecipeModel;
import com.ssu.ntierexample.Parser.RecipeParser;

import org.json.JSONException;

import java.net.URL;


public class RecipeDataManager extends AsyncTask<RecipeSearchRequestArgs, String, RecipeModel> {
    private IHttpCallbackListener callback;

    @Override
    protected RecipeModel doInBackground(RecipeSearchRequestArgs... params) {
        // get parameter instance
        RecipeSearchRequestArgs args = params[0];

        // set instances from arg values
        callback = args.getListener();
        String urlString = args.getUrl();

        HttpRequestManager hrm = new HttpRequestManager();
        String response = "";

        try {
            //convert string to URL
            URL url = new URL(urlString);
            //make Http call
            response = hrm.initiateHttpGet(url.toURI());
        }catch(Exception exception){

        }

        //handle the response
        try {
            return RecipeParser.JSONtoModel(response);
        }
        catch(JSONException exception){

        }

        return null;
    }

    @Override
    protected void onPostExecute(RecipeModel recipeModel) {
        super.onPostExecute(recipeModel);
        // send the result back to the main UI thread
        callback.onRecipeCallback(recipeModel);
    }

}
