package nl.ordina.yp.recruitmentapp.watdoetordina;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

import nl.ordina.yp.recruitmentapp.R;

public class KlantenActivity extends ActionBarActivity {

    HashMap<Integer, Integer> projectTexts = new HashMap<>();
    HashMap<Integer, Integer> projectLogos = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klanten);

        initializeProjectTexts();
        initializeProjectLogos();
    }

    private void initializeProjectLogos() {
        projectLogos.put(R.id.rabobank, R.drawable.rabobank);
        projectLogos.put(R.id.ing_bank, R.drawable.ing_bank);
        projectLogos.put(R.id.eneco, R.drawable.eneco);
        projectLogos.put(R.id.politie, R.drawable.politie);
        projectLogos.put(R.id.belastingdienst, R.drawable.belastingdienst);
        projectLogos.put(R.id.prorail, R.drawable.prorail);
        projectLogos.put(R.id.ns, R.drawable.ns);
        projectLogos.put(R.id.ziggo, R.drawable.ziggo_280x214px);
    }

    private void initializeProjectTexts() {
        projectTexts.put(R.id.rabobank, R.string.text_projecten_rabobank);
        projectTexts.put(R.id.ing_bank, R.string.text_projecten_ing);
        projectTexts.put(R.id.eneco, R.string.text_projecten_eneco);
        projectTexts.put(R.id.politie, R.string.text_projecten_politie);
        projectTexts.put(R.id.belastingdienst, R.string.text_projecten_belastingdienst);
        projectTexts.put(R.id.prorail, R.string.text_projecten_prorail);
        projectTexts.put(R.id.ns, R.string.text_projecten_ns);
        projectTexts.put(R.id.ziggo, R.string.text_projecten_ziggo);
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
            sendEmail();
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

        dialog.show();

    }

    public void goToVacatures(View view) {
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
