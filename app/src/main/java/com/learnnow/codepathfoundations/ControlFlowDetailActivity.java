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
 * Detail page for the "Control Flow" module.
 * Static content; can be refactored later to a generic loader.
 */
public class ControlFlowDetailActivity extends AppCompatActivity {

    private ImageView iconControlFlow;
    private TextView titleControlFlow;
    private Button btnShare;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controlflow_detail);

        setupActionBar();
        initViews();
        wireShare();
    }

    private void setupActionBar() {
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle("Control Flow");
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initViews() {
        iconControlFlow = findViewById(R.id.iconControlFlow);
        titleControlFlow = findViewById(R.id.titleControlFlow);
        btnShare = findViewById(R.id.btnShareControlFlow);

        titleControlFlow.setText("Learn Control Flow");
    }

    private void wireShare() {
        btnShare.setOnClickListener(v -> {
            String shareText = buildShareMessage();
            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.setType("text/plain");
            sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Learning Control Flow");
            sendIntent.putExtra(Intent.EXTRA_TEXT, shareText);
            startActivity(Intent.createChooser(sendIntent, "Share via"));
        });
    }

    private String buildShareMessage() {
        return "I'm learning about Control Flow:\n\n"
                + "• if/else for decisions\n"
                + "• switch for multiple discrete cases\n"
                + "• for/while/do-while for repetition\n"
                + "• break & continue to alter looping\n\n"
                + "Example:\nfor (int i = 0; i < 5; i++) { /* ... */ }";
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}