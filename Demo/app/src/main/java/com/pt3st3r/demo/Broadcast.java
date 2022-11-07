package com.pt3st3r.demo;

import static android.content.Context.MODE_PRIVATE;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Broadcast extends BroadcastReceiver {
    Intent intent;
    String toUser;
    String amount;
    Context context;

    @Override
    public void onReceive(Context context, Intent intent) {
        this.intent = intent;
        this.context = context;
        getData();
    }

    private void getData() {
        Bundle bundle = intent.getExtras();
        toUser = bundle.get("toUser").toString();
        amount = bundle.get("amount").toString();
        sendMoney();
    }

    private void sendMoney() {
        Toast.makeText(context, "Send " + amount + "$ to " + toUser + " success", Toast.LENGTH_LONG).show();
    }
}
