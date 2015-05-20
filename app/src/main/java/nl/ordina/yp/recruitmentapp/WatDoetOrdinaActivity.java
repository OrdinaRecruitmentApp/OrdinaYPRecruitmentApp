package nl.ordina.yp.recruitmentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import nl.ordina.yp.recruitmentapp.watdoetordina.AfdelingenActivity;
import nl.ordina.yp.recruitmentapp.watdoetordina.KlantenActivity;
import nl.ordina.yp.recruitmentapp.watdoetordina.ProjectenActivity;


public class WatDoetOrdinaActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wat_doet_ordina);
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
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }


    public void startAfdelingenActivity(View view){
        Intent intent = new Intent(this, AfdelingenActivity.class);
        startActivity(intent);
    }
    public void startKlantenActivity(View view){
        Intent intent = new Intent(this, KlantenActivity.class);
        startActivity(intent);
    }

    public void startProjectenActivity(View view){
        Intent intent = new Intent(this, ProjectenActivity.class);
        startActivity(intent);
    }
}
