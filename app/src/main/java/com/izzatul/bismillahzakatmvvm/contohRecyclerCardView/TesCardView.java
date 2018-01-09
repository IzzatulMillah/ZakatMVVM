package com.izzatul.bismillahzakatmvvm.contohRecyclerCardView;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.izzatul.bismillahzakatmvvm.R;

import java.util.List;

/**
 * Created by Izzatul on 1/4/2018.
 */

public class TesCardView extends Activity{

    TextView personName;
    TextView personAge;
    ImageView personPhoto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tes_cardview);
        personName = (TextView)findViewById(R.id.person_name);
        personAge = (TextView)findViewById(R.id.person_age);
        personPhoto = (ImageView)findViewById(R.id.person_photo);

        personName.setText("Emma Wilson");
        personAge.setText("23 years old");
        personPhoto.setImageResource(R.drawable.ic_launcher_background);
    }
}
