package ddwu.mobile.finalproject.ma01_20201020;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class PostDBHelper extends SQLiteOpenHelper {
    final static String TAG = "PostDBHelper";

    final static String DB_NAME = "posts.db";
    public final static String TABLE_NAME = "post_table";

    public final static String COL_ID = "_id";
    public final static String COL_TITLE = "title";
    public final static String COL_DATE = "date";
    public final static String COL_CONTENT = "content";
    public final static String COL_PLACE = "place";

    public PostDBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID + " integer primary key autoincrement, " +
                COL_TITLE + " TEXT, " + COL_DATE + " TEXT, " + COL_PLACE + " TEXT, " + COL_CONTENT + " TEXT)";
        Log.d(TAG, sql);
        db.execSQL(sql);

        insertSample(db);// 샘플이 필요할 경우 추가
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    private void insertSample(SQLiteDatabase db) {
        db.execSQL("insert into " + TABLE_NAME + " values (null, '더비로드', '221203', '고척돔', '너무 즐거운 시간들');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '더비로드', '221203', '고척돔', '너무 즐거운 시간들');");
    }


}