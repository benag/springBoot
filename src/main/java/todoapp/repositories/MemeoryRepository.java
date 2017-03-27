package todoapp.repositories;

import java.util.*;
import todoapp.models.*;


public class MemeoryRepository  {

    private ArrayList<Worker> memory = new ArrayList<>();
    static Integer id = 1;

    public ArrayList<Worker> findAll(){
        return this.memory;
    }
    public Worker findOne(String id){
        for (int i = 0 ;i < memory.size() ; i++){
            Worker w  = memory.get(i);
            if (w.getId() == id){
                return w;
            }

        }
        return null;
    }
    public Worker save(Worker emp){
        this.id++;
        emp.setId(this.id.toString());
        memory.add(emp);
        return emp;
    }
    public void delete(Worker emp){
        String id = emp.getId();
        for (int i = 0 ;i < memory.size() ; i++){
            Worker w  = memory.get(i);
            if (w.getId() == id){
                this.memory.remove(i);
            }
        }
    }
}
