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
 * Detail page for the "Data Types" module.
 * Currently static; can be unified later into a generic module detail activity.
 */
public class DataTypesDetailActivity extends AppCompatActivity {

    private ImageView iconDataTypes;
    private TextView  titleDataTypes;
    private Button    btnShare;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datatypes_detail);

        setupActionBar();
        initViews();
        wireShare();
    }

    private void setupActionBar() {
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle("Data Types");
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initViews() {
        iconDataTypes = findViewById(R.id.iconDataTypes);
        titleDataTypes = findViewById(R.id.titleDataTypes);
        btnShare = findViewById(R.id.btnShareDataTypes);

        titleDataTypes.setText("Learn Data Types");
    }

    private void wireShare() {
        btnShare.setOnClickListener(v -> {
            String shareText = buildShareMessage();
            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.setType("text/plain");
            sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Learning Data Types");
            sendIntent.putExtra(Intent.EXTRA_TEXT, shareText);
            startActivity(Intent.createChooser(sendIntent, "Share via"));
        });
    }

    private String buildShareMessage() {
        return "I'm learning about Data Types:\n\n"
                + "• Primitives store simple values (int, boolean, double)\n"
                + "• Reference types store object references (String, arrays, custom classes)\n"
                + "• Correct types prevent errors & improve clarity\n"
                + "• Be careful with casting and precision\n\n"
                + "Example:\nint x = 5;\nlong y = x; // widening\nint z = (int) 5.9; // narrowing -> 5";
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}