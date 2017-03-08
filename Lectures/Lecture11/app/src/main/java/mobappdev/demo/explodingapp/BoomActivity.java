package mobappdev.demo.explodingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class BoomActivity extends AppCompatActivity {

    private static final String TAG = "BoomActivity";

    private TextView mBoomTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boom);

        //mBoomView = (TextView)findViewById(R.id.boom_view);

        Log.d(TAG, "boom view: " + mBoomTextView);
        Log.d(TAG, "R.string.boom: " + R.string.boom);

        mBoomTextView.setText(R.string.boom);
    }
}
