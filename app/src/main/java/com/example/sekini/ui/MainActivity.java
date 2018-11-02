package com.example.sekini.ui;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.sekini.R;
import com.example.sekini.app.BundleNames;
import com.example.sekini.databinding.ActivityMainBinding;
import com.example.sekini.utils.base.activity.BaseActivity;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel>
        implements IMainNavigator {

    @Inject
    ViewModelProvider.Factory factory;

    public static Intent newInstance(Context context, int id) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(BundleNames.Id, id);
        return intent;
    }


    @Override
    public MainViewModel getViewModel() {
        return ViewModelProviders.of(this, factory).get(MainViewModel.class);
    }

    @Override
    public int getBindingVariable() {
        return 1;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);

    }


}
