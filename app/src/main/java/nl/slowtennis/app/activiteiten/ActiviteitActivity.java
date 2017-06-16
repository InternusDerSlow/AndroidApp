package nl.slowtennis.app.activiteiten;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import nl.slowtennis.app.R;

public class ActiviteitActivity extends ActionBarActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activiteit);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().hide();
        LinearLayout linearLayout=(LinearLayout) findViewById(R.id.linearLayoutCorener);
        linearLayout.setBackgroundResource(R.drawable.corners);


        Intent i = getIntent();
        Activiteit act = (Activiteit)i.getSerializableExtra("Activiteit");

        TextView aanvang = (TextView) findViewById(R.id.txtAanvang);
        TextView datum = (TextView) findViewById(R.id.txtDate);
        TextView title = (TextView) findViewById(R.id.txtTitle);

        ImageView banner = (ImageView) findViewById(R.id.imgBanner);

       aanvang.setText(act.getAanvang());
        banner.setImageResource(act.getBanner());
        datum.setText(act.getDate());
        title.setText(act.getTitle());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activiteit, menu);
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
}
