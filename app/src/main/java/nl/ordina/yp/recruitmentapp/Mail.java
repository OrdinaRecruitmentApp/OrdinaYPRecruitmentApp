package nl.ordina.yp.recruitmentapp;

import android.content.Intent;

/**
 * Created by tni20865 on 3-6-2015.
 */
public class Mail {

    private String emailAddress;
    private String emailSubject;
    private String emailType;
    private String emailChooseMessage;


    public Mail(String emailAddress, String emailSubject, String emailType, String emailChooseMessage) {
        this.emailAddress = emailAddress;
        this.emailSubject = emailSubject;
        this.emailType = emailType;
        this.emailChooseMessage = emailChooseMessage;
    }


    public Intent sendEmail() {
        String[] TO = {emailAddress};
        String subject = emailSubject;

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, TO);
        email.putExtra(Intent.EXTRA_SUBJECT, subject);

        email.setType(emailType);
        Intent intent = Intent.createChooser(email, emailChooseMessage);

        return intent;
    }
}
