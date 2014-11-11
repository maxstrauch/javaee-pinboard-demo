package de.pinboard.web;

import de.pinboard.logic.PinboardLogic;
import de.pinboard.to.NoteTO;
import de.pinboard.to.PinboardTO;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author maximilianstrauch
 */
@Named
@SessionScoped
public class PinboardNotesBean implements Serializable {
    
    @EJB
    private PinboardLogic pinboardLogic;
    
    private PinboardTO pinboard;

    private String title, text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public PinboardTO getPinboard() {
        return pinboard;
    }

    public void setPinboard(PinboardTO pinboard) {
        this.pinboard = pinboard;
    }
    
    public List<NoteTO> getNotes() {
        return pinboardLogic.getNotes(pinboard.getId());
    }
    
    public void createNote() {
        NoteTO note = new NoteTO();
        note.setTitle(title);
        note.setCreatedBy("Otto"); // TODO: replace by currently signed in user name !
        note.setText(text.trim());
        pinboardLogic.addNote(pinboard.getId(), note);
        
        // Reset
        title = null;
        text = null;
    }
    
}
