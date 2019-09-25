package com.apress.todo.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity(name = "todo")
public class ToDo{
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    private   String id;

    private  String description;
    private Timestamp Created;
    private  Timestamp modified;

    private boolean completed;

    public ToDo(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    public Timestamp getModified() {
        return modified;
    }

    public Timestamp getCreated() {
        return Created;
    }

    public void setCreated(Timestamp created) {
        Created = created;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    public  boolean isCompleted(){
        return completed;
    }
}