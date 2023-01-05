package ddwu.mobile.finalproject.ma01_20201020;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class PostManager {
    PostDBHelper postDBHelper;
    Cursor cursor = null;

    final static String TAG = "WriteActivity";
    public PostManager(Context context) {
        postDBHelper = new PostDBHelper(context);
    }

    //    DB의 모든 food를 반환
    public ArrayList<Post> getAllPost() {
        ArrayList postList = new ArrayList();
        SQLiteDatabase db= postDBHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + PostDBHelper.TABLE_NAME, null);

        while(cursor.moveToNext()) {
            long id = cursor.getInt(cursor.getColumnIndex(PostDBHelper.COL_ID));
            String title = cursor.getString(cursor.getColumnIndex(PostDBHelper.COL_TITLE));
            String date = cursor.getString(cursor.getColumnIndex(PostDBHelper.COL_DATE));
            String place = cursor.getString(cursor.getColumnIndex(PostDBHelper.COL_PLACE));
            String content = cursor.getString(cursor.getColumnIndex(PostDBHelper.COL_CONTENT));
            postList.add(new Post (id, title, date, place, content));
        }
        cursor.close();
        postDBHelper.close();
        return postList;
    }

    //    DB 에 새로운 food 추가
    public boolean addNewPost(Post newPost) {

        SQLiteDatabase db = postDBHelper.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(postDBHelper.COL_TITLE, newPost.getTitle());
        value.put(postDBHelper.COL_DATE, newPost.getDate());
        value.put(postDBHelper.COL_PLACE, newPost.getPlace());
        value.put(postDBHelper.COL_CONTENT, newPost.getContent());

//      insert 메소드를 사용할 경우 데이터 삽입이 정상적으로 이루어질 경우 1 이상, 이상이 있을 경우 0 반환 확인 가능
        long count = db.insert(postDBHelper.TABLE_NAME, null, value);
        postDBHelper.close();
        if (count > 0) return true;
        return true;
    }


    public boolean removePost(long id) {
        SQLiteDatabase sqLiteDatabase = postDBHelper.getWritableDatabase();
        String whereClause = postDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(id) };
        int result = sqLiteDatabase.delete(postDBHelper.TABLE_NAME, whereClause, whereArgs);
        postDBHelper.close();
        if (result > 0) return true;
        return false;
    }


    //    close 수행
    public void close() {
        if (postDBHelper != null) postDBHelper.close();
        if (cursor != null) cursor.close();
    };

}


