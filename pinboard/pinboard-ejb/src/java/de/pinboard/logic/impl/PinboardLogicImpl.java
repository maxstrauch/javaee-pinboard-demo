/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.pinboard.logic.impl;

import de.pinboard.logic.PinboardLogic;
import de.pinboard.persistence.entity.Pinboard;
import de.pinboard.to.NoteTO;
import de.pinboard.to.PinboardTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author akaibel
 */
@Stateless
public class PinboardLogicImpl implements PinboardLogic {

    @PersistenceContext(name = "pinboard-ejbPU")
    private EntityManager em;
    
    @Override
    public List<PinboardTO> getPinboards() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createPinboard(PinboardTO pinboard) {
        Pinboard p = new Pinboard();
        p.setTitle(pinboard.getTitle());
        
        em.persist(p);
        
        return true;
    }

    @Override
    public void createNote(long pinboardId, NoteTO note) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
