package com.jb.bjho6.myapplication11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ListView listView;
    ArrayList<FileInfo> data = new ArrayList<FileInfo>();
    FileExplorerAdapter fileExplorerAdapter;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_practice5);

        listView = (ListView)findViewById(R.id.listView);
        et = (EditText)findViewById(R.id.edittext);
        ImageButton ibAdd = (ImageButton)findViewById(R.id.imagebutton);
        ImageButton ibDelete = (ImageButton)findViewById(R.id.imageButton2);

//        FileInfo file1 = new FileInfo(R.drawable.fileicon_apk, "파일1", 12345);
//        data.add(file1);
//        data.add(new FileInfo(R.drawable.fileicon_bin, "파일2", 325));


        fileExplorerAdapter = new FileExplorerAdapter(this, R.layout.listview_item5, data);
        listView.setAdapter(fileExplorerAdapter);

        ibAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                data.add(new FileInfo(View.NO_ID, et.getText().toString(), 0));       // 이건 왜 안될까..?
                fileExplorerAdapter.add(new FileInfo(View.NO_ID, et.getText().toString(), 0));
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(), "눌림", Toast.LENGTH_SHORT).show();
                FileInfo checkedInfo = data.get(position);

            }
        });

    }

}
