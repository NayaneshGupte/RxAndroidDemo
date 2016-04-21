package com.technosavy.rxandroiddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.technosavy.rxandroiddemo.Utils.IAppConstants;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Choose Different options to perform similar operations using different operators of RxAndroid
 *
 * @author Nayanesh Gupte
 */
public class MainActivity extends AppCompatActivity implements IAppConstants {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }


    @OnClick(R.id.btnOneGo)
    void oneGo() {
        Intent oneGoIntent = new Intent(this, IssueListActivity.class);
        oneGoIntent.putExtra(KEY_REQUEST_TYPE, RETRIEVE_DATA_IN_ONE_GO);
        startActivity(oneGoIntent);
    }

    @OnClick(R.id.btnOneByOne)
    void goChunckbyChunk() {
        Intent chunkIntent = new Intent(this, IssueListActivity.class);
        chunkIntent.putExtra(KEY_REQUEST_TYPE, RETRIEVE_DATA_IN_CHUNCKS);
        startActivity(chunkIntent);
    }

}
