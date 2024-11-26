package com.example.visualsort;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final String EXP_DISPLAY_SORT_TEXT = "Welcome to Visual Sort! \n\nInput criteria: \n\n1. Numbers only, 0-9 \n2. Input should contain 3 to 8 numbers separated by a space \n\nEx. 6 5 8 9 7 4 2 3";
    private EditText editText;
    private Button clearTextBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Ensure this points to your new main layout

        EditText editText = findViewById(R.id.userInput);
        Button buttonClear = findViewById(R.id.buttonClear);

        // Floating Action Button (FAB) setup (Optional)

        // Set up the button click listener
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Clear the text in the EditText
                editText.setText("");
            }
        });
        // Find the TextView by its ID
        TextView readOnlyText = findViewById(R.id.displaySortTextView);
    }


}