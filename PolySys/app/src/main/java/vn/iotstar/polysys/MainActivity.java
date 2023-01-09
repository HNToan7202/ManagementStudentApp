package vn.iotstar.polysys;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import vn.iotstar.polysys.activity.ListClassesActivity;
import vn.iotstar.polysys.activity.ManageStudentActivity;
import vn.iotstar.polysys.dialog.NewClassDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnNewClass).setOnClickListener(this);
        findViewById(R.id.btnListClasses).setOnClickListener(this);
        findViewById(R.id.btnManagementStudent).setOnClickListener(this);
        findViewById(R.id.btnLogOut).setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnNewClass:
                NewClassDialog newClassDialog = new NewClassDialog(this);
                newClassDialog.show();
                //Toast.makeText(this,"New Class",Toast.LENGTH_LONG).show();
                break;
            case R.id.btnListClasses:
                Intent intent = new Intent(this, ListClassesActivity.class);
                startActivity(intent);

                break;
            case R.id.btnManagementStudent:
                Intent mgIntent = new Intent(this, ManageStudentActivity.class);
                startActivity(mgIntent);

                break;
            case R.id.btnLogOut:
                break;
        }
    }
}