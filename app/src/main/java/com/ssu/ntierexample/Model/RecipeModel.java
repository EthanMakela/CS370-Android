package com.ssu.ntierexample.Model;

import com.google.gson.annotations.SerializedName;

// An application model used to drive the SearchActivity view
public class RecipeModel {
    //added an 'Annotation' specifying the name of the JSON attribute that will be deserialized into
    //this property
    @SerializedName("name")
    public String Name;

    //Note that we had to remove the getters/setters for gson to work. This isn't problematic, but is
    //slightly less safe
}
