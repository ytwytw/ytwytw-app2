package com.ytwytw.test2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by YtwYtw on 3/11/2015.
 */
public class Setting extends Activity implements View.OnClickListener{

    EditText server_addr;
    EditText server_port;
    EditText server_username;
    EditText server_password;
    Button server_login;
    Button server_clear;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        server_addr = (EditText) findViewById(R.id.et_Setting_ServerAddress);
        server_port = (EditText) findViewById(R.id.et_Setting_ServerPort);
        server_username = (EditText) findViewById(R.id.et_Setting_Username);
        server_password = (EditText) findViewById(R.id.et_Setting_Password);
        server_login = (Button) findViewById(R.id.b_Setting_Login);
        server_clear = (Button) findViewById(R.id.b_Setting_Clear);

        server_login.setOnClickListener(this);
        server_clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b_Setting_Login:
                Toast.makeText(context, "Login", Toast.LENGTH_SHORT).show();
                break;
            case R.id.b_Setting_Clear:
                Toast.makeText(context, "Clear", Toast.LENGTH_SHORT).show();
                server_addr.setText("");
                server_port.setText("");
                server_username.setText("");
                server_password.setText("");
                break;
        }
    }
}
