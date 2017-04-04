package mobappdev.lecture17.reclcyclerview;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mobappdev.lecture17.R;

public class RecyclerViewActivity extends AppCompatActivity
    implements RecyclerViewFragment.ItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_master_detail);

        FragmentManager manager = getSupportFragmentManager();
        if(manager.findFragmentById(R.id.frame_layout_recycler_view) == null) {
            manager.beginTransaction()
                    .add(R.id.frame_layout_recycler_view, new RecyclerViewFragment())
                    .commit();
        }
    }

    @Override
    public void onItemClicked(CharSequence message) {
        FragmentManager manager = getSupportFragmentManager();

        if(findViewById(R.id.frame_layout_recycler_detail_view) == null) {
            Intent intent = DisplayActivity.newIntent(this, message);
            startActivity(intent);
        }
        else {
            manager.beginTransaction()
                    .replace(R.id.frame_layout_recycler_detail_view, DisplayFragment.newInstance(message))
                    .commit();
        }
    }
}
