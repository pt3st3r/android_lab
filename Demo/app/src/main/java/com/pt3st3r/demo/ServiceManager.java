package com.pt3st3r.demo;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class ServiceManager extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startid) {
        Bundle bundle = intent.getExtras();
        String toUser = bundle.get("toUser").toString();
        String amount = bundle.get("amount").toString();
        Toast.makeText(this, "Send " + amount + "$ to " + toUser + " success", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

}
