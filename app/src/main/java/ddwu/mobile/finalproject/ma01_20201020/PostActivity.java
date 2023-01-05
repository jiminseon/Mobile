package ddwu.mobile.finalproject.ma01_20201020;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PostActivity extends AppCompatActivity {

    final int REQ_CODE = 100;

   MyAdapter myAdapter;
    ListView listView;
    ArrayList<Post> postList;
    PostManager postManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        listView = (ListView) findViewById(R.id.listView);
        postList = new ArrayList<Post>();
        postManager = new PostManager(this);
        myAdapter = new MyAdapter(this, R.layout.custom_adapter_view, postList);
        listView.setAdapter(myAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int pos = position;
                AlertDialog.Builder builder = new AlertDialog.Builder(PostActivity.this);
                builder.setTitle("일기 삭제")
                        .setMessage(postList.get(pos).getTitle() + " 일기를 삭제하시겠습니까?")
                        .setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (postManager.removePost(postList.get(pos).get_id())) {
                                    Toast.makeText(PostActivity.this, "삭제 완료", Toast.LENGTH_SHORT).show();
                                    postList.clear();
                                    postList.addAll(postManager.getAllPost());
                                    myAdapter.notifyDataSetChanged();
                                }
                                else {
                                    Toast.makeText(PostActivity.this, "삭제 완료", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("취소", null)
                        .setCancelable(false)
                        .show();
                return true;
            }
        });

    }


    protected void onResume() {
        super.onResume();
        postList.clear();
        postList.addAll(postManager.getAllPost());
        myAdapter.notifyDataSetChanged();

    }




}