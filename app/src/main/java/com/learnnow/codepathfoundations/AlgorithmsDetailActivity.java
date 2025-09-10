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
 * Detail page for the "Algorithms" module.
 */
public class AlgorithmsDetailActivity extends AppCompatActivity {

    private ImageView iconAlgorithms;
    private TextView titleAlgorithms;
    private Button btnShare;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithms_detail);

        setupActionBar();
        initViews();
        wireShare();
    }

    private void setupActionBar() {
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle("Algorithms");
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initViews() {
        iconAlgorithms = findViewById(R.id.iconAlgorithms);
        titleAlgorithms = findViewById(R.id.titleAlgorithms);
        btnShare = findViewById(R.id.btnShareAlgorithms);
        titleAlgorithms.setText("Learn Algorithms");
    }

    private void wireShare() {
        btnShare.setOnClickListener(v -> {
            String shareText = buildShareMessage();
            Intent send = new Intent(Intent.ACTION_SEND);
            send.setType("text/plain");
            send.putExtra(Intent.EXTRA_SUBJECT, "Learning Algorithms");
            send.putExtra(Intent.EXTRA_TEXT, shareText);
            startActivity(Intent.createChooser(send, "Share via"));
        });
    }

    private String buildShareMessage() {
        return "I'm learning Algorithms:\n"
                + "• Linear vs Binary search\n"
                + "• Sorting basics\n"
                + "• Big-O thinking\n"
                + "• Choosing efficient approaches\n\n"
                + "Example:\nint idx = binarySearch(arr, target);";
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}