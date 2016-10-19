package com.example.administrator.myapp;

import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.myapp.adapter.FoodAdapter;
import com.example.administrator.myapp.model.FoodModel;
import com.example.administrator.myapp.view.NXHooldeView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FoodAdapter.FoodActionCallback{

    public List<FoodModel> factoryFoods() {
        List<FoodModel> datas = new ArrayList<>();
        datas.add(new FoodModel("短头发11", R.drawable.imag1, "两侧和后部头发较"));
        datas.add(new FoodModel("短头发11", R.drawable.imag2, "两侧和后部头发较"));
        datas.add(new FoodModel("短头发11", R.drawable.imag3, "两侧和后部头发较"));
        datas.add(new FoodModel("短头发11", R.drawable.imag4, "两侧和后部头发较"));
        datas.add(new FoodModel("短头发11", R.drawable.imag5, "两侧和后部头发较"));
        datas.add(new FoodModel("短头发11", R.drawable.imag6, "两侧和后部头发较"));
        datas.add(new FoodModel("短头发11", R.drawable.imag7, "两侧和后部头发较"));
        datas.add(new FoodModel("短头发11", R.drawable.imag8, "两侧和后部头发较"));
        datas.add(new FoodModel("短头发11", R.drawable.imag9, "两侧和后部头发较"));
        datas.add(new FoodModel("短头发11", R.drawable.imag10, "两侧和后部头发较"));
        datas.add(new FoodModel("短头发11", R.drawable.imag11, "两侧和后部头发较"));
        datas.add(new FoodModel("短头发11", R.drawable.imag12, "两侧和后部头发较"));
        return datas;
    }
    ListView lv_main;
    TextView tv_good_fitting_num;
    TextView tv_goods_fitt_all_price;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_main = (ListView) findViewById(R.id.lv_main);
        tv_good_fitting_num = (TextView) findViewById(R.id.tv_good_fitting_num);
        tv_goods_fitt_all_price = (TextView) findViewById(R.id.tv_goods_fitt_all_price);

        lv_main.setAdapter(new FoodAdapter(this, factoryFoods(), this));
    }

    int count = 0;
    public void addAction(View view) {
        NXHooldeView nxHooldeView = new NXHooldeView(this);
        int position[] = new int[2];
        view.getLocationInWindow(position);
        nxHooldeView.setStartPosition(new Point(position[0], position[1]));
        ViewGroup rootView = (ViewGroup) this.getWindow().getDecorView();
        rootView.addView(nxHooldeView);
        int endPosition[] = new int[2];
        tv_good_fitting_num.getLocationInWindow(endPosition);
        nxHooldeView.setEndPosition(new Point(endPosition[0], endPosition[1]));
        nxHooldeView.setnXanimatioListener(new NXHooldeView.NXanimatioListener() {
            @Override
            public void startChangeProductNum() {
                count = count + 1;
                tv_good_fitting_num.setText("" + count);
                tv_goods_fitt_all_price.setText("￥"+(4+count*10)+"元");
            }
        });
        nxHooldeView.startBeizerAnimation();
    }
}
