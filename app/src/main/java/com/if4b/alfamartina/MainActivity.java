package com.if4b.alfamartina;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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
        menampilkanCard();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_top_right, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_mode_kartu:
                menampilkanCard();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void menampilkanCard(){
        rvAlfam.setLayoutManager(new LinearLayoutManager(this));
        AdapterCard colok = new AdapterCard(data);
        rvAlfam.setAdapter(colok);
    }
}