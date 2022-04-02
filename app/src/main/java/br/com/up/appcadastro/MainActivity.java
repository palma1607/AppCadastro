package br.com.up.appcadastro;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.up.appcadastro.adapter.UserListAdapter;
import br.com.up.appcadastro.model.User;

public class MainActivity extends AppCompatActivity {

    private ArrayList<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(
                        MainActivity.this,
                        RegisterActivity.class);

                //startActivity(intent);

                startActivityForResult(intent,100);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        UserListAdapter userListAdapter =
                new UserListAdapter(users,
                        new UserListAdapter.OnUserClickListener() {
                            @Override
                            public void onClick(User user) {

                            }
                        });
        recyclerView.setAdapter(userListAdapter);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100 && resultCode == RESULT_OK){

            User user = (User) data.getSerializableExtra("user");
            users.add(user);
        }

    }
}