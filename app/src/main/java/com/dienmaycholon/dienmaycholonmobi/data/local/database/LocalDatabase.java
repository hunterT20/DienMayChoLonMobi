package com.dienmaycholon.dienmaycholonmobi.data.local.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.dienmaycholon.dienmaycholonmobi.data.local.dao.ProductDAO;
import com.dienmaycholon.dienmaycholonmobi.data.local.dao.UserDAO;
import com.dienmaycholon.dienmaycholonmobi.data.model.Child;
import com.dienmaycholon.dienmaycholonmobi.data.model.User;

@Database(entities = {Child.class, User.class}, version = 2, exportSchema = false)
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

    public abstract UserDAO getUserDao();
}
