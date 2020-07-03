package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class AdditemActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText3;
    EditText editText4;
    EditText editText5;
    EditText editText6;
    EditText editText7;
    EditText editText8;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);
        initView();
    }
    private void initView(){
        editText3 = (EditText)findViewById(R.id.editText3);
        editText4 = (EditText)findViewById(R.id.editText4);
        editText5 = (EditText)findViewById(R.id.editText5);
        editText6 = (EditText)findViewById(R.id.editText6);
        editText7 = (EditText)findViewById(R.id.editText7);
        editText8 = (EditText)findViewById(R.id.editText8);
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button3:
//                1.获取数据
              String name = editText3.getText().toString();
              String desc = editText4.getText().toString();
                String remark = editText5.getText().toString();
                String price = editText6.getText().toString();
                String kindid = editText7.getText().toString();
                String avail = editText8.getText().toString();
//                2.打包数据
                Map<String,String>map = new HashMap<>();
                map.put("itemName",name);
                map.put("itemDesc",desc);
                map.put("itemRemark",remark);
                map.put("initPrice",price);
                map.put("kindId",kindid);
                map.put("avail",avail);
//                3.发送数据
                try {
                    String result = OkHttpUtil.postRequest("http://172.18.85.254:8080/auction/api/items",map);
                    Toast.makeText(this,result,Toast.LENGTH_LONG).show();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                break;
        }
    }
}
