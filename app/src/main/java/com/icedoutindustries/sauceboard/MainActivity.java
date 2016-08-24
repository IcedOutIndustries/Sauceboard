package com.icedoutindustries.sauceboard;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.media.MediaPlayer.OnCompletionListener;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {

    private AdView mAdView;
    private static final String TOAST_TEXT = "Test ads are being shown. "
            + "To show live ads, replace the ad unit ID in res/values/strings.xml with your own ad unit ID.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateListview();


        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-6234954892387302~1626986071");

        // Gets the ad view defined in layout/ad_fragment.xml with ad unit ID set in
        // values/strings.xml.
        mAdView = (AdView) findViewById(R.id.ad_view);

        // Create an ad request. Check your logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        // Start loading the ad in the background.
        mAdView.loadAd(adRequest);





        // Toasts the test ad message on the screen. Remove this after defining your own ad unit ID.
    }




    private void populateListview(){
        String[] myItems = {getString(R.string.string0),getString(R.string.string1),getString(R.string.string2),getString(R.string.string3),getString(R.string.string4),getString(R.string.string5),getString(R.string.string6),getString(R.string.string7)};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, myItems);
        ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);
        regsiterClickCallback();

    }

    private void regsiterClickCallback(){
        ListView list = (ListView) findViewById(R.id.listView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            final int int_0 = R.raw.no_sauce_then_lost;
            final int int_1 = R.raw.but_also_lost_in_sauce;
            final int int_2= R.raw.no_meat_just_sauce;
            final int int_3 = R.raw.overdose_sauce;
            final int int_4 = R.raw.saucin;
            final int int_5 = R.raw.saucin_on_you;
            final int int_6 = R.raw.tms2;
            final int int_7 = R.raw.please_dont_get_lost;
            final int id_Array[] = {int_0,int_1,int_2,int_3,int_4,int_5,int_6, int_7};

            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {

                try {
                    MediaPlayer temp_clip = null;
                    temp_clip = MediaPlayer.create(getBaseContext(), id_Array[position]);
                    temp_clip.start();
                    temp_clip.setOnCompletionListener(new OnCompletionListener() {
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                }
                catch(Exception e){

                }
            }
        });
    }
}



