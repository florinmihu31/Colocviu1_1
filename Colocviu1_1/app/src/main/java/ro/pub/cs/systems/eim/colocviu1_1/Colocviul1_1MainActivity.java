package ro.pub.cs.systems.eim.colocviu1_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Colocviul1_1MainActivity extends AppCompatActivity {

    private Button northButton;
    private Button southButton;
    private Button eastButton;
    private Button westButton;
    private Button navigateButton;
    private TextView textView;

    public DirectionButtonListener directionButtonListener = new DirectionButtonListener();

    public int clicksNo;

    private final String CLICKS_NO_KEY = "clicksNo";


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

        textView = (TextView)findViewById(R.id.text_view);

        clicksNo = 0;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CLICKS_NO_KEY, this.clicksNo);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        clicksNo = savedInstanceState.getInt(CLICKS_NO_KEY);
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
}