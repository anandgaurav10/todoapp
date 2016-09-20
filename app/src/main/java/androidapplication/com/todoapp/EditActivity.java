package androidapplication.com.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Anand on 19-09-2016.
 */
public class EditActivity extends AppCompatActivity{
    Button buttonCancel,buttonEdit;
    EditText edittext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        edittext = (EditText)findViewById(R.id.edittext);
        buttonCancel = (Button) findViewById(R.id.buttonCancel);
        buttonEdit = (Button)findViewById(R.id.buttonEdit);


        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =getIntent();

                if(intent!=null) {
                    int id = intent.getIntExtra("id",0);


                    String name = edittext.getText().toString();
                    Contact contact = new Contact();
                    contact.setID(id);
                    contact.setName(name);

                    DatabaseHandler databaseHandler = new DatabaseHandler(getApplicationContext());
                    databaseHandler.updateContact(contact);
                }

                finish();
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
