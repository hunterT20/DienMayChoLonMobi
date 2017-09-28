package com.dienmaycholon.dienmaycholonmobi.util;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class RecyclerViewHorizontalUtil {
    public static void setupRecyclerView(RecyclerView recyclerView, RecyclerView.Adapter adapter, Context context){
        recyclerView.setAdapter(adapter);
        LinearLayoutManager MyLayoutManager = new LinearLayoutManager(context);
        MyLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(MyLayoutManager);
        recyclerView.setHasFixedSize(true);
    }
}
