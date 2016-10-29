package vn.techkids.hwdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.techkids.hwdatabase.adapters.CategoryAdapter;
import vn.techkids.hwdatabase.fragments.CreateFragment;
import vn.techkids.hwdatabase.fragments.EditFragment;
import vn.techkids.hwdatabase.listeners.ItemClickListener;
import vn.techkids.hwdatabase.managers.DBHepler;
import vn.techkids.hwdatabase.models.ListModel;
import vn.techkids.hwdatabase.models.NoteModel;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getName();
    private List<NoteModel> noteList;
    public static int pos;
    private CategoryAdapter adapter;
    @BindView(R.id.btn_add)
    Button btn_add;

    @BindView(R.id.rv)
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DBHepler.getInstance().init(this);
        reset();
        setupUI();
        notifiDataSetchange();
        addListeners();
        onResume();
    }

    private void addListeners() {
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(new CreateFragment(), true);
            }
        });

        rv.addOnItemTouchListener(new ItemClickListener(this, rv, new ItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                pos = position;
                changeFragment(new EditFragment(), true);
            }

            @Override
            public void onLongItemClick(View view, int position) {
                DBHepler.getInstance().delete(noteList.get(position));
                noteList = DBHepler.getInstance().selectAllNote();
                ListModel.list.clear();
                for (NoteModel tempNote : noteList) {
                    ListModel.list.add(new ListModel(tempNote.getTitle()));
                }
                adapter.notifyDataSetChanged();

                Log.d(TAG, "Long Click");
            }
        }));
    }

    private void changeFragment(Fragment fragment, Boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_main, fragment);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }


    private void setupUI() {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        rv.setLayoutManager(staggeredGridLayoutManager);
        adapter = new CategoryAdapter();
        rv.setAdapter(adapter);
        ListModel.list.clear();
        noteList = DBHepler.getInstance().selectAllNote();
        for (NoteModel tempNote : noteList) {
            ListModel.list.add(new ListModel(tempNote.getTitle()));
        }
        reset();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter.notifyDataSetChanged();
            }
        });

    }

    public void notifiDataSetchange() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter.notifyDataSetChanged();
            }
        });
    }

    public NoteModel getNote(){
        return noteList.get(pos);
    }

    public void reset(){
        noteList = DBHepler.getInstance().selectAllNote();
    }

    @Override
    protected void onResume() {
        super.onResume();
        reset();
        notifiDataSetchange();
    }
}
