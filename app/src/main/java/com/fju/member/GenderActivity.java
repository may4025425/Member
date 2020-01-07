package com.fju.member;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class GenderActivity extends AppCompatActivity {

    private EditText edgender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        edgender = findViewById(R.id.gender);

    }
    public void next(View view){
        String gender = edgender.getText().toString();
        if(gender.isEmpty()){
            new AlertDialog.Builder(this)
                    .setTitle("number")
                    .setMessage("性別欄位不可為空白")
                    .setPositiveButton("ok",null)
                    .show();
        }else {
            Intent intent = getIntent();
            intent.putExtra("gender",gender);
            setResult(RESULT_OK,intent);
            getSharedPreferences("number",MODE_PRIVATE)
                    .edit()
                    .putString("gender",gender)
                    .apply();
            Intent intent2 = new Intent(this,MainActivity.class);
            intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent2);
        }
    }
}
