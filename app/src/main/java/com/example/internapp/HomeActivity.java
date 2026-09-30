package com.example.internapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.internapp.Adapter.internAdapter;
import com.example.internapp.Model.internItem;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<internItem> internList;

    internAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Find RecyclerView
        recyclerView = findViewById(R.id.lvinternlist);

        // Create ArrayList
        internList = new ArrayList<>();

        // Add internship data
        internList.add(new internItem(
                "UI/UX Intern",
                "29 Sept 2026",
                "UI/UX Designer",
                "Kathmandu, Nepal",
                "ABS Company Limited",
                "25"
        ));

        internList.add(new internItem(
                "Frontend Developer Intern",
                "28 Sept 2026",
                "Frontend Developer",
                "Lalitpur, Nepal",
                "ABC Tech Pvt. Ltd.",
                "18"
        ));

        internList.add(new internItem(
                "Backend Developer Intern",
                "27 Sept 2026",
                "Backend Developer",
                "Bhaktapur, Nepal",
                "XYZ Solutions",
                "32"
        ));

        internList.add(new internItem(
                "Android Developer Intern",
                "26 Sept 2026",
                "Android Developer",
                "Kathmandu, Nepal",
                "Tech Nepal",
                "14"
        ));

        // Set LayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create Adapter
        adapter = new internAdapter(internList);

        // Connect Adapter to RecyclerView
        recyclerView.setAdapter(adapter);
    }
}