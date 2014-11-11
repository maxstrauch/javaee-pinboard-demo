/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.pinboard.logic;

import de.pinboard.to.NoteTO;
import de.pinboard.to.PinboardTO;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author maximilianstrauch
 */
@Remote
public interface PinboardLogic {
    
    public boolean addPinboard(PinboardTO to);
    
    public boolean deletePinboard(long id);
    
    public void addNote(long pinboardId, NoteTO to);
    
    public boolean deleteNote(long id);
    
    public List<PinboardTO> getPinboards();
    
    public List<NoteTO> getNotes(long pinboardId);
    
}
