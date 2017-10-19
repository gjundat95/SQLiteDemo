package com.jundat95.sqlitedemo.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jundat95.sqlitedemo.R;
import com.jundat95.sqlitedemo.model.ToDo;
import com.jundat95.sqlitedemo.sqliteDb.MyHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddToDoActivity extends AppCompatActivity {

    private EditText edtTitle, edtDescription, edtDate;
    private String txtTitle, txtDescription, txtDate;
    private Button btnAdd;
    private MyHelper myHelper = new MyHelper(this, 3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);
        init();
    }

    public void init () {
        edtTitle = (EditText) findViewById(R.id.edtTitle);
        edtDescription = (EditText) findViewById(R.id.edtDescription);
        edtDate = (EditText) findViewById(R.id.edtDate);
        btnAdd = (Button) findViewById(R.id.btnAddToDo);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (valid()) {
                    String key = new Date().getTime() + "";
                    myHelper.createDataToto(new ToDo(
                            key,
                            txtTitle,
                            txtDescription,
                            txtDate
                    ));

                    finish();
                }
            }
        });

    }

    public boolean valid () {
        boolean isTrue = true;

        txtTitle = edtTitle.getText().toString();
        txtDescription = edtDescription.getText().toString();
        txtDate = edtDate.getText().toString();

        if (txtTitle.isEmpty()) {
            edtTitle.setError("Please input string");
            isTrue = false;
        } else {
            edtTitle.setError(null);
        }

        if (txtDescription.isEmpty()) {
            edtDescription.setError("Please input string");
            isTrue = false;
        } else {
            edtDescription.setError(null);
        }

        if (txtDate.isEmpty()) {
            txtDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        } else {
            edtDate.setError(null);
        }

        return isTrue;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // your code here
            if (valid()) {
                String key = new Date().getTime() + "";
                myHelper.createDataToto(new ToDo(
                        key,
                        txtTitle,
                        txtDescription,
                        txtDate
                ));

                finish();
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
