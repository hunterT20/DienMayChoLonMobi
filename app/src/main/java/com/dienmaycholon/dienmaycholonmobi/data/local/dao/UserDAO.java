package com.dienmaycholon.dienmaycholonmobi.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.dienmaycholon.dienmaycholonmobi.data.model.User;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface UserDAO {
    @Query("SELECT * FROM User")
    Flowable<List<User>> getUserInfo();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User... users);
}
