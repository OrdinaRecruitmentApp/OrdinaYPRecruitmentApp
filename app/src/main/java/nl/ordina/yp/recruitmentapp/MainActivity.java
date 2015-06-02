package nl.ordina.yp.recruitmentapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;



public class MainActivity extends ActionBarActivity {

    protected Dialog mSplashDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(StateSplashscreen.firstTimeOpeningApp) {
            StateSplashscreen.firstTimeOpeningApp = false;
            showSplashScreen();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //Deze hele methode kan waarschijnlijk weg omdat we de settings button niet gebruiken en waarschijnlijk ook geen andere buttons
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    public void startWaaromOrdinaActivity(View view) {
        Intent intent = new Intent(this, WaaromOrdinaActivity.class);
        startActivity(intent);
    }

    public void startWatDoetOrdinaActivity(View view) {
        Intent intent = new Intent(this, WatDoetOrdinaActivity.class);
        startActivity(intent);
    }

    public void startYoungProfessionalProgramma(View view) {
        Intent intent = new Intent(this, YoungProfessionalProgramma.class);
        startActivity(intent);
    }

    public void startEvenementenActivity(View view){
        Intent intent = new Intent(this, FacebookEvenementenActivity.class);
        startActivity(intent);
    }

// closes the splashscreen
    protected void removeSplashScreen() {
        if (mSplashDialog != null) {
            mSplashDialog.dismiss();
            mSplashDialog = null;
        }
    }

    /**
     * Shows the splash screen over the full Activity
     */
    protected void showSplashScreen() {
        mSplashDialog = new Dialog(this, R.style.SplashScreen);
        mSplashDialog.setContentView(R.layout.splashscreen);
        mSplashDialog.setCancelable(false);
        mSplashDialog.show();

        // Set Runnable to remove splash screen just in case
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                removeSplashScreen();
            }
        }, 2000);
    }
}





