package androidapplication.com.todoapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Anand on 18-09-2016.
 */
public class EditTextActivity extends AppCompatActivity {
    EditText editText;
    Button btnCancel,btnSave;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        editText = (EditText)findViewById(R.id.editText);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnSave = (Button)findViewById(R.id.btnSave);

        String savedData = sharedPreferences.getString(Appconstant.TEXT,"");
        if (savedData!=null&&!savedData.isEmpty()){
            editText.setText(savedData);
            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String savedData = editText.getText().toString();

                    sharedPreferences.edit().putString(Appconstant.TEXT,savedData).apply();
                    EventBus.getDefault().post(new UpdateEvent());
                    finish();
                }
            });


        }
        else {

            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String savedData = editText.getText().toString();
                    sharedPreferences.edit().putString(Appconstant.TEXT,savedData).apply();
                    EventBus.getDefault().post(new UpdateEvent());
                    finish();
                }
            });
        }
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    }

