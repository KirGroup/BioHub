package com.example.biohub;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.biohub.databinding.ActivityMainBinding;
import com.example.biohub.setting.SettingsActivity;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private ListView list;
    private String[] array;
    private ArrayAdapter<String> adapter;
    private ActivityMainBinding binding;
    private DrawerLayout drawer;
    public Toolbar toolbar;
    private int category_index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        list = findViewById(R.id.listView);
        array = getResources().getStringArray(R.array.arr_supplements);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,new ArrayList<String>(Arrays.asList(array)));
        list.setAdapter(adapter);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.supplements);

        drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        navigationView.setNavigationItemSelectedListener(this);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ContentText.class);
                intent.putExtra("category", category_index);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.action_settings){
            Intent i = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id== R.id.supplements){
            fillArray(R.string.supplements, "Pushed Supplements", R.array.arr_supplements, 0);
        }
        else if(id== R.id.nootropics){
            fillArray(R.string.nootropics, "Pushed Nootropics", R.array.arr_nootropics, 1);
        }
        else if(id== R.id.bundles){
            fillArray(R.string.bundles, "Pushed Bundles", R.array.arr_bundles, 2);
        }
//        else if(id== R.id.calendar){
//            fillArray(R.string.calendar, "Pushed the Calendar", R.array.arr_calendar, 3);
//        }
//        else if(id== R.id.share){
//            fillArray(R.string.share, "Pushed Share", R.array.arr_share, 4);
//        }
//        else if(id== R.id.return_opinion){
//            fillArray(R.string.return_opinion, "Pushed Return opinion", R.array.arr_return_opinion, 5);
//        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void fillArray(int title, String text, int arrayList, int arrayString){
        toolbar.setTitle(title);
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        adapter.clear();
        array = getResources().getStringArray(arrayList);
        adapter.addAll(array);
        adapter.notifyDataSetChanged();
        category_index = arrayString;
    }
}