package com.projects.kevinbarassa.drtonny;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;
import com.heinrichreimersoftware.materialintro.slide.Slide;

/**
 * Created by Kevin Barassa on 30-Mar-17.
 */

public class MainIntroActivity extends IntroActivity {
    /**
     * Etra pref for Material intro
     * Selective only important for now
     */

    public static final String EXTRA_FULLSCREEN = "com.projects.kevinbarassa.drtonny.EXTRA_FULLSCREEN";
    public static final String EXTRA_SCROLLABLE = "com.projects.kevinbarassa.drtonny.EXTRA_SCROLLABLE";
    public static final String EXTRA_CUSTOM_FRAGMENTS = "com.projects.kevinbarassa.drtonny.EXTRA_CUSTOM_FRAGMENTS";
    public static final String EXTRA_PERMISSIONS = "com.projects.kevinbarassa.drtonny.EXTRA_PERMISSIONS";

    @Override
    protected void onCreate(Bundle savedInstanceState){

         /* Enable/disable fullscreen */
        setFullscreen(true);

        super.onCreate(savedInstanceState);
        //Extra settings for Material intro
        Intent intent = getIntent();
        boolean fullscreen = intent.getBooleanExtra(EXTRA_FULLSCREEN, false);
        boolean scrollable = intent.getBooleanExtra(EXTRA_SCROLLABLE, false);
        boolean customFragments = intent.getBooleanExtra(EXTRA_CUSTOM_FRAGMENTS, true);
        boolean permissions = intent.getBooleanExtra(EXTRA_PERMISSIONS, true);


        setFullscreen(fullscreen);

        /* Enable/disable skip button */
        //setSkipEnabled(true);

        /* Enable/disable finish button */
        //setFinishEnabled(true);

        setButtonBackVisible(false);
        setButtonNextVisible(false);
        //setButtonCtaVisible(true);

        /**
         * Standard slide (like Google's intros)
         */

        addSlide(new SimpleSlide.Builder()
                .title(R.string.app_name)
                .description(R.string.about)
                .image(R.drawable.ic_person_white_24dp)
                .background(R.color.colorPrimary)
                .backgroundDark(R.color.colorPrimaryDark)
                .build());


        /**
         * Permissions Slide
         */
//        final Slide permissionsSlide;
//        if (permissions) {
//            permissionsSlide = new SimpleSlide.Builder()
//                    .title(R.string.title_permissions)
//                    .description(R.string.description_permissions)
//                    .background(R.color.color_permissions)
//                    .backgroundDark(R.color.color_dark_permissions)
//                    .scrollable(scrollable)
//                    .permissions(new String[]{Manifest.permission.CAMERA,
//                            Manifest.permission.WRITE_EXTERNAL_STORAGE})
//                    .build();
//            addSlide(permissionsSlide);
//        } else {
//            permissionsSlide = null;
//        }



        addSlide(new SimpleSlide.Builder()
                .title(R.string.app_name)
                .description(R.string.about)
                .image(R.drawable.ic_person_white_24dp)
                .background(R.color.colorPrimary)
                .backgroundDark(R.color.colorPrimaryDark)
                .scrollable(scrollable)
                .buttonCtaLabel("Lets Engage")
                .buttonCtaClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast toast = Toast.makeText(MainIntroActivity.this, "You have clicked me", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();

                        nextSlide();
                    }
                })
                .build());

    }
}