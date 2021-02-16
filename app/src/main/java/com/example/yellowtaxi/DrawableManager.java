package com.example.yellowtaxi;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class DrawableManager {
    private static Context context = null;

    public DrawableManager(Context context) {
        this.context = context;

    }


    public static Drawable getDrawable(String name) {
        Resources resources = context.getResources();
        final int resourceId = resources.getIdentifier(name, "drawable",
                context.getPackageName());
        return resources.getDrawable(resourceId);    }
}
