package com.zyf.simplemvp;

import com.zyf.common.common.app.Application;
import com.zyf.factory.Factory;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //初始化Factory
        Factory.setup();


    }
}
