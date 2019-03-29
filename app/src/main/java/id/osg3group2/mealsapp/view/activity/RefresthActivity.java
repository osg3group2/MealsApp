package id.osg3group2.mealsapp.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import id.osg3group2.mealsapp.R;
import id.osg3group2.mealsapp.helpers.CheckNetworkConnectionHelper;
import id.osg3group2.mealsapp.listener.OnNetworkConnectionChangeListener;

public class RefresthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresth);


        final Button retry =(Button)findViewById(R.id.retry);
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        CheckNetworkConnectionHelper checkNetworkConnectionHelper = CheckNetworkConnectionHelper.getInstance();
        checkNetworkConnectionHelper.onNetworkConnectionChange(this,
                new OnNetworkConnectionChangeListener() {
                    @Override
                    public void onConnected() {
                        retry.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onDisconnected() {

                    }
                });
    }
}
