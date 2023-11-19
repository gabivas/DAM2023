package ro.ase.grupa1095;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MasinaDao {

    @Insert
    void insertMasina(Masina masina);

    @Query("SELECT * FROM masini WHERE nrCaiPutere >:nrCaiP")
    List<Masina> selectMasini(int nrCaiP);

    @Delete
    void deleteMasina(Masina masina);
}
