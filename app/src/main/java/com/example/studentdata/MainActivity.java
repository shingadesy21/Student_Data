package com.example.studentdata;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    RecyclerView recyclerView;
    Button add;
    ImageView imageView;
    TextView no_data;
    //private List<Dataitem> items=new ArrayList<>();;
    private ItemAdapter itemAdapter;
    Helper helper;
    ArrayList<String> name,classname,grade;
    @Override
        protected void onCreate(Bundle savedInstanceState)
        {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                recyclerView=findViewById(R.id.recycler_view);
                add=findViewById(R.id.add_btn);
                imageView=findViewById(R.id.empty_imageview);
                no_data=findViewById(R.id.no_data);


                DividerItemDecoration horizontalDecoration = new DividerItemDecoration(recyclerView.getContext(),
                        DividerItemDecoration.VERTICAL);
                Drawable horizontalDivider = ContextCompat.getDrawable(getApplicationContext(), R.drawable.divider);
                horizontalDecoration.setDrawable(horizontalDivider);
                recyclerView.addItemDecoration(horizontalDecoration);

                recyclerView.setHasFixedSize(true);
                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
                recyclerView.setLayoutManager(linearLayoutManager);

                recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));


                helper=new Helper(this);


                name=new ArrayList<>();
                classname=new ArrayList<>();
                grade=new ArrayList<>();

                storeData();

                itemAdapter=new ItemAdapter(MainActivity.this,this,name,classname,grade);
                recyclerView.setAdapter(itemAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        startActivity(new Intent(getApplicationContext(),Add_Details.class));
                    }
                });

        }
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
        {
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode == 1)
            {
                recreate();
            }
        }

            private void storeData()
            {
                  Cursor cursor=helper.getAllData();
                  if(cursor.getCount()==0)
                       {
                              imageView.setVisibility(View.VISIBLE);
                              no_data.setVisibility(View.VISIBLE);
                       }
                       else
                       {
                            while (cursor.moveToNext())
                            {
                                  name.add(cursor.getString(0));
                                  classname.add(cursor.getString(2));
                                  grade.add(cursor.getString(4));
                            }
                            imageView.setVisibility(View.GONE);
                            no_data.setVisibility(View.GONE);
                       }

            }

    }