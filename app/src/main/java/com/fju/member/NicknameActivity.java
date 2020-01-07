package com.fju.member;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class NicknameActivity extends AppCompatActivity {

    private EditText ednickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);
        ednickname = findViewById(R.id.nickname);


    }
    public void next(View view){
        String nickname = ednickname.getText().toString();
        if(nickname.isEmpty()){
            new AlertDialog.Builder(this)
                    .setTitle("number")
                    .setMessage("暱稱欄位不可為空白")
                    .setPositiveButton("ok",null)
                    .show();
        }else {
//            Intent intent = getIntent();
//            intent.putExtra("nickname",nickname);
//            setResult(RESULT_OK,intent);
            getSharedPreferences("number",MODE_PRIVATE)
                    .edit()
                    .putString("nickname",nickname)
                    .apply();
            Intent intent2 = new Intent(this,AgeActivity.class);
            startActivity(intent2);

        }
    }
}
