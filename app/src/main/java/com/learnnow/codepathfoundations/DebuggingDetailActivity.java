package com.learnnow.codepathfoundations;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Detail page for the "Debugging" module.
 */
public class DebuggingDetailActivity extends AppCompatActivity {

    private ImageView iconDebugging;
    private TextView titleDebugging;
    private Button btnShare;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debugging_detail);

        setupActionBar();
        initViews();
        wireShare();
    }

    private void setupActionBar() {
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle("Debugging");
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initViews() {
        iconDebugging = findViewById(R.id.iconDebugging);
        titleDebugging = findViewById(R.id.titleDebugging);
        btnShare = findViewById(R.id.btnShareDebugging);
        titleDebugging.setText("Learn Debugging");
    }

    private void wireShare() {
        btnShare.setOnClickListener(v -> {
            String shareText = buildShareMessage();
            Intent send = new Intent(Intent.ACTION_SEND);
            send.setType("text/plain");
            send.putExtra(Intent.EXTRA_SUBJECT, "Learning Debugging");
            send.putExtra(Intent.EXTRA_TEXT, shareText);
            startActivity(Intent.createChooser(send, "Share via"));
        });
    }

    private String buildShareMessage() {
        return "I'm learning Debugging:\n"
                + "• Reproduce the bug\n"
                + "• Read stack traces\n"
                + "• Use breakpoints & logging\n"
                + "• Fix root cause, not symptom\n\n"
                + "Example:\nif (user != null) { /* ... */ }";
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}