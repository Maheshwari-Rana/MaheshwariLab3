package maheshwari.rana.s301110467.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import maheshwari.rana.s301110467.CanvasView;
import maheshwari.rana.s301110467.R;
import maheshwari.rana.s301110467.SampleActivity;

/**
 * Name: Maheshwari Rana
 * Student ID: 301110467
 * Section: 002
 */

public class MaheshwariFragment extends Fragment {

    // widgets
    private Button maheshwariSet, maheshwariClear,maheshwariBtnCanvas;
    private RadioGroup maheshwariRadioGroup;
    private Spinner maheshwariSpinner;
    private RadioButton maheswariRadioButton;

    private CanvasView customCanvas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maheshwari, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View rootView, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(rootView, savedInstanceState);

        final View view = rootView;
        customCanvas = (CanvasView) view.findViewById(R.id.signature_canvas);

        maheshwariSet = view.findViewById(R.id.maheshwariBtnSet);
        maheshwariClear = view.findViewById(R.id.maheshwariBtnClear);
        maheshwariRadioGroup = view.findViewById(R.id.maheshwariColorRadioGroup);

        maheshwariBtnCanvas = view.findViewById(R.id.maheshwariBtnCanvas);


        maheshwariSpinner = view.findViewById(R.id.maheshwariLineSpinner);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.lineThickness, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        maheshwariSpinner.setAdapter(arrayAdapter);



        maheshwariClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customCanvas.clearPath();
            }
        });

        maheshwariBtnCanvas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SampleActivity.class));
            }
        });

    }
}
