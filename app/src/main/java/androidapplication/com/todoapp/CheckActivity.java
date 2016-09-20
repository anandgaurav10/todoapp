package androidapplication.com.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Anand on 19-09-2016.
 */
public class CheckActivity extends AppCompatActivity {

    FloatingActionButton buttonEdit;
    TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        textView = (TextView)findViewById(R.id.textView);
        buttonEdit = (FloatingActionButton)findViewById(R.id.buttonEdit);


        Intent intent =getIntent();

        if(intent!=null)

        {
            final int id = intent.getIntExtra("id", 0);
            String name = intent.getStringExtra("name");
            textView.setText("Id:"+id+"Name:"+name);

            buttonEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(CheckActivity.this,EditActivity.class);
                    intent.putExtra("id",id);
                    startActivity(intent);
                    finish();
                }

            });
        }

    }
}
