package ro.ase.grupa1098;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AutobuzDao {

    @Insert
    long insertAutobuz(Autobuz autobuz);

    @Query("SELECT * from autobuze WHERE nrLocuri > :nrL")
    List<Autobuz> selectAll(int nrL);

    @Delete
    void deleteAutobuz(Autobuz autobuz);
}
