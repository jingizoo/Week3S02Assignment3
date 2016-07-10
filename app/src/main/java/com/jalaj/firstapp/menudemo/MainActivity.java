package com.jalaj.firstapp.menudemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        registerForContextMenu(button);
        textView = (TextView)findViewById(R.id.textColor);
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.item2:
                textView.setTextColor(Color.rgb(255, 87, 51));
                break;
            case R.id.item3:
                textView.setTextColor(Color.YELLOW);
                break;
            case R.id.item4:
                textView.setTextColor(Color.GREEN);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu ");
        menu.add(1,100,1,"Context Menu 1");
        menu.add(1,101,2,"Context Menu 1");
        menu.add(1,102,3,"Context Menu 1");
        menu.add(1,103,4,"Context Menu 1");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item1)
        {
            Toast.makeText(this,"This is 1",Toast.LENGTH_SHORT).show();
        }else

        {
            Toast.makeText(this,"This is "+id,Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}
