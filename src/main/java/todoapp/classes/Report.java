package todoapp.classes;

import java.util.Date;
/**
 * Created by ben on 25/03/17.
 */
public class Report {

    private String text;

    private Date createdAt = new Date();

    public String getText() { return this.text;}

    public void setText(String text) { this.text = text;}


}
