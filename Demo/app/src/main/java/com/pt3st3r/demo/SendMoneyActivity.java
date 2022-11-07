package com.pt3st3r.demo;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SendMoneyActivity extends AppCompatActivity {
    String toUser;
    String amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_money);
        getData();
        sendMoney(toUser, amount);
    }

    private void getData() {
        Bundle bundle = getIntent().getExtras();
        toUser = bundle.get("toUser").toString();
        TextView toUserView = findViewById(R.id.to_user);
        toUserView.setText(toUser);


        amount = bundle.get("amount").toString();
        TextView amountView = findViewById(R.id.amount_value);
        amountView.setText(amount);
    }

    private void sendMoney(String toUser, String amount) {
        Toast.makeText(this, "Send " + amount + "$ to " + toUser + " success", Toast.LENGTH_LONG).show();
    }

}
