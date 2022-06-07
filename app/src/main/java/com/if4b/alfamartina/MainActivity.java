package com.if4b.alfamartina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvAlfam;
    private ArrayList<Alfamart> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvAlfam = findViewById(R.id.rv_alfamart);
        rvAlfam.setHasFixedSize(true);

        data.addAll(DataAlfamart.ambilAlfamart());

    }

    private void menampilkanCard(){
        rvAlfam.setLayoutManager(new LinearLayoutManager(this));
        AdapterCard colok = new AdapterCard(data);
        rvAlfam.setAdapter(colok);
    }
}