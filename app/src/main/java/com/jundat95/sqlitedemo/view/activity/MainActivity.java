package com.jundat95.sqlitedemo.view.activity;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.jundat95.sqlitedemo.R;
import com.jundat95.sqlitedemo.model.ToDo;
import com.jundat95.sqlitedemo.sqliteDb.MyHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Button btnAddToDo;

    private List<ToDo> toDos = new ArrayList<>();
    private MyHelper myHelper = new MyHelper(this, 2);
    private AdapterToDo adapterToDo;

    public static final int Main_Activity = 1;
    public static final int ToDo_Activity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        getData();
    }

    public void init () {

        listView = (ListView) findViewById(R.id.recycle_list_to_do);
        btnAddToDo = (Button) findViewById(R.id.btnAddToDo);


        btnAddToDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddToDoActivity.class);
                startActivityForResult(intent, Main_Activity);
            }
        });
    }


    private void getData () {
        toDos.clear();
        Cursor cursor = myHelper.getDataToDo();
        while (cursor.moveToNext()) {
            toDos.add(new ToDo(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)
            ));
        }

        adapterToDo = new AdapterToDo(this, R.layout.activity_main, toDos);
        listView.setAdapter(adapterToDo);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Main_Activity) {
            getData();
        }
    }
}
