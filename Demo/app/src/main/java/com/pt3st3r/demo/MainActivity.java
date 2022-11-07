package com.pt3st3r.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.send);
        button.setOnClickListener(view -> {
            sendMoney();
        });


        Button broadcast = findViewById(R.id.broadcast);
        broadcast.setOnClickListener(view -> sendBroadcast());

        Button service = findViewById(R.id.service);
        service.setOnClickListener(view -> sendService());

    }

    private void sendMoney() {
        Intent sendMoney = new Intent(this, SendMoneyActivity.class);
        EditText toUser = findViewById(R.id.to_user);
        sendMoney.putExtra("toUser", toUser.getText());
        EditText amount = findViewById(R.id.amount_value);
        sendMoney.putExtra("amount", amount.getText());
        startActivity(sendMoney);
    }

    private void sendBroadcast() {
        Intent intent = new Intent();
        intent.setAction("com.pt3st3r.demo.SendMoney");
        EditText toUser = findViewById(R.id.to_user);
        intent.putExtra("toUser", toUser.getText());
        EditText amount = findViewById(R.id.amount_value);
        intent.putExtra("amount", amount.getText());
        sendBroadcast(intent);
    }

    private void sendService() {
        Intent intent = new Intent();
        intent.setAction("com.pt3st3r.demo.START_SERVICE");
        intent.setPackage("com.pt3st3r.demo");
        EditText toUser = findViewById(R.id.to_user);
        intent.putExtra("toUser", toUser.getText());
        EditText amount = findViewById(R.id.amount_value);
        intent.putExtra("amount", amount.getText());
        startService(intent);
    }


}