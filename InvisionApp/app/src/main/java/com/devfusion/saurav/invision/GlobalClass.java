package com.devfusion.saurav.invision;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

/**
 * Created by saurav on 23/08/16.
 */
public class GlobalClass extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize the SDK before executing any other operations,
        FacebookSdk.sdkInitialize(getApplicationContext());
       // AppEventsLogger.activateApp(this);
    }
}
