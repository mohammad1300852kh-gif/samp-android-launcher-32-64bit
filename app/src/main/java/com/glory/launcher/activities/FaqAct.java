package com.glory.launcher.activities;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.glory.game.R;
import com.glory.launcher.network.Movie;
import com.glory.launcher.network.MovieAdapter;

import java.util.ArrayList;
import java.util.List;

public class FaqAct extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Movie> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_help);

        recyclerView = findViewById(R.id.faq_recycler);


        ImageButton btnClose = findViewById(R.id.btn_close);
        if (btnClose != null) {
            btnClose.setOnClickListener(v -> finish());
        }

        initData();
        initRecyclerView();
    }

    private void initRecyclerView() {
        MovieAdapter movieAdapter = new MovieAdapter(movieList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(movieAdapter);
    }

    private void initData() {
        movieList = new ArrayList<>();
        onEnterAnimationComplete();

        movieList.add(new Movie("Rockstar",
                "Rockstar"));

        movieList.add(new Movie("Rockstar",
                "لانچر Rockstar — ساده و پایدار. اجرای آسان، رابط کاربری زیبا و پایداری بالا."));

        movieList.add(new Movie("Rockstar",
                "تیم Rockstar."));

        movieList.add(new Movie("Rockstar Mobile",
                "هر آنچه برای یک پروژه‌ی مدرن لازم است، در یک لانچر. ساده، شیک و قابل‌اعتماد."));
    }
}
