package com.example.pranay.appshortcut;

import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddAnotherShortcutDynamically();
    }

    private void AddAnotherShortcutDynamically() {
        ShortcutManager shortcutManager;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            shortcutManager = getSystemService(ShortcutManager.class);
            ShortcutInfo shortcut;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N_MR1) {
                shortcut = new ShortcutInfo.Builder(this, "second_shortcut")
                        .setShortLabel(getString(R.string.str_shortcut_two))
                        .setLongLabel(getString(R.string.str_shortcut_two_desc))
                        .setIcon(Icon.createWithResource(this, R.mipmap.ic_launcher))
                        .setIntent(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.google.co.in")))
                        .build();
                shortcutManager.setDynamicShortcuts(Arrays.asList(shortcut));
            }

            
        }
       
    }
}
