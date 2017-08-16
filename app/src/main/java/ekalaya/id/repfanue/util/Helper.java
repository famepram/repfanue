package ekalaya.id.repfanue.util;

/**
 * Created by Femmy on 8/15/2017.
 */

public class Helper {

    public static int getCurrentTimestamp(){
        long ts = (long)  System.currentTimeMillis() / 1000L;
        return (int) ts;
    }
}
