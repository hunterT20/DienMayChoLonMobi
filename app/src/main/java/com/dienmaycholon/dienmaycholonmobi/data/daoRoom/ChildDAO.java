package com.dienmaycholon.dienmaycholonmobi.data.daoRoom;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.dienmaycholon.dienmaycholonmobi.data.model.Child;

import java.util.List;

@Dao
public interface ChildDAO {
    @Query("SELECT * FROM Child")
    List<Child> getListProductCurrentBuy();

    @Insert
    void insert(Child... children);

    @Update
    void update(Child... children);

    @Delete
    void delete(Child... children);
}
