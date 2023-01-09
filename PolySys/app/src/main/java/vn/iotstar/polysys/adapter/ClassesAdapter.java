package vn.iotstar.polysys.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.time.temporal.Temporal;
import java.util.List;

import vn.iotstar.polysys.R;
import vn.iotstar.polysys.SQLite.ClassesDAO;
import vn.iotstar.polysys.model.Classes;

public class ClassesAdapter extends BaseAdapter {
    private Context context;
    private List<Classes> list;

    public ClassesAdapter(Context context, List<Classes> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.layout_classes_item, null);
        }
        TextView tvId = view.findViewById(R.id.tvClassId);
        TextView tvName = view.findViewById(R.id.tvClassName);
        Classes cls = list.get(i);

        tvId.setText(""+cls.getId());
        tvName.setText(cls.getName());
        return view;
    }
}
