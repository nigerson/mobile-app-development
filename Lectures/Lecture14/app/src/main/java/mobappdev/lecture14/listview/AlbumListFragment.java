package mobappdev.lecture14.listview;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import mobappdev.lecture14.MainActivity;
import mobappdev.lecture14.R;
import mobappdev.lecture14.dialog.AlbumDialog;
import mobappdev.lecture14.model.Album;
import mobappdev.lecture14.model.Collection;
import mobappdev.lecture14.recycler.AlbumRecyclerActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlbumListFragment extends ListFragment {

    private List<Album> mAlbums;

    public AlbumListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        mAlbums = Collection.get().getAlbums();

        AlbumArrayAdapter adapter = new AlbumArrayAdapter(getContext(), mAlbums);
        setListAdapter(adapter);

        // this causes an illegal state exception: content view not yet created
        //getListView().setOnItemClickListener(new ItemClickListener());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        // this causes an illegal state exception: content view not yet created
        //getListView().setOnItemClickListener(new ItemClickListener());
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_album_list_fragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean handled;
        switch(item.getItemId()) {
            case R.id.menu_main_activity:
                restartActivity(MainActivity.class);
                handled = true;
                break;
            case R.id.menu_recycler_view:
                restartActivity(AlbumRecyclerActivity.class);
                handled = true;
            default:
                handled = super.onOptionsItemSelected(item);
                break;
        }

        return handled;
    }

    @Override
    public void onStart() {
        super.onStart();
        // this seems to work
        //getListView().setOnItemClickListener(new ItemClickListener());
    }

    @Override
    public void onResume() {
        super.onResume();
        // this also seems to work
        //getListView().setOnItemClickListener(new ItemClickListener());
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        FragmentManager manager = getFragmentManager();
        AlbumDialog dialog = AlbumDialog.newInstance(mAlbums.get(position));
        dialog.show(manager, "Album Dialog");
    }

    private class ItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(getContext(), "Item Clicked!", Toast.LENGTH_SHORT).show();
        }
    }

    private void restartActivity(Class activityClass) {
        Intent intent = new Intent(getActivity(), activityClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }
}
