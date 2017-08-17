package ekalaya.id.repfanue.data.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ekalaya.id.repfanue.data.models.entities.FBApps;

/**
 * Created by Femmy on 8/13/2017.
 */

public class DBFunc {
    DBHelper dbHelper;

    @Inject
    public DBFunc(DBHelper dbHelper){
        this.dbHelper = dbHelper;
    }

    public void getAppsList(DBInterface.FBAppsList callback){
        List<FBApps> E = new ArrayList<FBApps>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                DBCons.TABLE_COLUMN_APPS_ID,
                DBCons.TABLE_COLUMN_FB_APPS_ID,
                DBCons.TABLE_COLUMN_APPS_NAME,
                DBCons.TABLE_COLUMN_APPS_CATEGORY,
                DBCons.TABLE_COLUMN_APPS_REVENUE,
                DBCons.TABLE_COLUMN_ACTIVE
        };

        Cursor c = db.query(DBCons.TABLE_APPS, projection, null, null, null, null, null);
        if(c != null && c.getCount() > 0){
            while(c.moveToNext()){
                int apps_id             = c.getInt(c.getColumnIndexOrThrow(DBCons.TABLE_COLUMN_APPS_ID));
                String fb_apps_id       = c.getString(c.getColumnIndexOrThrow(DBCons.TABLE_COLUMN_FB_APPS_ID));
                String apps_name        = c.getString(c.getColumnIndexOrThrow(DBCons.TABLE_COLUMN_APPS_NAME));
                String category         = c.getString(c.getColumnIndexOrThrow(DBCons.TABLE_COLUMN_APPS_NAME));
                Double revenue          = c.getDouble(c.getColumnIndexOrThrow(DBCons.TABLE_COLUMN_APPS_REVENUE));
                int active              = c.getInt(c.getColumnIndexOrThrow(DBCons.TABLE_COLUMN_ACTIVE));
                FBApps mApps            = new FBApps();
                mApps.setApps_id(apps_id);
                mApps.setFbapps_id(fb_apps_id);
                mApps.setApps_name(apps_name);
                mApps.setCategory(category);
                mApps.setRevenue(revenue);
                mApps.setActive(active == 0 ? false : true);
                E.add(mApps);
            }
        }

        if (c != null) {
            c.close();
        }
        db.close();
        if(E.isEmpty()){
            callback.emptyList();
        } else {
            callback.successGetList(E);
        }
    }

    public boolean SaveApp(FBApps mApp, DBInterface.SaveAppListener cb){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBCons.TABLE_COLUMN_APPS_NAME, mApp.getApps_name());
        values.put(DBCons.TABLE_COLUMN_FB_APPS_ID, mApp.getFbapps_id());
        values.put(DBCons.TABLE_COLUMN_ACTIVE, mApp.isActive());

        if(mApp.getApps_id() > 0){
            String AppsID =  String.valueOf(mApp.getApps_id());
            db.update(DBCons.TABLE_APPS, values,DBCons.TABLE_COLUMN_APPS_ID +" = ?", new String[] {AppsID});
            cb.onSaveSuccess();
            return true;
        } else {
            long newRowId = 0;
            newRowId = db.insert(DBCons.TABLE_APPS, null, values);
            if(newRowId > 0){
                cb.onSaveSuccess();
                return true;
            } else {
                cb.onSaveFailed();
                return false;
            }
        }
    }

    public void deleteApp(int id, DBInterface.deleteAppsLiestener cb){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String whereClause = DBCons.TABLE_COLUMN_APPS_ID+"=?";
        String[] whereArgs = new String[] { String.valueOf(id) };
        db.delete(DBCons.TABLE_APPS, whereClause, whereArgs);
        cb.onDelete();
    }

    public boolean FBAppsExists(String fbapp_id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor mCount= db.rawQuery("select count(*) from "+DBCons.TABLE_APPS+" where "+DBCons.TABLE_COLUMN_FB_APPS_ID+"='" + fbapp_id + "'", null);
        mCount.moveToFirst();
        int count = mCount.getInt(0);
        mCount.close();
        if(count > 0){
            return true;
        }
        return false;
    }
}
