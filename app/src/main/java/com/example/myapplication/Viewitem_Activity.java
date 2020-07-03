package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.FragmentActivity;

import com.example.myapplication.dummy.DummyContent;

public class Viewitem_Activity extends FragmentActivity implements ItemFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewitem_);
        //1.获取framgmentMananger 2.获取transaction
        //3.用rep;ace方法,替换原来占位置用的FragmentLayout控件
        //4.commit
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout,ItemFragment.newInstance(1))
                .commit();
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    public void addItem(View view) {
        Intent intent = new Intent(this,AdditemActivity.class);
        startActivity(intent);
    }
}
