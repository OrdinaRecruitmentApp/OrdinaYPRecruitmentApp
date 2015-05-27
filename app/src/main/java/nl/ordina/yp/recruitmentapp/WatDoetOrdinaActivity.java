package nl.ordina.yp.recruitmentapp;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.PopupWindow;

import nl.ordina.yp.recruitmentapp.watdoetordina.AfdelingenActivity;
import nl.ordina.yp.recruitmentapp.watdoetordina.KlantenActivity;
import nl.ordina.yp.recruitmentapp.watdoetordina.ProjectenActivity;


public class WatDoetOrdinaActivity extends ActionBarActivity {

//    private void initializeButtons(){
//        Button projectenButton= (Button) findViewById(R.id.button3);
//        projectenButton.setVisibility(View.VISIBLE);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wat_doet_ordina);
//        initializeButtons();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_wat_doet_ordina, menu);
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


    public void startAfdelingenActivity(View view) {
        Intent intent = new Intent(this, AfdelingenActivity.class);
        startActivity(intent);
    }

    public void startKlantenActivity(View view) {
        Intent intent = new Intent(this, KlantenActivity.class);
        startActivity(intent);
    }

    public void startProjectenActivity(View view) {

//
//        PopupWindow projectenPopup = new PopupWindow();
//
//        Intent intent = new Intent(this, ProjectenActivity.class);
//        startActivity(intent);
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
