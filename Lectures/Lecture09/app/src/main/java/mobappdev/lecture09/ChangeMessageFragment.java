package mobappdev.lecture09;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChangeMessageFragment extends LoggingFragment {

    public interface MessageChangeListener {
        public void messageChanged(CharSequence message);
        public void messageCanceled();
    }

    private MessageChangeListener mMessageChangeListener;

    public ChangeMessageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mMessageChangeListener = (MessageChangeListener)context;

        Log.d(TAG, "onAttach(Context) called with: " + context);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        mMessageChangeListener = (MessageChangeListener)activity;

        Log.d(TAG, "onAttach(ACTIVITY) called with: " + activity);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView() called with: " + mMessageChangeListener);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_change_message, container, false);

        final EditText editTextMessage = (EditText)view.findViewById(R.id.edit_text_message);
        editTextMessage.setText(getArguments().getString(MainActivity.KEY_MESSAGE));
        Button okButton = (Button)view.findViewById(R.id.button_ok);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMessageChangeListener.messageChanged(editTextMessage.getText());
            }
        });

        Button cancelButton = (Button)view.findViewById(R.id.button_cancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMessageChangeListener.messageCanceled();
            }
        });

        return view;
    }
}
