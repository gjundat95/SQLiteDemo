package com.jundat95.sqlitedemo.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jundat95.sqlitedemo.R;
import com.jundat95.sqlitedemo.model.ToDo;

import java.util.List;

/**
 * Created by tinhngo on 12/09/2017.
 */

public class AdapterToDo extends ArrayAdapter<ToDo> {

    private Context context;
    private List<ToDo> toDos;
    private View parent;

    public AdapterToDo(@NonNull Context context, @LayoutRes int resource, @NonNull List<ToDo> listToDo) {
        super(context, resource, listToDo);
        this.context = context;
        this.toDos = listToDo;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.list_view_todo, parent, false);

        TextView tvTitle = convertView.findViewById(R.id.txtTitle);
        TextView tvDescription = convertView.findViewById(R.id.txtDescription);
        TextView tvDate = convertView.findViewById(R.id.txtDate);
        RelativeLayout relativeLayout = convertView.findViewById(R.id.cell_list_view);

        tvTitle.setText(toDos.get(position).getTitle());
        tvDescription.setText(toDos.get(position).getDescription());
        tvDate.setText(toDos.get(position).getDate());


        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("key", toDos.get(position).getKey());
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
