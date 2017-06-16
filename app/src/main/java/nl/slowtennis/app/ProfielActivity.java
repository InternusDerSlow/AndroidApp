package nl.slowtennis.app;


import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import nl.slowtennis.app.Drawer.NavigationDrawerFragment;


public class ProfielActivity extends ActionBarActivity {

    private Toolbar mToolbar;
    private static final int WHITE = 0xFFFFFFff;
    private static final int PURPLE = 0xFF270349;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profiel);

        View v = findViewById(R.id.linearLayoutUser);
        setUserData("Luuk Schimmel", "Slowsterkte: 9", BitmapFactory.decodeResource(getResources(), R.drawable.avatar),v);
        LinearLayout linearLayout=(LinearLayout) findViewById(R.id.linearLayoutCorener);
        linearLayout.setBackgroundResource(R.drawable.corners);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_LOW_PROFILE;
        decorView.setSystemUiVisibility(uiOptions);
        getSupportActionBar().hide();

        final TextView userName = (TextView) findViewById(R.id.txtUsername);
        final TextView extraInfo = (TextView) findViewById(R.id.txtExtraInfo);

        animateTextTransition(userName, WHITE, PURPLE);

        animateTextTransition(extraInfo, WHITE, PURPLE);
        ImageView imageView = (ImageView) findViewById(R.id.imgAvatar);
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                ImageView imageView = (ImageView) findViewById(R.id.imgAvatar);
                imageView.setImageResource(R.drawable.tennisbal);
                return true;
            }
        });

    }

    private void animateTextTransition(TextView textView, int colorA, int colorB) {
        ValueAnimator colorAnim = ObjectAnimator.ofInt(textView, "textColor", colorA, colorB);

        colorAnim.setDuration(500);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.start();


    }




    @Override
    public void onBackPressed() {
        super.onBackPressed();
        TextView userName = (TextView) findViewById(R.id.txtUsername);
        TextView extraInfo = (TextView) findViewById(R.id.txtExtraInfo);


        animateTextTransition(userName, PURPLE, WHITE);
        animateTextTransition(extraInfo, PURPLE, WHITE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profiel, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:


                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void setUserData(String user, String email, Bitmap avatar, View mFragmentContainerView) {
        ImageView avatarContainer = (ImageView) mFragmentContainerView.findViewById(R.id.imgAvatar);
        ((TextView) mFragmentContainerView.findViewById(R.id.txtExtraInfo)).setText(email);
        ((TextView) mFragmentContainerView.findViewById(R.id.txtUsername)).setText(user);
        avatarContainer.setImageDrawable(new NavigationDrawerFragment.RoundImage(avatar));
    }
}
