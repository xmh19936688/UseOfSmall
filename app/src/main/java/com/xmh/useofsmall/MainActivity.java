package com.xmh.useofsmall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import net.wequick.small.Small;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Small.setUp(this, new net.wequick.small.Bundle.OnLoadListener() {
            @Override
            public void onStart(int bundleCount, int upgradeBundlesCount, long upgradeBundlesSize) {

            }

            @Override
            public void onProgress(int bundleIndex, String bundleName, long loadedSize, long bundleSize) {

            }

            @Override
            public void onComplete(Boolean success) {
                Small.openUri("demo", MainActivity.this);
                finish();
            }
        });

    }
}
