package todoapp.classes;

import java.util.Date;
/**
 * Created by ben on 25/03/17.
 */
public class Report {

    public Report() {}

    public Report(String text){
        this.text = text;
    }

    private String text;

    private Date createdAt = new Date();

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
