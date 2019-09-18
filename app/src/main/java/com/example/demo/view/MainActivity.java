package com.example.demo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.demo.R;
import com.example.demo.model.user.User;
import com.example.demo.presenter.Presenter;

import java.util.List;

//Create a sample application to make a service call for the below api using Retrofit or Volley or Basic HttpUrlConnection by implementing it in the MVP, MVVM, or any other design pattern. (https://jsonplaceholder.typicode.com/posts).
  //      from Osiris Gadson (internal) to Everyone:    3:44  PM
    //    And display these items in a list

public class MainActivity extends AppCompatActivity implements MainActivityContract {
    RecyclerView recyclerView;
    CustomAdapter adapter;
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new Presenter();
        initUi();
        presenter.bindView(this);
        presenter.initNetworkCall();
    }


    @Override
    public void getListUsers(List<User> dataSet) {
        adapter.setDataSet(dataSet);

    }

    @Override
    public void initUi() {
        recyclerView = findViewById(R.id.rvMainActivity);
        recyclerView.setLayoutManager(new
                LinearLayoutManager(this));
        adapter = new CustomAdapter();
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        presenter.unBind();
    }
}
