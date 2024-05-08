package com.example.imagesliderdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ActionTypes;
import com.denzcoskun.imageslider.constants.AnimationTypes;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemChangeListener;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.interfaces.TouchListener;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageSlider imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageSlider = findViewById(R.id.imageSlider);

        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel("https://cdn.dummyjson.com/product-images/1/2.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://cdn.dummyjson.com/product-images/1/3.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://cdn.dummyjson.com/product-images/1/4.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://cdn.dummyjson.com/product-images/4/2.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://cdn.dummyjson.com/product-images/4/3.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://cdn.dummyjson.com/product-images/4/4.jpg", ScaleTypes.FIT));


//        slideModels.add(new SlideModel("https://cdn.dummyjson.com/product-images/1/1.jpg","image 1", ScaleTypes.FIT));
//        slideModels.add(new SlideModel("https://cdn.dummyjson.com/product-images/1/2.jpg","image 2", ScaleTypes.FIT));
//        slideModels.add(new SlideModel("https://cdn.dummyjson.com/product-images/1/3.jpg","image 3", ScaleTypes.FIT));
//        slideModels.add(new SlideModel("https://cdn.dummyjson.com/product-images/1/4.jpg","image 4", ScaleTypes.FIT));

        imageSlider.setImageList(slideModels);

//        imageSlider.setSlideAnimation(AnimationTypes.BACKGROUND_TO_FOREGROUND);

        imageSlider.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemSelected(int i) {
                Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void doubleClick(int i) {

            }
        });

//        imageSlider.setItemChangeListener(new ItemChangeListener() {
//            @Override
//            public void onItemChanged(int i) {
//                Toast.makeText(MainActivity.this, "Position: "+i, Toast.LENGTH_SHORT).show();
//            }
//        });

        imageSlider.setTouchListener(new TouchListener() {
            @Override
            public void onTouched(@NonNull ActionTypes actionTypes, int i) {
                if (actionTypes == ActionTypes.DOWN){
                    imageSlider.stopSliding();
                } else if (actionTypes == ActionTypes.UP ) {
                    imageSlider.startSliding(2000);
                }
            }
        });

    }
}
