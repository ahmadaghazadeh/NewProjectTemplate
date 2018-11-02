package com.example.sekini.di;

import android.app.Application;

import com.example.sekini.app.BaseApp;
import com.example.sekini.data.local.DataBaseModule;
import com.example.sekini.data.local.pref.PrefModule;
import com.example.sekini.data.remote.ApiModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        DataBaseModule.class,
        ActivityBuilderModule.class,
        ApiModule.class, PrefModule.class
})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    void inject(BaseApp app);

    @Override
    void inject(DaggerApplication application);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder getApp(Application application);

        AppComponent build();
    }
}
