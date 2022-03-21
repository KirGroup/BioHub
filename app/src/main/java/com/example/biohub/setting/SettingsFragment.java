package com.example.biohub.setting;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.MenuItem;

import androidx.annotation.Nullable;

import com.example.biohub.R;

public class SettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference_screen);
    }


}
