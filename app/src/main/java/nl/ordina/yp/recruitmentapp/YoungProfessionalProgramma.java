package nl.ordina.yp.recruitmentapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class YoungProfessionalProgramma extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_young_professional_programma);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_young_professional_programma, menu);
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
           sendEmail();
        }

        return super.onOptionsItemSelected(item);
    }

    public void goToVacatures(View view){
        Intent vacatureLink = new Intent(android.content.Intent.ACTION_VIEW);
        vacatureLink.setData(Uri.parse("http://m.werkenbijordina.nl/nl/mobile/617/jobs?combine=young+professional&field_functiegroep_tid=All&field_region_tid=All"));
        startActivity(vacatureLink);
    }

    public void sendEmail() {
        String[] TO = {this.getString(R.string.email_address)};
        String subject = this.getString(R.string.email_subject);

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, TO);
        email.putExtra(Intent.EXTRA_SUBJECT, subject);

        email.setType(this.getString(R.string.email_type));

        startActivity(Intent.createChooser(email, this.getString(R.string.email_choose_message)));
    }
}
