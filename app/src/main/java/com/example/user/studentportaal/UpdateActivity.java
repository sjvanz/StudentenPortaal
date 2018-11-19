package com.example.user.studentportaal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {
    public EditText mUrlInput;
    public EditText mTitleInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        mUrlInput = findViewById(R.id.inputUrlField);
        mTitleInput = findViewById(R.id.inputTitleField);

        Button saveBtn = findViewById(R.id.saveResourceBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = mUrlInput.getText().toString();
                String title = mTitleInput.getText().toString();
                Portal newPortal = new Portal(url, title);

                //Prepare the return parameter and return
                Intent resultIntent = new Intent();
                resultIntent.putExtra(MainActivity.ADD_PORTAL, newPortal);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
