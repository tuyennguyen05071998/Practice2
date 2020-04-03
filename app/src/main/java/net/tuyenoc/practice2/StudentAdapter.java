package net.tuyenoc.practice2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends BaseAdapter{
    private List<Student> students;
    private OnItemSelected onItemSelected;
    public StudentAdapter(OnItemSelected onItemSelected) {
        this.onItemSelected = onItemSelected;
        this.students = new ArrayList<>();
        this.students.add(new Student("DTC01", "Nguyen Van Nam", 4));
        this.students.add(new Student("DTC02", "Nguyen Van Hoang", 5));
        this.students.add(new Student("DTC03", "Nguyen Van Tuan", 6));
        this.students.add(new Student("DTC04", "Nguyen Van Viet", 7));
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        TextView tvStudentId = convertView.findViewById(R.id.tvStudentId);
        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvMark = convertView.findViewById(R.id.tvMark);
        final Student student = students.get(position);
        tvStudentId.setText("Student id: " + student.getStudentId());
        tvName.setText("Name: " + student.getName());
        tvMark.setText("Mark: " + student.getMark());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemSelected.onItemClickListener(student);
            }
        });
        return convertView;
    }


    public interface OnItemSelected{
        void onItemClickListener(Student student);
    }
}
