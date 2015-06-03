package nl.ordina.yp.recruitmentapp;

import android.app.Dialog;
import android.content.Intent;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import android.net.Uri;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.view.Window;
import android.widget.TextView;

import android.widget.Button;



public class MainActivity extends ActionBarActivity {

    protected Dialog mSplashDialog;
    Button waaromOrdina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#565A5C")));
        actionbar.setTitle("");
        if(StateSplashscreen.firstTimeOpeningApp) {

            StateSplashscreen.firstTimeOpeningApp = false;
            showSplashScreen();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //Deze hele methode kan waarschijnlijk weg omdat we de settings button niet gebruiken en waarschijnlijk ook geen andere buttons
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_email) {
            Mail mail = new Mail(this.getString(R.string.email_address), this.getString(R.string.email_subject),
                    this.getString(R.string.email_type), this.getString(R.string.email_choose_message));
            startActivity(mail.sendEmail());
        }
        if(id == R.id.action_about) {
            startAboutActivity();
        }

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


    public void startAboutActivity() {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    public void startFaceBookBrowserActivity(View view) {
        Uri uri = Uri.parse("https://www.facebook.com/werkenbijordina/events?key=events");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
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



    public void showAboutDialog() {


        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_about_dialog);

        TextView projectText = (TextView) dialog.findViewById(R.id.about_text);
        projectText.setText(R.string.text_about_info);



        dialog.show();

    }
}





