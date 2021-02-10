package com.example.recyclerview1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.session.MediaSession;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  MyrecyclerViewAdapter.Callback {
    private MyrecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MyrecyclerViewAdapter(this, this);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        List<Message> generateMessage = generateMessage();
        adapter.setItems(generateMessage);


    }

    @Override
    public void onItemLongClicked(Message message) {
        adapter.removeItem(message);
    }


    private List<Message> generateMessage() {
        List<Message> list = new ArrayList<Message>();
        for (int i = 0; i < 20; i++) {
            Message message = new Message();
            message.setTitle("Title" + i);
            message.setMessage("Message" + i);
            list.add(message);

        }
        return list;

    }


}