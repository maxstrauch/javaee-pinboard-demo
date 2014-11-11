/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.pinboard.logic.impl;

import de.pinboard.logic.PinboardLogic;
import de.pinboard.persistence.entites.Note;
import de.pinboard.persistence.entites.Pinboard;
import de.pinboard.to.AbstractTO;
import de.pinboard.to.NoteTO;
import de.pinboard.to.PinboardTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author maximilianstrauch
 */
@Stateless
public class PinboardLogicImpl implements PinboardLogic {

    @PersistenceContext(name = "pinboard-ejbPU")
    private EntityManager em;

    @Override
    public boolean addPinboard(PinboardTO to) {
        // Check if name already exists
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(p) FROM Pinboard p WHERE p.title = :title", 
                Long.class
        );
        query.setParameter("title", to.getTitle());
        long count = query.getSingleResult();
        if (count > 0) {
            return false;
        }
        
        Pinboard pinboard = new Pinboard();
        pinboard.setTitle(to.getTitle());
        em.persist(pinboard);
        return true;
    }

    @Override
    public boolean deletePinboard(long id) {
        try {
            em.remove(em.find(Pinboard.class, id));
            return true;
        } catch (Exception ex) {
            System.err.println("Failed to delete pinboard with #" + id + ": " + ex);
            return false;
        }
    }

    @Override
    public void addNote(long pinboardId, NoteTO to) {
        
        Pinboard pb = em.find(Pinboard.class, pinboardId);
        
        
        Note note = new Note();
        note.setTitle(to.getTitle());
        note.setCreatedBy(to.getCreatedBy());
        note.setCreatedOn(new Date());
        note.setText(to.getText());
        
        pb.getNotes().add(note);
        
        em.persist(pb);
    }

    @Override
    public boolean deleteNote(long id) {
        try {
            em.remove(em.find(Note.class, id));
            return true;
        } catch (Exception ex) {
            System.err.println("Failed to delete note with #" + id + ": " + ex);
            return false;
        }
    }

    @Override
    public List<PinboardTO> getPinboards() {
        return AbstractTO.convert(
                em.createQuery("SELECT p FROM Pinboard p", Pinboard.class).getResultList()
        );
    }

    @Override
    public List<NoteTO> getNotes(long pinboardId) {
        try {
            TypedQuery<Pinboard> query = em.createQuery(
                    "SELECT n FROM Note n, Pinboard p "
                  + "WHERE n member of p.notes AND p.id = :pinboardId", 
                    Pinboard.class
            );
            query.setParameter("pinboardId", pinboardId);
            return AbstractTO.convert(
                    query.getResultList()
            );
        } catch (Exception ex) {
            System.err.println("Exception in getNotes(...) for pinboardId = " 
                    + pinboardId + ": " + ex);
            return new ArrayList<>();
        }
    }
    
}
