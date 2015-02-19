package com.ssu.ntierexample.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ssu.ntierexample.Interface.IHttpCallbackListener;
import com.ssu.ntierexample.Model.RecipeModel;
import com.ssu.ntierexample.R;
import com.ssu.ntierexample.Service.RecipeDataManager;
import com.ssu.ntierexample.Service.RecipeSearchRequestArgs;
import com.ssu.ntierexample.Utility.URLFormatUtility;


public class SearchActivity extends Activity implements IHttpCallbackListener{
    private RecipeDataManager dataManager;
    private EditText inputText;
    private Button inputButton;
    private TextView recipeName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // Set instances of the controls from the UI in the code behind
        inputButton = (Button)findViewById(R.id.inputButton);
        inputText = (EditText)findViewById(R.id.input);
        recipeName = (TextView)findViewById(R.id.recipeName);

        // Create a click listener for the button
        inputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataManager = new RecipeDataManager();
                RecipeSearchRequestArgs args = new RecipeSearchRequestArgs();
                args.setUrl(URLFormatUtility.formatApiUrl(inputText.getText().toString()));
                args.setListener(SearchActivity.this);
                dataManager.execute(args);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // A 'concrete' implementation of the IHttpCallBackListener interface method
    @Override
    public void onRecipeCallback(RecipeModel model) {
        //handle the callback
        recipeName.setText(model.Name);
    }
}
