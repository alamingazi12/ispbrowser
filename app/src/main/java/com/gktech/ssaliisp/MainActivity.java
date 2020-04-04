package com.gktech.ssaliisp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageButton;

import com.gktech.ssaliisp.adapter.WebLinkAdapter;
import com.gktech.ssaliisp.model.Website;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Website> weblist;

    EditText searchinput1,searchinput2;
    RecyclerView recyclerView_containerList;

    ImageButton imageButton_go1,imageButton_go2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initAll();
        imageButton_go1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String url= searchinput1.getText().toString();
               Intent intent=new Intent(MainActivity.this,SearchActivity.class) ;
               intent.putExtra("url",url);
               startActivity(intent);
            }
        });

        imageButton_go2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url= searchinput2.getText().toString();
                Intent intent=new Intent(MainActivity.this,SearchActivity.class) ;
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });
    }

    private void initAll() {
        recyclerView_containerList=findViewById(R.id.web_container_list);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(MainActivity.this,5);
        recyclerView_containerList.setLayoutManager(gridLayoutManager);
        searchinput1=findViewById(R.id.search_go_input);
        searchinput2=findViewById(R.id.search_go_input2);
        imageButton_go1=findViewById(R.id.imageButton_search1);
        imageButton_go2=findViewById(R.id.imageButton_search2);
        weblist=new ArrayList<>();


        weblist.add(new Website("Facebook",R.drawable.facebook,"www.youtube.com"));
        weblist.add(new Website("Twitter",R.drawable.twiter2,"www.youtube.com"));
        weblist.add(new Website("Instagram",R.drawable.instagram2,"www.youtube.com"));
        weblist.add(new Website("Skype",R.drawable.skype,"www.youtube.com"));
        weblist.add(new Website("Yahoo",R.drawable.yahoo,"www.youtube.com"));
        weblist.add(new Website("Microsoft",R.drawable.microsoft,"www.youtube.com"));
        weblist.add(new Website("Google",R.drawable.google_image,"www.youtube.com"));
        weblist.add(new Website("Youtube",R.drawable.youtube_icon,"www.youtube.com"));

         WebLinkAdapter adapter=new WebLinkAdapter(weblist,MainActivity.this);
         recyclerView_containerList.setAdapter(adapter);
    }


}
