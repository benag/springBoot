package todoapp.models;

import java.util.Date;

public class Report {

    private String text;

    private Date createdAt = new Date();

     public Report() {}

    public Report(String text){
        this.text = text;
    }


    public String getText() { return this.text;}

    public void setText(String text) { this.text = text;}

    public Date getCreatedAt() { return this.createdAt;}

    public void setCreatedAt(Date d) { this.createdAt = d;}

    @Override
    public String toString() {
        return String.format(
                "Report[reportText='%s', createdAt='%s']",
                text, createdAt.toString());
    }

}
