package net.tuyenoc.practice2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvUsername, tvStudentId, tvName, tvMark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvUsername = findViewById(R.id.tvUsername);
        tvStudentId = findViewById(R.id.tvStudentId);
        tvName = findViewById(R.id.tvName);
        tvMark = findViewById(R.id.tvMark);

        String username = getIntent().getStringExtra("username");
        tvUsername.setText("Hello " + username);

        findViewById(R.id.btListStudent).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startActivityForResult(
                new Intent(MainActivity.this, StudentActivity.class),
                123
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123 && resultCode == Activity.RESULT_OK){
            Student student = (Student) data.getSerializableExtra("student");
            tvStudentId.setText("Student id: " + student.getStudentId());
            tvName.setText("Name: " + student.getName());
            tvMark.setText("Mark: " + student.getMark());
        } else if (requestCode == 123 && resultCode == Activity.RESULT_CANCELED){
            tvStudentId.setText("");
            tvName.setText("");
            tvMark.setText("");
        }
    }
}
