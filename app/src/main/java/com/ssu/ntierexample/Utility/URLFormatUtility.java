package com.ssu.ntierexample.Utility;

/**
 * Created by Jeff on 2/19/15.
 */
public class URLFormatUtility {
    final static private String BASE_URL = "http://api.pearson.com:80/kitchen-manager/v1/recipes?apikey=YGsluANbspTBeXFe66jBsTEBOVV6Hls9&limit=1&ingredients-any=%1$s";

    static public String formatApiUrl(String params){
        String urlString = String.format(BASE_URL, params);
        return urlString;
    }
}
