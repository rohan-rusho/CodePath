package com.learnnow.codepathfoundations;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Main screen listing the six foundational modules.
 */
public class MainActivity extends AppCompatActivity {

    private static final boolean SHOW_LAUNCH_TOAST = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Make sure this matches the layout file name above.
        setContentView(R.layout.activity_main);

        wireModule(R.id.cardVariables,   R.id.btnVariables,   VariablesDetailActivity.class,   "Variables");
        wireModule(R.id.cardDataTypes,   R.id.btnDataTypes,   DataTypesDetailActivity.class,   "Data Types");
        wireModule(R.id.cardControlFlow, R.id.btnControlFlow, ControlFlowDetailActivity.class, "Control Flow");
        wireModule(R.id.cardFunctions,   R.id.btnFunctions,   FunctionDetailActivity.class,    "Functions");
        wireModule(R.id.cardDebugging,   R.id.btnDebugging,   DebuggingDetailActivity.class,   "Debugging");
        wireModule(R.id.cardAlgorithms,  R.id.btnAlgorithms,  AlgorithmsDetailActivity.class,  "Algorithms");
    }

    private void wireModule(@IdRes int cardId,
                            @IdRes int labelId,
                            Class<?> targetActivity,
                            String moduleName) {

        View card = findViewById(cardId);
        TextView label = findViewById(labelId);

        if (card == null || label == null) {
            // Defensive log (could add Log.w)
            return;
        }

        View.OnClickListener open = v -> launchModule(targetActivity, moduleName);
        card.setOnClickListener(open);
        label.setOnClickListener(open);
    }

    private void launchModule(Class<?> target, String name) {
        try {
            if (SHOW_LAUNCH_TOAST) {
                Toast.makeText(this, "Opening " + name, Toast.LENGTH_SHORT).show();
            }
            startActivity(new Intent(this, target));
        } catch (Exception e) {
            Toast.makeText(this, "Unable to open " + name, Toast.LENGTH_LONG).show();
        }
    }
}