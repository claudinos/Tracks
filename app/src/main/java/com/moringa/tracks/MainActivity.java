package com.moringa.tracks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
<<<<<<< HEAD
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
=======
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
>>>>>>> 80257e2bc4bd6f8c9b7d62a994434973e3a29a1b

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
<<<<<<< HEAD
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
=======

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(mToggle.onOptionsItemSelected(item)){
>>>>>>> 80257e2bc4bd6f8c9b7d62a994434973e3a29a1b
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
<<<<<<< HEAD
    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
=======

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
>>>>>>> 80257e2bc4bd6f8c9b7d62a994434973e3a29a1b
}
