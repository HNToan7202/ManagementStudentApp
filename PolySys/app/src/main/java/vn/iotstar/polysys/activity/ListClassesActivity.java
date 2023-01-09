package vn.iotstar.polysys.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import vn.iotstar.polysys.R;
import vn.iotstar.polysys.SQLite.ClassesDAO;
import vn.iotstar.polysys.adapter.ClassesAdapter;
import vn.iotstar.polysys.model.Classes;

public class ListClassesActivity extends AppCompatActivity {
    private ListView lvClasses ;
    private List<Classes> list;
    private ClassesAdapter clsadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_classes);

        lvClasses = findViewById(R.id.lvClasses);
        fillClassesListView();

        lvClasses.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                ClassesDAO dao = new ClassesDAO(ListClassesActivity.this);
                Classes cls = list.get(i);
                dao.delete(""+cls.getId());
                Toast.makeText(ListClassesActivity.this,"Deleted :"+cls.getName(),Toast.LENGTH_LONG).show();
                fillClassesListView();
                return false;
            }
        });
    }

    private void fillClassesListView() {
        ClassesDAO dao = new ClassesDAO(this);
        list = dao.findAll();

        clsadapter = new ClassesAdapter(this, list);
        lvClasses.setAdapter(clsadapter);



    }
}