package maheshwari.rana.s301110467.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import maheshwari.rana.s301110467.R;

/**
 * Name: Maheshwari Rana
 * Student ID: 301110467
 * Section: 002
 */

public class S301110467Fragment extends Fragment {
    // widgets
    private TextView maheshwariFirstName, maheshwariLastName;
    private ImageView maheshwariAnimMoon, maheshwariAnimEarth;
    private Button maheshwariBtnStart, maheshwariBtnStop;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_s301110467, container, false);

        maheshwariFirstName = view.findViewById(R.id.maheshwariFirstName);
        RotateAnimation leftRotateFirstName = (RotateAnimation) AnimationUtils.loadAnimation(getActivity(), R.anim.anim_rotate_left);
        maheshwariFirstName.setAnimation(leftRotateFirstName);

        maheshwariLastName = view.findViewById(R.id.maheshwariLastName);
        RotateAnimation rotateLastNameRight = (RotateAnimation) AnimationUtils.loadAnimation(getActivity(), R.anim.anim_rotate_right);
        maheshwariLastName.setAnimation(rotateLastNameRight);

        maheshwariAnimMoon = view.findViewById(R.id.maheshwariAnimMoon);
        final Animation revolveMoon = AnimationUtils.loadAnimation(container.getContext(), R.anim.tween_revolve);
        maheshwariAnimMoon.startAnimation(revolveMoon);


        maheshwariAnimEarth = view.findViewById(R.id.maheshwariAnimEarth);
        final Animation rotateEarth = AnimationUtils.loadAnimation(container.getContext(), R.anim.tween_rotate);
        maheshwariAnimEarth.startAnimation(rotateEarth);

        maheshwariBtnStart = view.findViewById(R.id.maheshwariBtnStart);
        maheshwariBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maheshwariAnimEarth.startAnimation(rotateEarth);
                maheshwariAnimMoon.startAnimation(revolveMoon);
            }
        });

        maheshwariBtnStop = view.findViewById(R.id.maheshwariBtnStop);
        maheshwariBtnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maheshwariAnimEarth.clearAnimation();
                rotateEarth.cancel();

                maheshwariAnimMoon.clearAnimation();
                revolveMoon.cancel();

            }
        });


        return view;
    }
}
