package ro.pub.cs.systems.eim.colocviu1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Colocviul1_1SecondaryActivity extends AppCompatActivity {

    private Button registerButton;
    private Button cancelButton;
    private TextView textView;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviul1_1_secondary);

        registerButton = (Button)findViewById(R.id.button_register);
        registerButton.setOnClickListener(buttonClickListener);

        cancelButton = (Button)findViewById(R.id.button_cancel);
        cancelButton.setOnClickListener(buttonClickListener);

        textView = (TextView)findViewById(R.id.text_view2);

        savedInstanceState = getIntent().getExtras();

        if (savedInstanceState != null) {
            Log.d("TAG", "onCreate()  " + savedInstanceState.toString());
            textView.setText(savedInstanceState.getString(Colocviul1_1MainActivity.DIRECTION_KEY));
        }
    }

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button_register:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.button_cancel:
                    setResult(RESULT_CANCELED, null);
                    break;
            }

            finish();
        }
    }
}