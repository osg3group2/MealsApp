package id.osg3group2.mealsapp.view.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import id.osg3group2.mealsapp.R;
import id.osg3group2.mealsapp.helpers.CheckNetworkConnectionHelper;
import id.osg3group2.mealsapp.listener.OnNetworkConnectionChangeListener;
import id.osg3group2.mealsapp.view.fragment.MenuCariResepFragment;
import id.osg3group2.mealsapp.view.fragment.MenuKategoriMakananFragment;

public class NavDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    public static String QUERY = "query";
    public static final int TEXT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MenuCariResepFragment menuCariResepFragment = new MenuCariResepFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framelayout, menuCariResepFragment);
        fragmentTransaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        TextView textView = findViewById(R.id.textView);

        CheckNetworkConnectionHelper checkNetworkConnectionHelper = CheckNetworkConnectionHelper.getInstance();
        checkNetworkConnectionHelper.onNetworkConnectionChange(this,
                new OnNetworkConnectionChangeListener() {
                    @Override
                    public void onConnected() {
                        //Do your task on Network Connected!
                        Toast.makeText(NavDrawerActivity.this, "Terkoneksi Internet", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDisconnected() {
                        //Do your task on Network Disconnected!
                        Toast.makeText(NavDrawerActivity.this, "Tidak Terkoneksi Internet", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(NavDrawerActivity.this, RefresthActivity.class);
                        startActivityForResult(intent,TEXT_REQUEST);
                    }
                });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_drawer, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        MaterialSearchView searchView = (MaterialSearchView) findViewById(R.id.search_view);
        searchView.setMenuItem(item);
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query.length() > 0) {
                    MenuCariResepFragment menuCariResepFragment = new MenuCariResepFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    Bundle args = new Bundle();
                    args.putString("query_string", query);
                    menuCariResepFragment.setArguments(args);
                    fragmentTransaction.replace(R.id.framelayout, menuCariResepFragment);
                    fragmentTransaction.commit();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_menu_cari_resep_makanan) {
            MenuCariResepFragment menuCariResepFragment = new MenuCariResepFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.framelayout, menuCariResepFragment);
            fragmentTransaction.commit();
            // Handle the camera action
        } else if (id == R.id.nav_menu_kategori_makanan) {
            MenuKategoriMakananFragment menuKategoriMakananFragment = new MenuKategoriMakananFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.framelayout, menuKategoriMakananFragment);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_tentang_app) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
