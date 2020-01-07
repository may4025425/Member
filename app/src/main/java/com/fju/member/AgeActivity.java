package com.fju.member;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class AgeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        EditText edage = findViewById(R.id.age);
        String age = edage.getText().toString();
        Intent intent = getIntent();
        intent.putExtra("age",age);
        setResult(RESULT_OK,intent);
        if(age.isEmpty()){
            finish();
        }else {
            getSharedPreferences("number",MODE_PRIVATE)
                    .edit()
                    .putString("age",age)
                    .apply();
            Intent intent2 = new Intent(this,AgeActivity.class);
            startActivity(intent2);
        }
    }
}
