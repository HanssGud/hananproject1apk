package com.doesntexist.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.chip.ChipGroup;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textView = findViewById(R.id.kelompokEnam);

        ChipGroup chipGroup = findViewById(R.id.chipGroup);

        // Using the chip in the group as the "continue" button
        if (chipGroup.getChildCount() > 0) {
            chipGroup.getChildAt(0).setOnClickListener(v -> {
                Intent intent = new Intent(this, jasonPresent2.class);
                startActivity(intent);
            });
        }
    }

    protected void showToast(View view) {
        Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show();}

    public void countDown(View view) {
        count--;
        if (textView != null) {
            textView.setText(String.valueOf(count));
        }
    }
    public void countUp(View view) {
        count++;
        if (textView != null) {
            textView.setText(String.valueOf(count));
        }
    }
}
