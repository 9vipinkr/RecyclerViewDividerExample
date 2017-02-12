package com.vipinkr.recyclerviewdividerexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerClickListener.OnRecyclerListener{
    private ArrayList<Movie> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        list=new ArrayList<Movie>();
        createValues();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        RecyclerViewAdapter recyclerViewAdapter=new RecyclerViewAdapter(this,list);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerClickListener(this,recyclerView,this));
        recyclerView.addItemDecoration(new DividerIdemDecoration(ContextCompat.getDrawable(getApplicationContext(),R.drawable.item_decorator)));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void createValues(){
        Movie m1=new Movie("Fantastic beasts");
        Movie m2=new Movie("Xmen");
        Movie m3=new Movie("Batman");
        Movie m4=new Movie("Suprman");
        Movie m5=new Movie("Spiderman");
        Movie m6=new Movie("Passengers");
        Movie m7=new Movie("The Avengers");
        Movie m8=new Movie("Titanic");
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);
        list.add(m5);
        list.add(m6);
        list.add(m7);
        list.add(m8);
    }

    @Override
    public void click(View view, int position) {
        Toast.makeText(this,"single click movie name: "+list.get(position).getName(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void longClick(View view, int position) {
        Toast.makeText(this,"long click movie name: "+list.get(position).getName(),Toast.LENGTH_SHORT).show();
    }
}
