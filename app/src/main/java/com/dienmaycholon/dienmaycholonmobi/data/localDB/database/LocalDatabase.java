package com.dienmaycholon.dienmaycholonmobi.data.localDB.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.dienmaycholon.dienmaycholonmobi.data.localDB.dao.ProductDAO;
import com.dienmaycholon.dienmaycholonmobi.data.model.Child;

@Database(entities = {Child.class}, version = 1, exportSchema = false)
public abstract class LocalDatabase extends RoomDatabase {

    private static final String DB_NAME = "dmclLocal.db";
    private static volatile LocalDatabase instance;

    public static synchronized LocalDatabase getInstance(Context context){
        if (instance == null){
            instance = create(context);
        }
        return instance;
    }

    private static LocalDatabase create(Context context) {
        return Room.databaseBuilder(context, LocalDatabase.class, DB_NAME).build();
    }

    public abstract ProductDAO getChildDao();
}
