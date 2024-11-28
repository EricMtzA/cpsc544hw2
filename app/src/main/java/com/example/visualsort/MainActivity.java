package com.example.visualsort;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;

import android.graphics.drawable.ColorDrawable;

import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.view.LayoutInflater;

public class MainActivity extends AppCompatActivity {
    static final String EXP_DISPLAY_SORT_TEXT = "Welcome to Visual Sort! \n\nInput criteria: \n\n1. Numbers only, 0-9 \n2. Input should contain 3 to 8 numbers separated by a space \n\nEx. 6 5 8 9 7 4 2 3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Ensure this points to your new main layout

        EditText userInput = findViewById(R.id.userInput);
        Button buttonClear = findViewById(R.id.buttonClear);
        Button buttonNewSort = findViewById(R.id.buttonNewSort);
        Button buttonSort = findViewById(R.id.buttonSort);
        TextView displaySortTextView = findViewById(R.id.displaySortTextView);

        // Floating Action Button (FAB) setup (Optional)

        // Set up the button click listener
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Clear the text in the EditText
                userInput.setText("");
            }
        });

        // New Sort Button
        // Reset UI
        buttonNewSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText("");
                displaySortTextView.setText(EXP_DISPLAY_SORT_TEXT);
            }
        });

        // Sort Button
        buttonSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInputValue = String.valueOf(userInput.getText()).replaceAll("\\s{2,}", " ");

                try {
                    VisualSort.sort(userInputValue);
                    displaySortTextView.setText(VisualSort.getSortResults());
                } catch (IllegalArgumentException e) {
                    showErrorDialog(e.getMessage());
                } catch (Exception e) {
                    showErrorDialog("Unexpected error has occurred. Please contact Eric.");
                }
            }
        });
    }

    public void showErrorDialog(String message) {
        ConstraintLayout errorConstraintLayout = findViewById(R.id.errorConstraintLayout);
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.error_dialog, errorConstraintLayout);
        Button errorClose = view.findViewById(R.id.errorClose);
        TextView errorDesc = view.findViewById(R.id.errorDesc);
        errorDesc.setText(message);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setView(view);
        final AlertDialog alertDialog = builder.create();

        errorClose.findViewById(R.id.errorClose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
        }

        alertDialog.show();
    }
}