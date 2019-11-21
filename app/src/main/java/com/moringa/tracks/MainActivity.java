package com.moringa.tracks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawLayout;
    private ActionBarDrawerToggle mToggle;

    DatabaseReference mRef;

//    // listview
//    ListView listViewNews;
//
//    List<News> newsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawLayout =(DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this,mDrawLayout,R.string.open,R.string.close);
        mDrawLayout.addDrawerListener(mToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        //listview
//        listViewNews =findViewById(R.id.listview);
//        newsList = new ArrayList<>();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

//    //listview
//    @Override
//    protected void onStart(){
//        super.onStart();
//
//        mRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                newsList.clear();
//
//                for(DataSnapshot newsSnapshot : dataSnapshot.getChildren()){
//                    News news = newsSnapshot.getValue(News.class);
//
//                    newsList.add(news);
//                }
//
//                NewsList adapter = new NewsList(MainActivity.this, newsList);
//                listViewNews.setAdapter(adapter);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }
}
