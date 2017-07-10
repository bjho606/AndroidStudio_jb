package com.jb.bjho6.myapplication11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> data = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

/*
        TextView tv1 = new TextView(this);
        TextView tv2 = new TextView(this);
        TextView tv3 = tv1;

        if(tv1==tv3){
            Log.d("TAG", "tv1과 tv3는 같은 객체를 참조합니다.");
        }
        Log.d("TAG", ""+ tv1);

        int hash = System.identityHashCode(tv1);
        String strHash = Integer.toHexString(hash);
        Log.d("TAG", strHash);
*/

        setContentView(R.layout.listview_practice4);

        for(int i=0; i<100; i++){
            data.add("데이터"+(i+1));
        }

        ListView listView = (ListView)findViewById(R.id.listView);

//        <ArrayAdapter로 할 때>
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.listview_item4, data);
//        listView.setAdapter(arrayAdapter);
//        <BaseAdapter로 할 때>
        MyBaseAdapter myBaseAdapter = new MyBaseAdapter(this, R.layout.listview_item4, data);
        listView.setAdapter(myBaseAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String msg = String.format("position : %d\t%s", position, view.toString());
                Log.d("TAG", msg);
            }
        });

    }
}
