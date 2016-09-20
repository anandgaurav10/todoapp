package androidapplication.com.todoapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import androidapplication.com.todoapp.fragment.ToDoFragment;

/**
 * Created by Anand on 18-09-2016.
 */
public class EditTextActivity extends AppCompatActivity {
    EditText editText;
    Button btnCancel,btnSave;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext);



        editText = (EditText)findViewById(R.id.editText);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnSave = (Button)findViewById(R.id.btnSave);


        btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name = editText.getText().toString();
                    Contact contact = new Contact();
                    contact.setName(name);


                    DatabaseHandler databaseHandler = new DatabaseHandler(getApplicationContext());
                    databaseHandler.addContact(contact);

                    finish();
                }
            });




        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    }

