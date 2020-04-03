package net.tuyenoc.practice2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class StudentActivity extends AppCompatActivity implements StudentAdapter.OnItemSelected {
    private ListView listView;
    private StudentAdapter studentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        studentAdapter = new StudentAdapter(this);

        listView = findViewById(R.id.listView);
        listView.setAdapter(studentAdapter);


    }

    @Override
    public void onItemClickListener(Student student) {
        setResult(Activity.RESULT_OK, new Intent().putExtra("student", student));
        finish();
    }

    @Override
    public void onBackPressed() {
        setResult(Activity.RESULT_CANCELED);
        super.onBackPressed();
    }
}
