package com.example.birzeitstudyplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private RecyclerView upcomingClassesRecyclerView;
    private List<String> upcomingClassesList;
    private UpcomingClassesAdapter upcomingClassesAdapter;
    private communicationService communicationService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager2 viewPager = findViewById(R.id.viewPager);

        // Create an adapter to manage the fragments
        TabAdapter adapter = new TabAdapter(this);
        adapter.addFragment(new ProfileFragment(), "Profile");
        adapter.addFragment(new UpcomingClassesFragment(), "Upcoming Classes");
        adapter.addFragment(new ScheduleFragment(), "Schedule");
        adapter.addFragment(new ExamFragment(), "Exams");
        adapter.addFragment(new InstructorFragment(), "Instructors");
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(adapter.getPageTitle(position).toString())
        ).attach();
    }
}