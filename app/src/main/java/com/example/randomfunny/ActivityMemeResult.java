package com.example.randomfunny;

import android.app.AppComponentFactory;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.randomfunny.adapters.RetrofitAdapter;
import com.example.randomfunny.networking.MemeResult;
import com.example.randomfunny.networking.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityMemeResult extends AppCompatActivity {
    RecyclerView memeRecycler;

    RecyclerView initialScreen;

    EditText memeOutput;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meme_image);

        memeOutput = findViewById(R.id.editTextTextMultiLine2);

        getMeme();
    }

    private void getMeme() {
        Call<MemeResult> apiCall = RetrofitClient.getInstance().getApis().getMemes();
        apiCall.enqueue(new Callback<MemeResult>() {
            @Override
            public void onResponse(Call<MemeResult> call, Response<MemeResult> response) {
                MemeResult memeResults = response.body();

                Toast.makeText(ActivityMemeResult.this, memeResults.toString(), Toast.LENGTH_SHORT).show();


                memeOutput.setText(memeResults.toString());

            }

            @Override
            public void onFailure(Call<MemeResult> call, Throwable t) {
                Toast.makeText(ActivityMemeResult.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setAdapter(List<MemeResult> memeResults) {
        memeRecycler.setLayoutManager(new LinearLayoutManager(this));
        RetrofitAdapter RetrofitAdapter = new RetrofitAdapter(this, memeResults);
        memeRecycler.setAdapter(RetrofitAdapter);
    }
}

