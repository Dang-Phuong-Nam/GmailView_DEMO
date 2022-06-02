package com.example.gmailview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainView = findViewById(R.id.main_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mainView.setLayoutManager(layoutManager);
        mainView.setItemAnimator(new DefaultItemAnimator());
        List<Email> emails = Arrays.asList(
                new Email("Nam", "Come with me", new Date(1654041600L), true),
                new Email("Long", "And you'll be", new Date(1651363200L), false),
                new Email("Tran", "In a world of pure imagination", new Date(1654041599L), true),
                new Email("Nam", "Come with me", new Date(1654041600L), true),
                new Email("Long", "And you'll be", new Date(1651363200L), false),
                new Email("Tran", "In a world of pure imagination", new Date(1654041599L), true),
                new Email("Nam", "Come with me", new Date(1654041600L), true),
                new Email("Long", "And you'll be", new Date(1651363200L), false),
                new Email("Tran", "In a world of pure imagination", new Date(1654041599L), true),
                new Email("Nam", "Come with me", new Date(1654041600L), true),
                new Email("Long", "And you'll be", new Date(1651363200L), false),
                new Email("Tran", "In a world of pure imagination", new Date(1654041599L), true),
                new Email("Nam", "Come with me", new Date(1654041600L), true),
                new Email("Long", "And you'll be", new Date(1651363200L), false),
                new Email("Tran", "In a world of pure imagination", new Date(1654041599L), true),
                new Email("Nam", "Come with me", new Date(1654041600L), true),
                new Email("Long", "And you'll be", new Date(1651363200L), false),
                new Email("Tran", "In a world of pure imagination", new Date(1654041599L), true),
                new Email("Nam", "Come with me", new Date(1654041600L), true),
                new Email("Long", "And you'll be", new Date(1651363200L), false),
                new Email("Tran", "In a world of pure imagination", new Date(1654041599L), true),
                new Email("Nam", "Come with me", new Date(1654041600L), true),
                new Email("Long", "And you'll be", new Date(1651363200L), false),
                new Email("Tran", "In a world of pure imagination", new Date(1654041599L), true),
                new Email("Nam", "Come with me", new Date(1654041600L), true),
                new Email("Long", "And you'll be", new Date(1651363200L), false),
                new Email("Tran", "In a world of pure imagination", new Date(1654041599L), true),
                new Email("Nam", "Come with me", new Date(1654041600L), true),
                new Email("Long", "And you'll be", new Date(1651363200L), false),
                new Email("Tran", "In a world of pure imagination", new Date(1654041599L), true)
        );
        EmailAdapter adapter = new EmailAdapter(emails);
        adapter.setOnHighlightButtonClick(pos -> {
            emails.get(pos).setHighlighted(!emails.get(pos).isHighlighted());
            adapter.notifyItemChanged(pos);
        });
        mainView.setAdapter(adapter);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

    }
}