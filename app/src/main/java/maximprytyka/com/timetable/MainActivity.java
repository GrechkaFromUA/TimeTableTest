package maximprytyka.com.timetable;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;

import maximprytyka.com.timetable.Fragmets.BuildsFragment;
import maximprytyka.com.timetable.Fragmets.ExampleFragment;
import maximprytyka.com.timetable.Fragmets.SubjectsFragment;
import maximprytyka.com.timetable.Fragmets.TeachersFragment;
import maximprytyka.com.timetable.Fragmets.TypeFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
        FragmentManager fm = getFragmentManager(); //Фрагмент менеджер
        int id = item.getItemId();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        SwitchCompat switchCompat = (SwitchCompat) findViewById(R.id.drawer_switch);



        if (id == R.id.nav_main) {
            fm.beginTransaction().replace(R.id.content_frame, new ExampleFragment()).commit();
            setTitle(getString(R.string.timetable));
            drawer.closeDrawer(GravityCompat.START);

        } else if (id == R.id.nav_settings) {
           // fm.beginTransaction().replace(R.id.content_frame, new SettingsFragment()).commit();
            setTitle(getString(R.string.title_settings));
            drawer.closeDrawer(GravityCompat.START);
        } else if (id == R.id.nav_time) {
          //  fm.beginTransaction().replace(R.id.content_frame, new TimeFragment()).commit();
            setTitle(getString(R.string.title_time));
            drawer.closeDrawer(GravityCompat.START);
        } else if (id == R.id.nav_subjects) {
            fm.beginTransaction().replace(R.id.content_frame, new SubjectsFragment()).commit();
            setTitle(getString(R.string.title_subjects));
            drawer.closeDrawer(GravityCompat.START);
        } else if (id == R.id.nav_teachers) {
            fm.beginTransaction().replace(R.id.content_frame, new TeachersFragment()).commit();
            setTitle(getString(R.string.title_teachers));
            drawer.closeDrawer(GravityCompat.START);
        } else if (id == R.id.nav_buildings) {
            fm.beginTransaction().replace(R.id.content_frame, new BuildsFragment()).commit();
            setTitle(getString(R.string.title_buildings));
            drawer.closeDrawer(GravityCompat.START);
        } else if (id == R.id.nav_lessons_types) {
            fm.beginTransaction().replace(R.id.content_frame, new TypeFragment()).commit();
            setTitle(getString(R.string.title_lessons_type));
            drawer.closeDrawer(GravityCompat.START);
        } else if (id == R.id.nav_two_weeks) {
            switchCompat.toggle();
        } else if (id == R.id.nav_first_day) {

        }


        return true;
    }
}
