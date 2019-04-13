package com.example.android.myndapplication.activity;


import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.animation.Animation;

import com.example.android.myndapplication.R;
import com.example.android.myndapplication.adapter.SampleSlide;
import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.github.paolorotolo.appintro.model.SliderPage;


public class IntroActivity extends AppIntro {

   // public String title;
    //public String description;
    //public  Image image;
    //public Color backgroundColor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Note here that we DO NOT use setContentView();

        // Add your slide fragments here.


        // AppIntro will automatically generate the dots indicator and buttons.

       // addSlide(SampleSlide.newInstance(R.layout.slide_1));
        addSlide(SampleSlide.newInstance(R.layout.slide_1)); //
        addSlide(SampleSlide.newInstance(R.layout.slide_2)); //
        addSlide(SampleSlide.newInstance(R.layout.slide_3)); //
        addSlide(SampleSlide.newInstance(R.layout.slide_4)); //





        askForPermissions(new String[]{Manifest.permission.CAMERA},4);

        //setFadeAnimation();
        setDepthAnimation();
        setFlowAnimation();

       // addSlide(thirdFragment);
       // addSlide(fourthFragment);

        // Instead of fragments, you can also use our default slide.
        // Just create a `SliderPage` and provide title, description, background and image.
        // AppIntro will do the rest.
//
        //SliderPage sliderPage = new SliderPage();
/*
        sliderPage.setTitle("Rawaj");
        sliderPage.setDescription("welcome to rawaj");
        sliderPage.setImageDrawable(R.drawable.rawaj);
        sliderPage.setBgColor("#42d4f4");
        addSlide(AppIntroFragment.newInstance(sliderPage));
*/
        // OPTIONAL METHODS
        // Override bar/separator color.
       // setBarColor(Color.parseColor("#3F51B5"));
        //setSeparatorColor(Color.parseColor("#2196F3"));

        // Hide Skip/Done button.
        showSkipButton(true);
        setProgressButtonEnabled(true);

        // Turn vibration on and set intensity.
        // NOTE: you will probably need to ask VIBRATE permission in Manifest.
       // setVibrate(true);
        //setVibrateIntensity(30);
    }

    @Override
    public void onSkipPressed(android.support.v4.app.Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        // Do something when users tap on Skip button.
        finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        // Do something when users tap on Done button.
        finish();
        Intent intent= new Intent(this,MainActivity.class);
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }
}