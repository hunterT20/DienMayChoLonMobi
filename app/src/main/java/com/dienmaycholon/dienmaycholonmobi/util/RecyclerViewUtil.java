package com.dienmaycholon.dienmaycholonmobi.util;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class RecyclerViewUtil {
    public static void setupRecyclerViewHorizontal(RecyclerView recyclerView, RecyclerView.Adapter adapter, Context context){
        recyclerView.setAdapter(adapter);
        LinearLayoutManager MyLayoutManager = new LinearLayoutManager(context);
        MyLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(MyLayoutManager);
        recyclerView.setHasFixedSize(true);
    }

    public static void setupRecyclerView(RecyclerView recyclerView, RecyclerView.Adapter adapter, Context context){
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
    }

    public static void setupRecyclerViewGrid(RecyclerView recyclerView, RecyclerView.Adapter adapter, Context context){
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        recyclerView.setHasFixedSize(true);
    }
}
