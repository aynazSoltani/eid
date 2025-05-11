package example;

import db.Entity;
import db.Trackable;

import java.util.Date;

public class Document extends Entity implements Trackable {
    public String content;
    private Date creationDate;
    private Date LastModificationDate;

    public Document(String content){
        this.content = content;
    }



    // گتر ها و ستر ها
    public void setLastModificationDate(Date lastModificationDate){
        this.LastModificationDate = lastModificationDate;
    }

    public void setCreationDate(Date creationDate){
        this.creationDate = creationDate;
    }

    public Date getLastModificationDate(){
        return LastModificationDate;
    }

    public Date getCreationDate(){
        return creationDate;
    }



    public int getEntityCode() {
        return 15;
    }

    @Override
    public Document copy(){
        Document copy = new Document(content);
        copy.id = id;
        copy.creationDate = creationDate;
        copy.LastModificationDate = LastModificationDate;
        return copy;

    }



}