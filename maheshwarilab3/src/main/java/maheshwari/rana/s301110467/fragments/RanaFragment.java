package maheshwari.rana.s301110467.fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import maheshwari.rana.s301110467.R;

/**
 * Name: Maheshwari Rana
 * Student ID: 301110467
 * Section: 002
 */

public class RanaFragment extends Fragment {
    // widgets
    private Button maheshwariPermission, maheshwariStart, maheshwariStop;
    private ImageView maheshwariAnimImage;
    private AnimationDrawable maheshwariFrameAnimation = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rana, container, false);

        maheshwariPermission = view.findViewById(R.id.maheshwariBtnPermission);
        maheshwariPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForPermissions(Manifest.permission.READ_CONTACTS, 5);
            }
        });

        maheshwariStart = view.findViewById(R.id.maheshwariStart);
        maheshwariStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFrameAnimation();
            }
        });

        maheshwariStop = view.findViewById(R.id.maheshwariStop);
        maheshwariStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //stopFrameAnimation();
            }
        });

        maheshwariAnimImage = view.findViewById(R.id.maheshwariAnimImage);
        return view;
    }

    public void checkForPermissions(String permission, int requestCode)
    {
        if (ContextCompat.checkSelfPermission(
                getActivity(), permission) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(getActivity(), new String[] { permission }, requestCode);
        }
        else {
            Toast.makeText(getActivity(), R.string.granted, Toast.LENGTH_SHORT).show();
        }
    }

    public void startFrameAnimation(){
        BitmapDrawable img1 = (BitmapDrawable) getResources().getDrawable(R.drawable.img1);
        BitmapDrawable img2 = (BitmapDrawable) getResources().getDrawable(R.drawable.img2);
        BitmapDrawable img3 = (BitmapDrawable) getResources().getDrawable(R.drawable.img3);
        BitmapDrawable img4 = (BitmapDrawable) getResources().getDrawable(R.drawable.img4);
        BitmapDrawable img5 = (BitmapDrawable) getResources().getDrawable(R.drawable.img5);
        BitmapDrawable img6 = (BitmapDrawable) getResources().getDrawable(R.drawable.img6);
        BitmapDrawable img7 = (BitmapDrawable) getResources().getDrawable(R.drawable.img7);

        int reasonableDuration = 550;
        maheshwariFrameAnimation = new AnimationDrawable();
        maheshwariFrameAnimation.setOneShot(false);
        maheshwariFrameAnimation.addFrame(img1, reasonableDuration);
        maheshwariFrameAnimation.addFrame(img2, reasonableDuration);
        maheshwariFrameAnimation.addFrame(img3, reasonableDuration);
        maheshwariFrameAnimation.addFrame(img4, reasonableDuration);
        maheshwariFrameAnimation.addFrame(img5, reasonableDuration);
        maheshwariFrameAnimation.addFrame(img6, reasonableDuration);
        maheshwariFrameAnimation.addFrame(img7, reasonableDuration);

        maheshwariAnimImage.setBackground(maheshwariFrameAnimation);

        maheshwariFrameAnimation.setVisible(true,true);
        maheshwariFrameAnimation.start();
    }


}
