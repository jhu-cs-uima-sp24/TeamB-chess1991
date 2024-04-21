package com.example.myapplication.customize;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.User;
import com.example.myapplication.databinding.ActivityCustomizeMenuBinding;
import com.example.myapplication.main_menu.MainActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CustomizeActivity extends AppCompatActivity {

    private View decorView;
    EditText usernameInput;
    EditText passwordInput;
    DatabaseReference dbref;
    protected ArrayList<User> myUsers;
    SharedPreferences pref;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.example.myapplication.databinding.ActivityCustomizeMenuBinding binding = ActivityCustomizeMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                decorView.setSystemUiVisibility(hideSystemBars());
            }
        });
        user = (User) getIntent().getSerializableExtra("profile");

        Button backButton = findViewById(R.id.customizeBackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("profile", user);
                setResult(0, returnIntent);
                finish();
            }
        });

        Button themeOne = findViewById(R.id.boardThemeOne);
        Button themeTwo = findViewById(R.id.boardThemeTwo);
        Button themeThree = findViewById(R.id.boardThemeThree);

        themeOne.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               user.setTheme(0);
           }
        });

        themeTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setTheme(1);
            }
        });

        themeThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setTheme(2);
            }
        });

        ImageButton playerPieceOne = findViewById(R.id.pieceOne);
        ImageButton playerPieceTwo = findViewById(R.id.pieceTwo);
        ImageButton playerPieceThree = findViewById(R.id.pieceThree);
        ImageButton playerPieceFour = findViewById(R.id.pieceFour);
        ImageButton playerPieceFive = findViewById(R.id.pieceFive);
        ImageButton playerPieceSix = findViewById(R.id.pieceSix);

        playerPieceOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setPiece(1);
            }
        });

        playerPieceTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setPiece(2);
            }
        });

        playerPieceThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setPiece(3);
            }
        });

        playerPieceFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setPiece(4);
            }
        });

        playerPieceFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setPiece(5);
            }
        });

        playerPieceSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setPiece(6);
            }
        });

    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    }

    private int hideSystemBars() {
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
    }
}
