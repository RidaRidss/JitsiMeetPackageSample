package com.jitsimeetpackagesample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.jitsi.meet.sdk.JitsiMeet;
import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

public class ExampleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        // Initialize default options for Jitsi Meet conferences.
        URL serverURL;
        try {
            serverURL = new URL("https://meet.jit.si");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Invalid server URL!");
        }
        Log.d("JITSI CLIENT", "JITSI CLIENT: URL WORKED");

        JitsiMeetConferenceOptions defaultOptions
                = new JitsiMeetConferenceOptions.Builder()
                .setWelcomePageEnabled(true)
                .setServerURL(serverURL)
                .build();
        JitsiMeet.setDefaultConferenceOptions(defaultOptions);
        Log.d("JITSI CLIENT", "JITSI CLIENT: GOT TO END OF ON CREATE");
    }

    public void onButtonClick(View v) {
        try {
        Log.d("JITSI CLIENT", "JITSI CLIENT: BUTTON CLICKED");
           EditText editText = findViewById(R.id.conferenceName);
        String text = editText.getText().toString();

        Log.d("JITSI CLIENT", "JITSI CLIENT: TEXT FOUND " + text);

        if (text.length() > 0) {
            // Build options object for joining the conference. The SDK will merge the default
            // one we set earlier and this one when joining.
            JitsiMeetConferenceOptions options
                    = new JitsiMeetConferenceOptions.Builder()
                .setRoom(text)
                    .build();
            // Launch the new activity with the given options. The launch() method takes care
            // of creating the required Intent and passing the options.
            Log.d("JITSI CLIENT", "JITSI CLIENT: STARTING ACTIVITY");
            JitsiMeetActivity.launch(this, text);
        }
        } catch (RuntimeException e) {
            e.printStackTrace();
            Log.d("JITSI CLIENT", "JITSI CLIENT: ACTIVITY CONNECTION FAILED");
            throw new RuntimeException("Connection Failed");
        }
      
    }
}