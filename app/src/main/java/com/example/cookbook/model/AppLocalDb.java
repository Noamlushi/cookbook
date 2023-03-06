package com.example.cookbook.model;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.cookbook.MyApplication;

@Database(entities = {Recipe.class}, version = 80)
abstract class AppLocalDbRepository extends RoomDatabase {
    public abstract RecipeDao recipeDaoDao();
}


public class AppLocalDb {
    static public AppLocalDbRepository getAppDb() {
        return Room.databaseBuilder(MyApplication.getMyContext(),
                        AppLocalDbRepository.class,
                        "dbFileName.db")
                .fallbackToDestructiveMigration()
                .build();
    }

    private AppLocalDb(){}
}
