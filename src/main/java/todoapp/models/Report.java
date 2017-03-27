package todoapp.models;

import javax.persistence.*;
import java.util.Date;
/**
 * Created by ben on 25/03/17.
 */
@Entity
@Table(name = "report")
public class Report {

    @Id
    @Column(name = "reportId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String text;

    private Date createdAt = new Date();

    public Report() {}

    public Report(String text){
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
