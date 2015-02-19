package com.ssu.ntierexample.Interface;

import com.ssu.ntierexample.Model.RecipeModel;

// An interface to listen for the formatted (parsed) callback from a recipe API call over http
public interface IHttpCallbackListener {
    public void onRecipeCallback(RecipeModel model);
}
