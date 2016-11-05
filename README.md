# App Shortcuts

#### Android 7.1 App Shortcus API Example

#####Developer can publish two different types of shortcuts for your app:

*Static shortcuts are defined in a resource file that is packaged into an APK. 
  
  ```
  <?xml version="1.0" encoding="utf-8"?>
<shortcuts xmlns:android="http://schemas.android.com/apk/res/android">
    <shortcut
        android:shortcutId="compose"
        android:enabled="true"
        android:icon="@mipmap/ic_launcher"
        android:shortcutShortLabel="@string/str_short_label"
            android:shortcutLongLabel="@string/str_long_label"
        android:shortcutDisabledMessage="@string/str_disable_message">
        <intent
        android:action="android.intent.action.VIEW"
        android:targetPackage="com.example.pranay.appshortcut"
        android:targetClass="com.example.pranay.appshortcut.ShortCutActivity" />
        <!-- If your shortcut is associated with multiple intents, include them
             here. The last intent in the list is what the user sees when they
             launch this shortcut. -->
        <categories android:name="android.shortcut.conversation" />
    </shortcut>
    <!-- Add more shortcuts here. -->
</shortcuts>
  ```

*Dynamic shortcuts are published at runtime using the ShortcutManager API. During runtime, your app can publish, update, and remove its dynamic shortcuts.
  
  ```
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
  ```


for more: https://developer.android.com/preview/shortcuts.html
