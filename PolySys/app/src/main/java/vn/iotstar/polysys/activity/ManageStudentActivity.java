package vn.iotstar.polysys.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import vn.iotstar.polysys.R;
import vn.iotstar.polysys.SQLite.ClassesDAO;
import vn.iotstar.polysys.SQLite.StudentDAO;
import vn.iotstar.polysys.adapter.ClassesAdapter;
import vn.iotstar.polysys.helper.DateTimeHelper;
import vn.iotstar.polysys.model.Classes;
import vn.iotstar.polysys.model.Student;

public class ManageStudentActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etStudentId, etName, etDob;
    private Spinner spClasses;
    private List<Classes> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_student);

        etStudentId = findViewById(R.id.etStudentId);
        etName = findViewById(R.id.etStudentName);
        etDob = findViewById(R.id.etDob);
        spClasses = findViewById(R.id.spClasses);
        fillClassesToSpinner();
        findViewById(R.id.btnLuu).setOnClickListener(this);

    }

    //đổ đầy spinner

    private void fillClassesToSpinner(){
        ClassesDAO dao = new ClassesDAO(this);
        list = dao.findAll();
        ClassesAdapter classesAdapter = new ClassesAdapter(this,list);
        spClasses.setAdapter(classesAdapter);

    }

    @Override
    public void onClick(View view) {
        StudentDAO dao = new StudentDAO(this);
        switch (view.getId()){
            case R.id.btnLuu:
                try {
                    Student st = new Student();
                    st.setStudentId(etStudentId.getText().toString());
                    st.setStudentName(etName.getText().toString());
                    st.setDob(DateTimeHelper.toDate(etDob.getText().toString()));

                    Classes cls = (Classes) spClasses.getSelectedItem(); //lấy đối tượng được chọn trong spinner
                    st.setClassId(cls.getId());

                    String msg;
                    dao.insert(st);
                    msg ="Student is saved !";

                    Snackbar snackbar = Snackbar.make(view,msg,Snackbar.LENGTH_LONG);
                    snackbar.show(); //hiển thị thông báo người dùng

                    etStudentId.setText("");
                    etName.setText("");
                    etDob.setText("");

                }catch (Exception ex)
                {
                    ex.printStackTrace();
                    Toast.makeText(this,"Error"+ex.getMessage(),Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}