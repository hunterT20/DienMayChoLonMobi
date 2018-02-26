package com.dienmaycholon.dienmaycholonmobi.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import com.dienmaycholon.dienmaycholonmobi.data.model.User;

@Dao
public interface UserDAO {
    @Insert
    void insert(User... users);
}
