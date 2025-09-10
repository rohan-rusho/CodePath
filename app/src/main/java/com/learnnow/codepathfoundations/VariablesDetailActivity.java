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
 * Detail page for the "Variables" module.
 * Static content for now; can be refactored to load dynamic JSON later.
 */
public class VariablesDetailActivity extends AppCompatActivity {

    private ImageView iconVariables;
    private TextView  titleVariables;
    private Button    btnShare;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variables_detail);

        setupActionBar();
        initViews();
        wireShare();
    }

    private void setupActionBar() {
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle("Variables");
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initViews() {
        iconVariables  = findViewById(R.id.iconVariables);
        titleVariables = findViewById(R.id.titleVariables);
        btnShare       = findViewById(R.id.btnShareVariables);

        titleVariables.setText("Learn Variables");
    }

    private void wireShare() {
        btnShare.setOnClickListener(v -> {
            String shareText = buildShareText();
            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.setType("text/plain");
            sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Learning Variables");
            sendIntent.putExtra(Intent.EXTRA_TEXT, shareText);
            startActivity(Intent.createChooser(sendIntent, "Share via"));
        });
    }

    private String buildShareText() {
        return "I'm learning about Variables in programming:\n\n"
                + "• Variables label and store values\n"
                + "• Declaration vs initialization matters\n"
                + "• Good names make code readable\n"
                + "• Scope controls visibility\n\n"
                + "Example:\nint count = 0;\ncount = count + 1;";
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}