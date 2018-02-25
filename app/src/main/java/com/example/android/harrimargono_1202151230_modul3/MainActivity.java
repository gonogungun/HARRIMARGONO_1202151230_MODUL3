package com.example.android.harrimargono_1202151230_modul3;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Member variables
    private RecyclerView mRecyclerView;
    private ArrayList<Air> mSportsData;
    private AirAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.viewRecycle);

        //Set the Layout Manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Initialize the ArrayLIst that will contain the data
        mSportsData = new ArrayList<>();

        //Initialize the adapter and set it ot the RecyclerView
        mAdapter = new AirAdapter(this, mSportsData);
        mRecyclerView.setAdapter(mAdapter);

        //Get the data
        initializeData();


    }



    //method untuk inisialisasi data air
    private void initializeData() {
        //Get the resources from the XML file
        String[] airList = getResources().getStringArray(R.array.air_titles);
        String[] airInfo = getResources().getStringArray(R.array.air_info);
        TypedArray sportsImageResources = getResources().obtainTypedArray(R.array.sports_images);

        //Clear data untuk menghindari duplikasi
        mSportsData.clear();


        //Membuat array untuk list air
        for(int i=0;i<airList.length;i++){
            mSportsData.add(new Air(airList[i],airInfo[i],
                    sportsImageResources.getResourceId(i,0)));
        }

        sportsImageResources.recycle();

        //Notify the adapter of the change
        mAdapter.notifyDataSetChanged();
    }

    public void resetSports(View view) {
        initializeData();
    }

}