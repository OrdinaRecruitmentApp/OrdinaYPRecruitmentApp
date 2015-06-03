package nl.ordina.yp.recruitmentapp;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class WaaromOrdinaActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waarom_ordina);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#565A5C")));


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_waarom_ordina, menu);
        return true;
    }

    //Deze hele methode kan waarschijnlijk weg omdat we de settings button niet gebruiken en waarschijnlijk ook geen andere buttons
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //Settings in xml files uit gecomment
        if (id == R.id.action_email) {
            Mail mail = new Mail(this.getString(R.string.email_address), this.getString(R.string.email_subject),
                    this.getString(R.string.email_type), this.getString(R.string.email_choose_message));
            startActivity(mail.sendEmail());
        }

        return super.onOptionsItemSelected(item);
    }

    public void goToVacatures(View view){
        Intent vacatureLink = new Intent(android.content.Intent.ACTION_VIEW);
        vacatureLink.setData(Uri.parse("http://m.werkenbijordina.nl/nl/mobile/617/jobs?combine=young+professional&field_functiegroep_tid=All&field_region_tid=All"));
        startActivity(vacatureLink);
    }

}
