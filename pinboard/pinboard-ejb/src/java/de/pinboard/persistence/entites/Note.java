/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.pinboard.persistence.entites;

import de.pinboard.to.AbstractTO;
import de.pinboard.to.NoteTO;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author maximilianstrauch
 */
@Entity
public class Note extends AbstractEntity {
    
    private String title, createdBy, text;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public AbstractTO getTO() {
        NoteTO to = new NoteTO();
        to.setId(getId());
        to.setTitle(title);
        to.setCreatedBy(createdBy);
        to.setCreatedOn(createdOn);
        to.setText(text);
        return to;
    }
    
}
