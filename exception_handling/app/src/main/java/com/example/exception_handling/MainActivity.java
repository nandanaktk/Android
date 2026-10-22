package com.example.myapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText numberInput;
    Button addButton;
    ListView listView;

    ArrayList<String> numbers;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberInput = findViewById(R.id.numberInput);
        addButton = findViewById(R.id.addButton);
        listView = findViewById(R.id.listView);

        numbers = new ArrayList<>();

        // Adapter
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                numbers
        );

        listView.setAdapter(adapter);

        addButton.setOnClickListener(v -> {

            try {
                String input = numberInput.getText().toString();

                int number = Integer.parseInt(input);

                numbers.add(String.valueOf(number));

                // Update ListView
                adapter.notifyDataSetChanged();

                numberInput.setText("");

            } catch (NumberFormatException e) {

                Toast.makeText(
                        MainActivity.this,
                        "Please enter a valid number",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}
