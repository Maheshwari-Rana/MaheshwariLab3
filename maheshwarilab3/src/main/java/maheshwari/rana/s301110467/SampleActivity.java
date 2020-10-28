package maheshwari.rana.s301110467;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class SampleActivity extends Activity {

    // widgets
    private Button maheshwariSet, maheshwariClear;
    private RadioGroup maheshwariRadioGroup;
    private Spinner maheshwariSpinner;
    private RadioButton maheswariRadioButton;


    // variables
    private CanvasView customCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        customCanvas = (CanvasView) findViewById(R.id.signature_canvas);

        maheshwariSet = findViewById(R.id.maheshwariBtnSet);
        maheshwariClear = findViewById(R.id.maheshwariBtnClear);
        maheshwariRadioGroup = findViewById(R.id.maheshwariColorRadioGroup);

        maheshwariSpinner = findViewById(R.id.maheshwariLineSpinner);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.lineThickness, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        maheshwariSpinner.setAdapter(arrayAdapter);


    }
    public void setProperty(View view){
        float lineWidth = Integer.parseInt(maheshwariSpinner.getSelectedItem().toString());

        int selectedId = maheshwariRadioGroup.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        maheswariRadioButton = (RadioButton) findViewById(selectedId);

        String lineColor = maheswariRadioButton.getText().toString();
        int color;

        if(lineColor.equals("Blue")){
            color = Color.BLUE;
        }else if (lineColor.equals("Red")){
            color = Color.RED;
        }else {
            color = Color.YELLOW;
        }

        customCanvas.setProperties(lineWidth, color);
    }

    public void clearCanvas(View view){
        customCanvas.clearPath();
    }
}