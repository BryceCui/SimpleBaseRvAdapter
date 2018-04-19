package com.cuipengyu.simplebaservadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView main_rv;
    List<Integer> mDdat;
    RecycleViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDdat = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mDdat.add(i);
        }
        main_rv = findViewById(R.id.main_rv);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        main_rv.setLayoutManager(manager);
        mAdapter = new RecycleViewAdapter( mDdat);
        main_rv.setAdapter(mAdapter);
        RvItemCallBack callBack= new RvItemCallBack(mAdapter);
        callBack.setLongEnabled(true);
        callBack.setSwipeEnabled(true);
        RvItemTouchHelper helper=new RvItemTouchHelper(callBack);
        helper.attachToRecyclerView(main_rv);
        main_rv.addOnItemTouchListener(new ItemClickListener(main_rv, new ItemClickListener.onItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "onItemClick", Toast.LENGTH_SHORT).show();
            }

        }));
        main_rv.addOnItemTouchListener(new ItemClickListener(main_rv, new ItemClickListener.onItemLongClickListener() {
            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(MainActivity.this, "onItemLongClick", Toast.LENGTH_SHORT).show();

            }
        }));

    }


}
