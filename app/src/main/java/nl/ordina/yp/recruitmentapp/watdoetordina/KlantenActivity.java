package nl.ordina.yp.recruitmentapp.watdoetordina;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

import nl.ordina.yp.recruitmentapp.Mail;
import nl.ordina.yp.recruitmentapp.R;

public class KlantenActivity extends ActionBarActivity {

    HashMap<Integer, Integer> projectTexts = new HashMap<>();
    HashMap<Integer, Integer> projectLogos = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klanten);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#565A5C")));
        initializeProjectTexts();
        initializeProjectLogos();
    }

    private void initializeProjectLogos() {
        projectLogos.put(R.id.bavaria, R.drawable.bavaria_128x128);
        projectLogos.put(R.id.mindef, R.drawable.mindef_128x128);
        projectLogos.put(R.id.eneco, R.drawable.eneco_128x128);
        projectLogos.put(R.id.politie, R.drawable.politie_128x128);
        projectLogos.put(R.id.uniu, R.drawable.universiteit_utrecht_128x128);
        projectLogos.put(R.id.prorail, R.drawable.prorail_128x128);
        //projectLogos.put(R.id.ns, R.drawable.ns_128x128);
        //projectLogos.put(R.id.havenbedrijf_rotterdam, R.drawable.r_v_d_k_128x128);
    }

    private void initializeProjectTexts() {
        projectTexts.put(R.id.mindef, R.string.text_projecten_mindef);
        projectTexts.put(R.id.bavaria, R.string.text_projecten_bavaria);
        projectTexts.put(R.id.eneco, R.string.text_projecten_eneco);
        projectTexts.put(R.id.politie, R.string.text_projecten_politie);
        projectTexts.put(R.id.uniu, R.string.text_projecten_uniu);
        projectTexts.put(R.id.prorail, R.string.text_projecten_prorail);
        //projectTexts.put(R.id.ns, R.string.text_projecten_ns);
        //projectTexts.put(R.id.havenbedrijf_rotterdam, R.string.text_projecten_havenbedrijf_rotterdam);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_klanten, menu);
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

    public void showProjectDialog(View view) {
        int id = view.getId();

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_projecten_dialog);

        TextView projectText = (TextView) dialog.findViewById(R.id.klantprojecten_text);
        projectText.setText(projectTexts.get(id));

        ImageView projectImage = (ImageView) dialog.findViewById(R.id.klantprojecten_image);
        projectImage.setImageResource(projectLogos.get(id));
        projectImage.setMaxHeight(64);

        dialog.show();

    }

    public void goToVacatures(View view) {
        Intent vacatureLink = new Intent(android.content.Intent.ACTION_VIEW);
        vacatureLink.setData(Uri.parse("http://m.werkenbijordina.nl/nl/mobile/617/jobs?combine=young+professional&field_functiegroep_tid=All&field_region_tid=All"));
        startActivity(vacatureLink);
    }


}
