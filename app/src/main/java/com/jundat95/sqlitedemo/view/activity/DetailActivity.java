package com.jundat95.sqlitedemo.view.activity;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.jundat95.sqlitedemo.R;
import com.jundat95.sqlitedemo.sqliteDb.MyHelper;

public class DetailActivity extends AppCompatActivity {

    private TextView txtTitle, txtDescription, txtDate;
    private MyHelper myHelper = new MyHelper(this, 3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        init();

        Intent intent = this.getIntent();
        String key= intent.getStringExtra("key");
        Log.d("TAG", key);

        Cursor cursor = myHelper.getDataToDoByKey(key);
        while (cursor.moveToNext()) {
            txtTitle.setText(cursor.getString(0));
            txtDescription.setText(cursor.getString(1));
            txtDate.setText(cursor.getString(2));
        }

    }

    public void init () {
        txtTitle = (TextView) findViewById(R.id.textView4);
        txtDescription = (TextView) findViewById(R.id.textView5);
        txtDate = (TextView) findViewById(R.id.textView6);
    }
}
