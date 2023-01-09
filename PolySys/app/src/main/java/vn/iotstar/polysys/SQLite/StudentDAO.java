package vn.iotstar.polysys.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import vn.iotstar.polysys.helper.DateTimeHelper;
import vn.iotstar.polysys.model.Classes;
import vn.iotstar.polysys.model.Student;

public class StudentDAO {

    private SQLiteDatabase db;

    public StudentDAO(Context context){
        DBHelper dbHelper = new DBHelper(context);
        this.db = dbHelper.getWritableDatabase();
    }

    //Chèn thông tin 1 lớp học mới
    public long insert(Student emp){
        ContentValues values = new ContentValues();
        values.put("studentId", emp.getStudentId());
        values.put("studentName", emp.getStudentName());
        values.put("Dob", DateTimeHelper.toString(emp.getDob()));
        values.put("classId", emp.getClassId());
        return db.insert("students", null,values);
    }

}
