package com.izzatul.bismillahzakatmvvm.contohRecyclerCardView;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.izzatul.bismillahzakatmvvm.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Izzatul on 1/4/2018.
 */

public class RecyclerViewActivity extends Activity{
    private List<Person> persons;
    private RecyclerView rv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tes_recyclerview);

        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Person("Emma Wilson", "23 years old", R.drawable.ic_launcher_background));
        persons.add(new Person("Lavery Maiss", "25 years old", R.drawable.ic_launcher_background));
        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.ic_launcher_background));
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(persons);
        rv.setAdapter(adapter);
    }
}
