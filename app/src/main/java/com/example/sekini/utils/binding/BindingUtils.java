package com.example.sekini.utils.binding;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.example.sekini.app.GlideApp;
import com.example.sekini.utils.common.CommonUtils;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class BindingUtils {

    @BindingAdapter("error")
    public static void setError(EditText text, String error) {
        if (error != null) {
            text.setError(error);
        }
    }


//    @BindingAdapter("imageUrlCircle")
//    public static void loadImageUrlCircle(ImageView imageView, String url) {
//        if (url != null) {
//            Context context = imageView.getContext();
//            CommonUtils commonUtils = new CommonUtils(context);
//            GlideApp.with(imageView)
//                    .load(url)
//                    .apply(bitmapTransform(new CropCircleTransformation()))
//                    .placeholder(commonUtils.getCircularProgressDrawable())
//                    .into(imageView);
//        }
//    }

    @BindingAdapter("imageUrl")
    public static void loadImageUrl(ImageView imageView, String url) {
        if (url != null) {
            Context context = imageView.getContext();

            CommonUtils commonUtils = new CommonUtils(context);

            GlideApp.with(imageView)

                    .load(url)
                    .placeholder(commonUtils.getCircularProgressDrawable())
                    .into(imageView);
        }
    }
//
//    @BindingAdapter("paletteDrawable")
//    public static void setCollapsingToolbarLayoutPaletteDrawable(CollapsingToolbarLayout view, Drawable drawable) {
//        if (drawable != null) {
//            Palette vibrantSwatch = Palette.from(CommonUtils.drawableToBitmap(drawable)).generate();
//            view.setContentScrimColor(vibrantSwatch.getMutedColor(colorPrimaryDark));
//            view.setStatusBarScrimColor(vibrantSwatch.getMutedColor(colorPrimary));
//        }
//
//    }
//
//    @BindingAdapter("paletteDrawable")
//    public static void setToolbarPaletteDrawable(Toolbar view, Drawable drawable) {
//        if (drawable != null) {
//            Context context = view.getContext();
//            Palette vibrantSwatch = Palette.from(CommonUtils.drawableToBitmap(drawable)).generate();
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                view.setTitleTextColor(vibrantSwatch.getMutedColor(context.getResources().getColor(textLightPrimary)));
//            }
//        }
//    }

    @BindingAdapter("drawable")
    public static void setImageDrawable(ImageView imageView, Drawable drawable) {
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    @BindingAdapter("visibility")
    public static void setVisibility(View view, Boolean value) {
        if (value != null)
            view.setVisibility(value ? View.VISIBLE : View.GONE);
    }



    @BindingAdapter("tintColor")
    public static void setTintColor(ImageView imageView, @ColorRes int resourceId) {
        if (resourceId != 0)
            imageView.setColorFilter(imageView.getResources().getColor(resourceId), PorterDuff.Mode.SRC_IN);

    }

    @BindingAdapter("android:src")
    public static void setImage(ImageView imageView, int resourceId) {
        if (resourceId != 0)
            imageView.setImageResource(resourceId);
    }


    @BindingAdapter("android:drawableStart")
    public static void setDrawableStart(TextView textView, int resourceId) {
        if (resourceId != 0) {
            Drawable drawable = AppCompatResources.getDrawable(textView.getContext(), resourceId);
            Drawable[] drawables = textView.getCompoundDrawables();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                textView.setCompoundDrawablesRelative(drawable,
                        drawables[1], drawables[2], drawables[3]);
            }else{
                textView.setCompoundDrawables(drawable,
                        drawables[1], drawables[2], drawables[3]);
            }
        }

    }


    //-------------------SwipeRefreshLayout----------------------

    @BindingAdapter("onRefresh")
    public static void onRefresh(SwipeRefreshLayout view, SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        if (onRefreshListener != null)
            view.setOnRefreshListener(onRefreshListener);
    }

    @BindingAdapter("onTouchListener")
    public static void onRefresh(View view, View.OnTouchListener onTouchListener) {
        if (onTouchListener != null)
            view.setOnTouchListener(onTouchListener);
    }


    @BindingAdapter("Enable")
    public static void setEnable(SwipeRefreshLayout view, Boolean flag) {
        if (flag != null)
            view.setEnabled(flag);
    }

    @BindingAdapter("ColorScheme")
    public static void setColorScheme(SwipeRefreshLayout view, int colorScheme) {
        view.setColorSchemeResources(CommonUtils.colorScheme);
    }

    @BindingAdapter("ColorScheme")
    public static void setColorScheme(ProgressBar view, int colorScheme) {
        if (colorScheme != 0)
            view.getIndeterminateDrawable().setColorFilter(colorScheme
                    , PorterDuff.Mode.SRC_OUT);
    }











}
