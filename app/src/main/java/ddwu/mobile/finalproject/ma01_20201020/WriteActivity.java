package ddwu.mobile.finalproject.ma01_20201020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class WriteActivity extends AppCompatActivity {

    final static String TAG = "WriteActivity";

    EditText etTitle;
    EditText etDate;
    EditText etWeather;
    EditText etContent;
    EditText etPlace;

    PostManager postManager;
    Intent intent;

    final int REQ_CODE = 100;
    final int UPDATE_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        etTitle = findViewById(R.id.etTitle);
        etDate = findViewById(R.id.etDate);
        etContent = findViewById(R.id.etContent);
        etPlace = findViewById(R.id.etPlace);

        intent = getIntent();
        etPlace.setText(intent.getStringExtra("name"));
        postManager = new PostManager(this);
    }

    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btnSave:
                boolean result = postManager.addNewPost(
                        new Post(etTitle.getText().toString(), etDate.getText().toString(), etPlace.getText().toString(), etContent.getText().toString()));
                if (result) {    // 정상수행에 따른 처리
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("post", etTitle.getText().toString());
                    setResult(RESULT_OK, resultIntent);
                    finish();
                    break;
                } else {        // 이상에 따른 처리
                    Toast.makeText(this, "새로운 글 추가 실패!", Toast.LENGTH_SHORT).show();
                }
            case R.id.btnCancel:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }
}