package androidapplication.com.todoapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import androidapplication.com.todoapp.Contact;
import androidapplication.com.todoapp.DatabaseHandler;
import androidapplication.com.todoapp.EditTextActivity;
import androidapplication.com.todoapp.R;
import androidapplication.com.todoapp.adapter.ToDoAdapter;
import androidapplication.com.todoapp.model.ToDo;

/**
 * Created by Anand on 15-09-2016.
 */
public class ToDoFragment extends Fragment {

    ListView listView;
    FloatingActionButton buttonAddToDO;
    Context context;
    ToDoAdapter toDoAdapter;
    List<ToDo> toDOList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_todo, container, false);


    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        context = getActivity().getApplicationContext();
        listView = (ListView) view.findViewById(R.id.listView);
        buttonAddToDO = (FloatingActionButton) view.findViewById(R.id.buttonAddToDO);
        toDoAdapter = new ToDoAdapter(context);

        listView.setAdapter(toDoAdapter);





        buttonAddToDO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(),EditTextActivity.class);
                startActivity(intent);

            }
        });
        updateData();
    }



    public void updateData(){


        DatabaseHandler db = new DatabaseHandler(getActivity().getApplicationContext());

        List<Contact> contacts = db.getAllContacts();

            toDoAdapter.updateList(contacts);
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.mainmenu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle item selection
        switch (item.getItemId()) {
            case R.id.clear:
//yahan clear kaise hoga
                DatabaseHandler db = new DatabaseHandler(getActivity().getApplicationContext());
                //db.deleteAllContact(); ek method banna lo delete all karke databaseHanlder net pe dekh lena
                // DELETE * FROM CONTACT : sql query hai samjha
                db.deleteAllContacts();
                toDoAdapter.clearList();

                break;
            case R.id.refresh:

                break;
        }
        return true;
    }
}
