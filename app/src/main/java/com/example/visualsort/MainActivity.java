package com.example.visualsort;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.visualsort.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button clearTextBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Ensure this points to your new main layout

        EditText editText = findViewById(R.id.editTextText);
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
        TextView readOnlyText = findViewById(R.id.readOnlyText);

        // Set text programmatically
        readOnlyText.setText("This is dynamically updated text!");
    }


}