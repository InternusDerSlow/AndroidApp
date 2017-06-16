package nl.slowtennis.app;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import nl.slowtennis.app.Drawer.NavigationDrawerCallbacks;
import nl.slowtennis.app.Drawer.NavigationDrawerFragment;
import nl.slowtennis.app.Toss.TossFragment;
import nl.slowtennis.app.activiteiten.ActiviteitenFragment;


public class MainActivity extends ActionBarActivity implements NavigationDrawerCallbacks {


    private NavigationDrawerFragment mNavigationDrawerFragment;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);

        mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.fragment_drawer);
        mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar);

    }

        @Override
        public void onNavigationDrawerItemSelected(int position) {
                Fragment fragment = null;
                   switch (position) {
                    case 0: //search//todo
                        fragment = new TossFragment();
                        break;
                    case 1:
                        fragment = new ActiviteitenFragment();
                        break;
                    case 2:
                        fragment = new TrainingFragment();
                        break;
                }
            getFragmentManager().beginTransaction().setCustomAnimations(android.R.animator.fade_in,
                    android.R.animator.fade_out).replace(R.id.container, fragment).commit();
        }


    public void onAvatarClicked(View v)
    {
        startProfileActivity(v, this.findViewById(R.id.txtUsername), this.findViewById(R.id.txtExtraInfo), this.findViewById(R.id.navigationHeader));
    }
    public void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }





    @SuppressLint("NewApi")
    private void startProfileActivity(View picture, View name, View extraInfoTran, View banner) {

        Intent i = new Intent(this, ProfielActivity.class);
        ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                Pair.create(picture, "avatarTran")
                , Pair.create(name, "nameTran")
                , Pair.create(extraInfoTran, "extraInfoTran")
                , Pair.create(banner, "bannerTran")
        );
        startActivity(i, transitionActivityOptions.toBundle());
    }


    @Override
    public void onBackPressed() {
        if (mNavigationDrawerFragment.isDrawerOpen())
            mNavigationDrawerFragment.closeDrawer();
        else
            mNavigationDrawerFragment.openDrawer();
            //super.onBackPressed();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }
}
