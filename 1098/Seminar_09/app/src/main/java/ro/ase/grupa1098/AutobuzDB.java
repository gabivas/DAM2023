package ro.ase.grupa1098;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Autobuz.class}, version = 1, exportSchema = false)
public abstract class AutobuzDB extends  RoomDatabase{
    private static final String DB_NAME = "autobuze.db";
    private static AutobuzDB instanta;

    public static AutobuzDB getInstance(Context context){
        if(instanta==null){
            instanta = Room.databaseBuilder(context, AutobuzDB.class, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instanta;
    }

    public abstract AutobuzDao getAutobuzDao();
}
