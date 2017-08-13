package ekalaya.id.repfanue.data.db;

import javax.inject.Inject;

/**
 * Created by Femmy on 8/13/2017.
 */

public class DBFunc {
    DBHelper dbHelper;

    @Inject
    public DBFunc(DBHelper dbHelper){
        this.dbHelper = dbHelper;
    }
}
