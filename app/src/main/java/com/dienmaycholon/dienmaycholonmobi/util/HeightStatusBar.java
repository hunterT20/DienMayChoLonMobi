package com.dienmaycholon.dienmaycholonmobi.util;

import android.graphics.Rect;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

public class HeightStatusBar {

    public static int getHeightStatusbar(FragmentActivity activity){
        Rect rectangle = new Rect();
        Window window = activity.getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(rectangle);
        return rectangle.top;
    }

}
