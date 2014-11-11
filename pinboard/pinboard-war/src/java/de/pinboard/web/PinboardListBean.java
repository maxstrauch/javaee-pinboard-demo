package de.pinboard.web;


import de.pinboard.logic.PinboardLogic;
import de.pinboard.to.PinboardTO;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author maximilianstrauch
 */
@SessionScoped
@Named
public class PinboardListBean implements Serializable {
    
    @EJB
    private PinboardLogic pinboardLogic;
    
    @Inject
    private PinboardNotesBean pinboardNotesBean;
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public List<PinboardTO> getPinboards() {
        return pinboardLogic.getPinboards();
    }
    
    public void createNewPinboard() {
        PinboardTO to = new PinboardTO();
        to.setTitle(name);
        
        boolean created = pinboardLogic.addPinboard(to);
        
        FacesContext
                .getCurrentInstance()
                .addMessage(null, 
                        new FacesMessage(
                                created ? 
                                    "Neue Pinnwand \"" + name + "\" wurde angelegt." :
                                    "Fehler beim Anlegen der neuen Pinnwand!"
                        )
                );
        
        name = "";
    }
    
    public void deletePinboard(PinboardTO pinboard) {
        pinboardLogic.deletePinboard(pinboard.getId());
    }
    
    public String openPinboard(PinboardTO pinboard) {
        pinboardNotesBean.setPinboard(pinboard);
        return "notes";
    }
    
}
