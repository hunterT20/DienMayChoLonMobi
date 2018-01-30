package com.dienmaycholon.dienmaycholonmobi.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.dienmaycholon.dienmaycholonmobi.data.daoRoom.ChildDAO;
import com.dienmaycholon.dienmaycholonmobi.data.model.Child;

@Database(entities = {Child.class}, version = 1)
public abstract class DienMayChoLonLocalDatabase extends RoomDatabase {

    private static final String DB_NAME = "dmclLocal.db";
    private static volatile DienMayChoLonLocalDatabase instance;

    static synchronized DienMayChoLonLocalDatabase getInstance(Context context){
        if (instance == null){
            instance = create(context);
        }
        return instance;
    }

    private static DienMayChoLonLocalDatabase create(Context context) {
        return Room.databaseBuilder(context, DienMayChoLonLocalDatabase.class, DB_NAME).build();
    }

    public abstract ChildDAO getChildDao();
}
