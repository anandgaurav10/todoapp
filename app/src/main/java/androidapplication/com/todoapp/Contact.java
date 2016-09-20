package androidapplication.com.todoapp;

/**
 * Created by Anand on 18-09-2016.
 */
public class Contact {
    int _id;
    String _name;
    int _status;


    // Empty constructor
    public Contact(){

    }
    // constructor
    public Contact(int id, String name,int status){
        this._id = id;
        this._name = name;
        this._status = status;

    }

    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    public int getStatus(){
        return this._status;
    }

    // setting name
    public void setStatus(int status){
        this._status = status;
    }

}
