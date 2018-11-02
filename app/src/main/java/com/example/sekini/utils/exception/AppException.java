package com.example.sekini.utils.exception;

import android.content.Context;
import android.support.annotation.StringRes;

public class AppException extends BaseException {
    //@Inject
    public
    Context context;
    public AppException(String message) {
        super(message);
    }

    public AppException(@StringRes int stringRes) {
            super(stringRes);
    }

}
