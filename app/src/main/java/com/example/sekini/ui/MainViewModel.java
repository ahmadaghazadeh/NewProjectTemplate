package com.example.sekini.ui;

import com.example.sekini.data.IRepository;
import com.example.sekini.utils.base.BaseViewModel;

import javax.inject.Inject;


public class MainViewModel extends BaseViewModel<IMainNavigator> {

    @Inject
    public MainViewModel() {
    }
    //@Inject
    private IRepository repository;


}
