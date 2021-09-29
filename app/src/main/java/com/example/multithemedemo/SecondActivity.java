package com.example.multithemedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class SecondActivity extends BaseActivity implements ThemeColorsAdapter.OnItemClick {
    private RecyclerView rvColors;
    private ArrayList<ColorModel> colorList;
    private ThemeColorsAdapter colorsAdapter;
    int selectedTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        selectedTheme = Utility.getTheme(this);
        rvColors = findViewById(R.id.rvColors);
        getColors();
    }

    private void getColors() {
        colorList = new ArrayList();
        colorList.add(new ColorModel(ContextCompat.getColor(this, R.color.primaryColor_default)));
        colorList.add(new ColorModel(ContextCompat.getColor(this, R.color.primaryColor_orange)));
        colorList.add(new ColorModel(ContextCompat.getColor(this, R.color.primaryColor_brown)));
        colorList.add(new ColorModel(ContextCompat.getColor(this, R.color.primaryColor_yellow)));
        colorList.add(new ColorModel(ContextCompat.getColor(this, R.color.primaryColor_green)));
        colorList.add(new ColorModel(ContextCompat.getColor(this, R.color.primaryColor_blue)));
        colorList.add(new ColorModel(ContextCompat.getColor(this, R.color.primaryColor_purple)));

        colorList.get(selectedTheme).setSelected(true);

        setData();
    }

    private void setData() {
        colorsAdapter = new ThemeColorsAdapter(colorList, this, this);
        rvColors.setAdapter(colorsAdapter);
    }

    @Override
    public void onItemClick(int pos) {
        Utility.setTheme(SecondActivity.this, pos);
        onResume();
    }

}