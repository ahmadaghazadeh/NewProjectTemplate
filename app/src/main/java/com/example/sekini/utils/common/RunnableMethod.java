package com.example.sekini.utils.common;


public interface RunnableMethod<TIN, TOUT> {
    TOUT run(TIN param, OnProgressUpdate onProgressUpdate) ;
}

