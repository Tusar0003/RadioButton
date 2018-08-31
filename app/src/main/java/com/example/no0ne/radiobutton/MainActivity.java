package com.example.no0ne.radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRadioGroup();
    }

    public void setRadioGroup() {

        /* Initialize Radio Group and attach click handler */
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.clearCheck();

        /* Attach CheckedChangeListener to radio group */
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) group.findViewById(checkedId);

                if(radioButton != null && checkedId >= -1) {
                    Toast.makeText(MainActivity.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void onClear(View view) {

        /* Clears all selected radio buttons to default */
        radioGroup.clearCheck();
        Toast.makeText(MainActivity.this, "All Selected Buttons Are Cleared", Toast.LENGTH_SHORT).show();
    }

    public void onSubmit(View view) {

        RadioButton radioButton = (RadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());

        if(radioButton != null) {
            Toast.makeText(MainActivity.this, radioButton.getText() + " Submitted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "No Button Selected", Toast.LENGTH_SHORT).show();
        }
    }
}
