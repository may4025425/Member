package com.fju.member;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AgeActivity extends AppCompatActivity {

    private EditText edage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        edage = findViewById(R.id.age);

    }
    public void next(View view){
        String age = edage.getText().toString();
        if(age.isEmpty()){
            new AlertDialog.Builder(this)
                    .setTitle("number")
                    .setMessage("年齡欄位不可為空白")
                    .setPositiveButton("ok",null)
                    .show();
        }else {
            Intent intent = getIntent();
            intent.putExtra("age",age);
            setResult(RESULT_OK,intent);
            getSharedPreferences("number",MODE_PRIVATE)
                    .edit()
                    .putString("age",age)
                    .apply();
            Intent intent2 = new Intent(this,GenderActivity.class);
            startActivity(intent2);
        }
    }
}
