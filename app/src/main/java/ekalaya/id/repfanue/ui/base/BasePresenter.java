package ekalaya.id.repfanue.ui.base;

import javax.inject.Inject;

import ekalaya.id.repfanue.data.db.DBFunc;

/**
 * Created by Femmy on 8/13/2017.
 */

public class BasePresenter<T> {
    protected DBFunc dbFunc;

    protected T view;

    public BasePresenter(DBFunc dbFunc, T view){
        this.dbFunc = dbFunc;
        this.view = view;
    }
}
