/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.pinboard.persistence.entites;

import de.pinboard.to.AbstractTO;
import de.pinboard.to.PinboardTO;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author maximilianstrauch
 */
@Entity
public class Pinboard extends AbstractEntity {
    
    private String title;
    
    @OneToMany(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private Set<Note> notes;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Note> getNotes() {
        if (notes == null) {
            notes = new HashSet<>();
        }
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

    @Override
    public AbstractTO getTO() {
        PinboardTO to = new PinboardTO();
        to.setId(getId());
        to.setTitle(title);
        return to;
    }
    
}
