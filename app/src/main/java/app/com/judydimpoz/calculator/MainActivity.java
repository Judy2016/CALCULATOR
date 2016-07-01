package app.com.judydimpoz.calculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private EditText etFirstNumber;
    private EditText etSecondNumber;
    private int operationType;

    int result;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstNumber = (EditText) findViewById(R.id.etnumberone);
        etSecondNumber = (EditText) findViewById(R.id.etnumbertwo);

        tvResult = (TextView) findViewById(R.id.tvresult);
        Button calculate = (Button) findViewById(R.id.btncalculate);

        RadioButton rbAddition = (RadioButton) findViewById(R.id.rbaddition);
        rbAddition.setOnCheckedChangeListener(this);
        RadioButton rbSubtraction = (RadioButton) findViewById(R.id.rbsubtraction);
        rbSubtraction.setOnCheckedChangeListener(this);
        RadioButton rbMultiplication = (RadioButton) findViewById(R.id.rbmultiplication);
        rbMultiplication.setOnCheckedChangeListener(this);



        calculate.setOnClickListener(this);


    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.rbaddition:
                operationType = 1;
                break;
            case R.id.rbsubtraction:
                operationType = 2;
                break;
            case R.id.rbmultiplication:
                operationType = 3;

                break;
        }
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btncalculate) {

            //Get text from EditText
            String strNumberOne = etFirstNumber.getText().toString();
            String strNumberTwo = etSecondNumber.getText().toString();

            //Convert string to integer
            int numberOne = Integer.parseInt(strNumberOne);
            int numberTwo = Integer.parseInt(strNumberTwo);

            if (operationType == 1) {
                //perform addition and display the result
                int result = addition(numberOne, numberTwo);
                tvResult.setText("Answer is:" + result);

            }

            if (operationType == 2) {
                //perform subtraction and display the results
                int result = subtraction(numberOne,  numberTwo);

                tvResult.setText("Answer is:" + result);

            }
            if (operationType == 3) {
                //perform multiplication and display the result
                int result = multiplication(  numberOne, numberTwo);

                tvResult.setText("Answer is:" + result);

            }
        }

    }

    public static int addition(int FirstNumber, int SecondNumber) {
        return FirstNumber + SecondNumber;

    }

    public static int subtraction(int FirstNumber, int SecondNumber) {
        return FirstNumber - SecondNumber;
    }

    public static int multiplication(int FirstNumber, int SecondNumber) {
        return FirstNumber * SecondNumber;

    }
}




