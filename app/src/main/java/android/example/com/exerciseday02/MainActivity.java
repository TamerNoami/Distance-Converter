package android.example.com.exerciseday02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Object;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    final static double feet = 3.281;
    final static double yard =1.094;
    final static double inch =39.37;
    final  static double mile=0.000621371;
    List<String> source = new ArrayList<>();
    List<String> tagret = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        source.add("meter");
        source.add("centimeters");
        source.add("kilometers");
        source.add("feet");
        source.add("inches");
        source.add("yards");
        source.add("miles");



        final EditText etValue = (EditText) findViewById(R.id.etValue);
        final TextView tvResult = (TextView)findViewById(R.id.tvResult);
        Button btnConvert = (Button) findViewById(R.id.btnConvert);

        final Spinner spinner = findViewById(R.id.my_spinner);
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,source);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        final Spinner spinner1=findViewById(R.id.my_spinner2);


        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double Result=0;
                String value = spinner.getSelectedItem().toString();
               String value2=spinner1.getSelectedItem().toString();
                //Toast.makeText(getApplicationContext(),value+" to " + value2,Toast.LENGTH_LONG).show();
                Result= Double.parseDouble(etValue.getText().toString().trim());


                try {
                    switch (value2) {
                        case "feet":
                            Result = Result * feet;
                            break;
                        case "inches":
                            Result = Result * inch;
                            break;
                        case "yards":
                            Result = Result * yard;
                            break;
                        case "miles":
                            Result = Result * mile;
                            break;
                        case "centimeters":
                            Result = Result * 100;
                            break;
                        case "kilometers":
                            Result = Result / 1000;
                            break;

                    }
                    switch (value) {
                        case "meter":
                            tvResult.setText(String.valueOf(Result));
                            break;
                        case "centimeters":
                            tvResult.setText(String.valueOf((Result / 100)));
                            break;
                        case "kilometers":
                            tvResult.setText(String.valueOf((Result * 1000)));
                            break;
                        case "feet":
                            tvResult.setText(String.valueOf((Result / feet)));
                            break;
                        case "inches":
                            tvResult.setText(String.valueOf((Result / inch)));
                            break;
                        case "yards":
                            tvResult.setText(String.valueOf((Result / yard)));
                            break;
                        case "miles":
                            tvResult.setText(String.valueOf((Result * 1609.34)));
                            break;

                    }
                }
                catch (NumberFormatException e)
                {
                    Toast.makeText(getApplicationContext(),"Please enter a value to convert",Toast.LENGTH_LONG).show();
                }

            }
        });
         spinner.setOnItemSelectedListener(this);

    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        tagret.clear();
        tagret.addAll(source);
        tagret.remove(position);

        // String value = (String) parent.getItemAtPosition(parent.getSelectedItemPosition());
        //Toast.makeText(parent.getContext(),value,Toast.LENGTH_LONG).show();

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,tagret);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner1=findViewById(R.id.my_spinner2);
        spinner1.setAdapter(arrayAdapter1);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        return;
    }
}
