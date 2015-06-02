package nl.ordina.yp.recruitmentapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by soz20659 on 2-6-2015.
 */
public class Evenementen extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView webview = new WebView(this);
        setContentView(webview);
        webview.loadUrl("https://m.facebook.com/werkenbijordina?v=events&refid=17");
    }
}




