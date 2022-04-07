package ro.pub.cs.systems.eim.colocviu1_1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Colocviul1_1MainActivity extends AppCompatActivity {

    private Button northButton;
    private Button southButton;
    private Button eastButton;
    private Button westButton;
    private Button navigateButton;
    private TextView textView;

    public DirectionButtonListener directionButtonListener = new DirectionButtonListener();
    public NavigateButtonListener navigateButtonListener = new NavigateButtonListener();

    private int clicksNo = 0;
    private int clicksNoSecondaryActivity = 0;
    private String direction = "";

    private final String CLICKS_NO_KEY = "clicksNo";
    public static final String DIRECTION_KEY = "direction";
    private final int REQUEST_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviul1_1_main);

        northButton = (Button)findViewById(R.id.north_button);
        northButton.setOnClickListener(directionButtonListener);

        southButton = (Button)findViewById(R.id.south_button);
        southButton.setOnClickListener(directionButtonListener);

        eastButton = (Button)findViewById(R.id.east_button);
        eastButton.setOnClickListener(directionButtonListener);

        westButton = (Button)findViewById(R.id.west_button);
        westButton.setOnClickListener(directionButtonListener);

        navigateButton = (Button)findViewById(R.id.navigate_button);
        navigateButton.setOnClickListener(navigateButtonListener);

        textView = (TextView)findViewById(R.id.text_view);

        if (savedInstanceState != null) {
            clicksNo = savedInstanceState.getInt(CLICKS_NO_KEY);
        }

        Log.d("TAG", "" + clicksNo);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(CLICKS_NO_KEY, this.clicksNo);
        Log.d("TAG", "onSaveInstanceState: "  + clicksNo);

        outState.putString(DIRECTION_KEY, direction);
        Log.d("TAG", "onSaveInstanceState: " + direction);

        outState.putInt(CLICKS_NO_KEY, this.clicksNoSecondaryActivity);
        Log.d("TAG", "onSaveInstanceState: "  + clicksNoSecondaryActivity);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        clicksNo = savedInstanceState.getInt(CLICKS_NO_KEY);
        Log.d("TAG", "onRestoreInstanceState: " + clicksNo);
    }

    private class DirectionButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.north_button:
                    textView.setText(textView.getText() + "North, ");
                    break;
                case R.id.south_button:
                    textView.setText(textView.getText() + "South, ");
                    break;
                case R.id.east_button:
                    textView.setText(textView.getText() + "East, ");
                    break;
                case R.id.west_button:
                    textView.setText(textView.getText() + "West, ");
                    break;
            }

            clicksNo++;
        }
    }

    private class NavigateButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            direction = textView.getText().toString();
            clicksNoSecondaryActivity = clicksNo;

            textView.setText("");
            clicksNo = 0;

            Intent intent = new Intent(Colocviul1_1MainActivity.this, Colocviul1_1SecondaryActivity.class);
            intent.putExtra(DIRECTION_KEY, direction);
            startActivityForResult(intent, REQUEST_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            Toast.makeText(this, "Result code: " + resultCode, Toast.LENGTH_SHORT).show();
        }
    }
}