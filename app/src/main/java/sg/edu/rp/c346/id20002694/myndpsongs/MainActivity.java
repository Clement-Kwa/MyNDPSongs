package sg.edu.rp.c346.id20002694.myndpsongs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etTitle, etSingers, etYear;
    RadioGroup radioGrp;
    Button btnInsert, btnShow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle  = findViewById(R.id.etTitle);
        etSingers= findViewById(R.id.etSingers);
        etYear= findViewById(R.id.etYear);
        radioGrp = findViewById(R.id.radioGrp);
        btnInsert = findViewById(R.id.btnInsert);
        btnShow= findViewById(R.id.btnShow);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(sg.edu.rp.c346.id20002694.myndpsongs.MainActivity.this,
                        sg.edu.rp.c346.id20002694.myndpsongs.SongList.class);

                startActivity(i);

            }
        });


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String singer = etSingers.getText().toString();
                int year = 0;

                if(!etYear.getText().toString().isEmpty()){
                     year = Integer.parseInt(etYear.getText().toString());
                }


                int stars = 1 ;

                if(radioGrp.getCheckedRadioButtonId() == R.id.rb1){
                    stars=1;
                }
                else if(radioGrp.getCheckedRadioButtonId() == R.id.rb2){
                    stars=2;
                }
                else if(radioGrp.getCheckedRadioButtonId() == R.id.rb3){
                    stars=3;
                }
                else if(radioGrp.getCheckedRadioButtonId() == R.id.rb4){
                    stars=4;
                }
                else if(radioGrp.getCheckedRadioButtonId() == R.id.rb5){
                    stars=5;
                }

                sg.edu.rp.c346.id20002694.myndpsongs.DBHelper dbh = new sg.edu.rp.c346.id20002694.myndpsongs.DBHelper(sg.edu.rp.c346.id20002694.myndpsongs.MainActivity.this);
                 dbh.insertSong( title,  singer,  year,  stars  );


            }
        });



    }
}