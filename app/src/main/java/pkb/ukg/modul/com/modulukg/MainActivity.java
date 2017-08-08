package pkb.ukg.modul.com.modulukg;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        TextView myTextView = (TextView)findViewById(R.id.mytextview);

        InputStream inputStream = getResources().openRawResource(R.raw.atas);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        String myText = "";
        int in;
        try {
            in = inputStream.read();
            while (in != -1)
            {
                byteArrayOutputStream.write(in);
                in = inputStream.read();
            }
            inputStream.close();

            myText = byteArrayOutputStream.toString();
        }catch (IOException e) {
            e.printStackTrace();
        }

        myTextView.setText(myText);
    }

}