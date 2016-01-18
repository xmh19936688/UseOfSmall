package com.xmh.useofsmall;

import android.app.Application;

import net.wequick.small.Small;

/**
 * Created by mengh on 2016/1/18 018.
 */
public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Small.setBaseUri("http://m.wequick.net/demo/");
    }
}
