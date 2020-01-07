package com.fju.member;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final int RC = 1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText ednickname = findViewById(R.id.nickname);
        String nickname = ednickname.getText().toString();
        EditText edage = findViewById(R.id.age);
        String age = ednickname.getText().toString();
        EditText edgender = findViewById(R.id.gender);
        String gender = ednickname.getText().toString();

        if(nickname.isEmpty()) {
            Intent intent = new Intent(this,NicknameActivity.class);
            startActivityForResult(intent,RC);
        } else {
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String nickname = getSharedPreferences("member",MODE_PRIVATE)
                .getString("nickname",null);
        int age = getSharedPreferences("member",MODE_PRIVATE)
                .getInt("age",0);
        String gender = getSharedPreferences("member",MODE_PRIVATE)
                .getString("gender",null);

    }
}
