package com.bill.sharedelementtransition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new MyAdapter(this);
        adapter.setList(getDatas());
        recyclerView.setAdapter(adapter);

        adapter.setOnClickListener(new MyAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this, DetialActivity.class);
                intent.putExtra("title", adapter.getItem(position));
                ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        MainActivity.this,
                        new Pair(view.findViewById(R.id.image), DetialActivity.KEY_IMAGE),
                        new Pair(view.findViewById(R.id.text), DetialActivity.KEY_TEXT));

                // ActivityCompat是android支持库中用来适应不同android版本的
                ActivityCompat.startActivity(MainActivity.this, intent, activityOptions.toBundle());

            }
        });

    }

    private List<String> getDatas() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("Item " + i);
        }
        return list;
    }

}
