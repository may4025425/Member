package com.fju.member;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class GenderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        EditText edgender = findViewById(R.id.gender);
        String gender = edgender.getText().toString();
        Intent intent = getIntent();
        intent.putExtra("gender",gender);
        setResult(RESULT_OK,intent);
        if(gender.isEmpty()){
            getSharedPreferences("number",MODE_PRIVATE)
                    .edit()
                    .putString("gender",gender)
                    .apply();
            Intent intent2 = new Intent(this,AgeActivity.class);
            startActivity(intent2);
        }else {
            finish();
        }
    }
}
