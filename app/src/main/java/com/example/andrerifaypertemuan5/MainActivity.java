package com.example.andrerifaypertemuan5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    public static ArrayList<Shape> shapeList = new ArrayList<Shape>();

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupData();
        setUpList();
        setUpOnclickListener();
    }

    private void setupData()
    {
        Shape orange = new Shape("0", "Orange        47 Calories", R.drawable.orange);
        shapeList.add(orange);

        Shape banana = new Shape("2","Banana        89 Calories", R.drawable.banana);
        shapeList.add(banana);

        Shape apple = new Shape("3","Apple           52 Calories", R.drawable.apple);
        shapeList.add(apple);

        Shape kiwi = new Shape("4","Kiwi              61 Calories", R.drawable.kiwi);
        shapeList.add(kiwi);

        Shape strawberry = new Shape("6","Strawberry     33 Calories", R.drawable.strawberry);
        shapeList.add(strawberry);

    }

    private void setUpList()
    {
        listView = (ListView) findViewById(R.id.shapesListView);

        ShapeAdapter adapter = new ShapeAdapter(getApplicationContext(), 0, shapeList);
        listView.setAdapter(adapter);
    }

    private void setUpOnclickListener()
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                Shape selectShape = (Shape) (listView.getItemAtPosition(position));
                Intent showDetail = new Intent(getApplicationContext(), DetailActivity.class);
                showDetail.putExtra("id",selectShape.getId());
                startActivity(showDetail);
            }
        });

    }

}