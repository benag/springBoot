package todoapp.classes;

import java.util.Date;
import java.text.*;

/**
 * Created by ben on 24/03/17.
 */
public class Task {

    public Task(String text, String dateStr){
        try{
            this.taskText = text;
            DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            Date dueDate = (Date)formatter.parse(dateStr);
            this.dueDate = dueDate;
        }catch(java.text.ParseException e){
            System.out.println(e);
        }

    }
    public Task(Task t){
        this.taskText = t.taskText;

        this.dueDate = t.dueDate;
    }
    private String taskText = "";

    private Date dueDate;

    private Date assignDate = new Date();

    public String getTaskText() {return this.taskText;}

    public void setTaskText(String text) { this.taskText= text;}

    public Date getDueDate() { return this.dueDate;}

    public Date getAssignDate() { return this.assignDate;}

    public void setDueDate(Date date) { this.dueDate = date;}

    public void setAssignDate(Date date) { this.assignDate = date;}

    @Override
    public String toString() {
        return String.format(
                "Task[taskText='%s', dueDate='%s', assignDate ='%s']",
                taskText, dueDate.toString(), assignDate.toString());
    }

}
