package com.example.zeeshan.classparticipationchecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    List<String> student_list = new ArrayList<>();
    int count1= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loadBtn = findViewById(R.id.loadStudentId);
        final TextView tv_count = findViewById(R.id.count);
        final ListView lv_student = findViewById(R.id.student_list_id);


        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                readFile();
                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,student_list);
                lv_student.setAdapter(adapter);

            }
        });

        lv_student.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = parent.getItemAtPosition(position).toString();
                count1++;
                if (count1==8) {
                    count1 = 0;
                }
                student_list.get(position);
                student_list.remove(position);

                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,student_list);
                lv_student.setAdapter(adapter);
                tv_count.setText(count1+"");


            }
        });


        //readFile();









    }
    private void readFile(){
        InputStream is = getResources().openRawResource(R.raw.students);

        Scanner scanner = new Scanner(is);
        while (scanner.hasNext()){
            //Log.e("TAG",scanner.nextLine().toString());
            student_list.add(scanner.nextLine().toString());
            //Log.e("TAG",students_list)

        }



        scanner.close();

    }
}
