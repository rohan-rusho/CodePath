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
 * Detail page for the "Functions" module.
 * Currently static. You can refactor later to load dynamic content by passing an extra (e.g. module_id)
 * and reading JSON from assets.
 */
public class FunctionDetailActivity extends AppCompatActivity {

    private ImageView iconFunctions;
    private TextView  titleFunctions;
    private Button    btnShare;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_function_detail);

        setupActionBar();
        initViews();
        wireShareButton();
    }

    private void setupActionBar() {
        // Use the ActionBar as a simple back navigation (optional)
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle("Functions");
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initViews() {
        iconFunctions   = findViewById(R.id.iconFunctions);
        titleFunctions  = findViewById(R.id.titleFunctions);
        btnShare        = findViewById(R.id.btnShareFunctions);

        // If you later pass dynamic data, you can set it here.
        titleFunctions.setText("Learn Functions");
    }

    private void wireShareButton() {
        btnShare.setOnClickListener(v -> shareFunctionsSummary());
    }

    private void shareFunctionsSummary() {
        // Build a concise share message (adjust as you like)
        String shareText = buildShareText();

        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("text/plain");
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Learning Functions");
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareText);

        startActivity(Intent.createChooser(sendIntent, "Share via"));
    }

    private String buildShareText() {
        return "I'm learning about Functions in programming:\n\n"
                + "• Functions group reusable logic\n"
                + "• They can take parameters and return values\n"
                + "• Keep them small and focused\n\n"
                + "Example:\n"
                + "int add(int a, int b) { return a + b; }\n\n"
                + "Try writing one today!";
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}