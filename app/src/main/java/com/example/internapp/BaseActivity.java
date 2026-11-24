package com.example.internapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class BaseActivity extends AppCompatActivity {

    Button btFirst, btSecond, btThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_base);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main), (v, insets) -> {

                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars()
                    );

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                });

        btFirst = findViewById(R.id.bt1);
        btSecond = findViewById(R.id.bt2);
        btThird = findViewById(R.id.bt3);

        // Button 1
        btFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new Fragment1());
            }
        });

        // Button 2
        btSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new Fragment2());
            }
        });

        // Button 3
        btThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new Fragment3());
            }
        });

        // Load first fragment when activity starts
        if (savedInstanceState == null) {
            loadFragment(new Fragment1());
        }
    }

    // Method to load fragments
    private void loadFragment(Fragment fragment) {

        FragmentManager fragmentManager =
                getSupportFragmentManager();

        FragmentTransaction transaction =
                fragmentManager.beginTransaction();

        transaction.replace(R.id.fragment_container, fragment);

        transaction.commit();
    }
}