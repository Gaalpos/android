package com.example.a041_popupmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;


public class MainActivity extends AppCompatActivity {

    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButton.findViewById(R.id.imageButton);
    }
    private PopupMenu.onMenuItemClickListener = new PopupMenu.OnMenuItemClickListener(){
    @Override
            public boolean onMenuItemClick(MenuItem item){
        int num=item.getItemId();

        }
    }

    public void showPopupMenu(View view){
        PopupMenu popupMenu = menu PopupMenu(MainActivity.this,view);
        popupMenu.inflate(R.menu.menu_popup);
        popupMenu.setOnMenuItemClickListener(onMenuItemCLickListener);
        popupMenu.show();

    }
}