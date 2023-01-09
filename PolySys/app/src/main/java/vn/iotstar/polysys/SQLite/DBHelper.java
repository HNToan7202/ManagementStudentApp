package vn.iotstar.polysys.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME ="polysys";
    private static final int DB_VERSION = 1;



    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String classesSQL = "CREATE TABLE classes(id integer primary key autoincrement,"+
                " name text not null)";
        String studentSql = "CREATE TABLE students(id text primary key, name text not null, "+
                " classid integer, dob text, "+
                " FOREIGN KEY (classid) REFERENCES classes(id))";
        sqLiteDatabase.execSQL(classesSQL);
        sqLiteDatabase.execSQL(studentSql);
    }

    // nâng cấp csdl
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String classesSql = "DROP TABLE IF EXISTS classes";
        String studentsSql = "DROP TABLE IF EXISTS students";

        sqLiteDatabase.execSQL(studentsSql);
        sqLiteDatabase.execSQL(classesSql);

        onCreate(sqLiteDatabase); //gọi tạo lại bảng nâng cấp


    }
}
