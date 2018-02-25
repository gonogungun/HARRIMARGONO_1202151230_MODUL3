package com.example.android.harrimargono_1202151230_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    //membuat variable untuk button dan edit text
    Button btn;
    EditText usr,pass;

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        //menyambungkan variable yang dibuat sebelumnya dengan edit text dan button pada layout
        usr = (EditText) findViewById(R.id.usr);
        pass = (EditText) findViewById(R.id.pw);
        btn = (Button) findViewById(R.id.btn_signin);


        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {


                if (usr.getText().toString().equals("EAD") && pass.getText().toString().equals("MOBILE")) {
                    displayToast("Sign in Berhasil");
                    Intent intent1 = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent1);


                }
            }


        });


    }

}
