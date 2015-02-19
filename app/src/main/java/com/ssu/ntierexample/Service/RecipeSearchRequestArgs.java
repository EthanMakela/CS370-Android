package com.ssu.ntierexample.Service;

import com.ssu.ntierexample.Interface.IHttpCallbackListener;

/**
 * Created by Jeff on 2/19/15.
 */
public class RecipeSearchRequestArgs {
    private IHttpCallbackListener listener;
    private String url;

    public IHttpCallbackListener getListener() {
        return listener;
    }

    public void setListener(IHttpCallbackListener listener) {
        this.listener = listener;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
