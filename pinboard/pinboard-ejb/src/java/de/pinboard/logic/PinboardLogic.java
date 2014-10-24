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
 * @author akaibel
 */
@Remote
public interface PinboardLogic {
    
    public List<PinboardTO> getPinboards();
    
    public boolean createPinboard(PinboardTO pinboard);
    
    public void createNote(long pinboardId, NoteTO note);
    
}
