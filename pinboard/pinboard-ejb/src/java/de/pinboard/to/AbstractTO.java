/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.pinboard.to;

import de.pinboard.persistence.entites.AbstractEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author akaibel
 */
public abstract class AbstractTO {
    
    
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
        
    public static final <T extends AbstractTO, R extends AbstractEntity> T convert(R entity) {
        return (T) entity.getTO();
    }
    
    public static final <T extends AbstractTO, R extends AbstractEntity> List<T> convert(Collection<R> entities) {
        List<T> all = new ArrayList<>();
        for (R entity : entities) {
            all.add((T) entity.getTO());
        }
        return all;
    }
    
    
}
