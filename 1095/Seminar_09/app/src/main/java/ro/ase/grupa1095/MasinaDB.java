package ro.ase.grupa1095;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Masina.class}, version = 1, exportSchema = false)
public abstract class MasinaDB extends RoomDatabase{
    public static final String MASINI_DB = "masini.db";
    private static MasinaDB instanta;

    public static MasinaDB getInstance(Context context){
        if(instanta==null){
            instanta = Room.databaseBuilder(context,
                    MasinaDB.class, MASINI_DB)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instanta;
    }

    public abstract MasinaDao getMasinaDao();
}
