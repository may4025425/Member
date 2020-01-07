package com.fju.member;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class NicknameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);
        EditText ednickname = findViewById(R.id.nickname);
        String nickname = ednickname.getText().toString();
        Intent intent = getIntent();
        intent.putExtra("nickname",nickname);
        setResult(RESULT_OK,intent);
        if(nickname.isEmpty()){
            getSharedPreferences("number",MODE_PRIVATE)
                    .edit()
                    .putString("nickname",nickname)
                    .apply();
            Intent intent2 = new Intent(this,AgeActivity.class);
            startActivity(intent2);
        }else {
            finish();
        }

    }
}
