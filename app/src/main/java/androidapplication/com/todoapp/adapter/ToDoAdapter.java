package androidapplication.com.todoapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidapplication.com.todoapp.CheckActivity;
import androidapplication.com.todoapp.Contact;
import androidapplication.com.todoapp.DatabaseHandler;
import androidapplication.com.todoapp.EditActivity;
import androidapplication.com.todoapp.R;
import androidapplication.com.todoapp.model.ToDo;

/**
 * Created by Anand on 15-09-2016.
 */
public class ToDoAdapter extends BaseAdapter{
    private Context context;
    private List<Contact> list = new ArrayList<>();

    public ToDoAdapter(Context context){
        this.context = context;
    }

    public void updateList(List<Contact> toDo) {
        this.list = toDo;
        notifyDataSetChanged();
    }


    public void clearList(){
        this.list.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_todo, parent, false);
            holder = new ViewHolder();
            holder.textViewTitle = (TextView)convertView.findViewById(R.id.textViewTitle);
            holder.checkBox = (CheckBox)convertView.findViewById(R.id.checkbox);
            convertView.setTag(holder);

        }else {
            holder=(ViewHolder) convertView.getTag();
        }

        holder.textViewTitle.setText("Id: "+list.get(position).getID()+" ,Name: " +list.get(position).getName());


        if(list.get(position).getStatus()==1){
            holder.checkBox.setChecked(true);
        }else {
            holder.checkBox.setChecked(false);
        }

        // this sets onChekcedChangeeListerer on all button on the basis of position
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                DatabaseHandler databaseHandler = new DatabaseHandler(context);
                if(isChecked){
                    list.get(position).setStatus(1);
                    databaseHandler.updateContact(list.get(position));
                }else {
                    list.get(position).setStatus(0);
                    databaseHandler.updateContact(list.get(position));
                }
            }
        });

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CheckActivity.class);
                intent.putExtra("id",list.get(position).getID());
                intent.putExtra("name",list.get(position).getName());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });






        return convertView;
    }

    static class ViewHolder {
        TextView textViewTitle;
        CheckBox checkBox;

    }
}
