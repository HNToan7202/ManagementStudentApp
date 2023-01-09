package vn.iotstar.polysys.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import vn.iotstar.polysys.R;
import vn.iotstar.polysys.SQLite.ClassesDAO;
import vn.iotstar.polysys.model.Classes;

public class NewClassDialog extends Dialog implements View.OnClickListener {

    private Context context;
    private EditText etClassId, etClassName;

    public NewClassDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_new_class);

        etClassId = findViewById(R.id.etClassId);
        etClassName = findViewById(R.id.etClassName);

        findViewById(R.id.btnSave).setOnClickListener(this);
        findViewById(R.id.btnClose).setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSave:
                Classes cls = new Classes();
                ClassesDAO dao = new ClassesDAO(context);
                cls.setName(etClassName.getText().toString());
                dao.insert(cls);
                Toast.makeText(context, "Completed",Toast.LENGTH_LONG).show();
                dismiss();
                break;

            case R.id.btnClose:
                dismiss();
                break;

        }

    }


}
