package com.bcit.menumania;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        SectionPageAdapter pagerAdapter = new SectionPageAdapter(getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);
    }

    public class SectionPageAdapter extends FragmentPagerAdapter
    {
        public SectionPageAdapter(FragmentManager fm, int behaviour)
        {
            super(fm, behaviour);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            switch (position)
            {
                case 0:
                    return new FAQFragment();
                case 1:
                    return new ChatAssistFragment();
                case 2:
                    return new CreateTicketFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            //Ernest Wong

            switch (position)
            {
                case 0:
//                    return "FAQ";
                    return getString(R.string.tab_faq);
                case 1:
//                    return "ChatAssist";
                    return getString(R.string.tab_assist);
                case 2:
//                    return "CreateTicket";
                    return getString(R.string.tab_ticket);
            }

            return null;
        }
    }

}