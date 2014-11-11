package de.pinboard.web;

import java.io.Serializable;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author maximilianstrauch
 */
@Named
@SessionScoped
public class LocaleBean implements Serializable {
    
    private Locale locale;
    
    @PostConstruct
    public void init() {
        setGerman();
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
    
    public void setEnglish() {
        locale = Locale.ENGLISH;
    }
    
    public void setGerman() {
        locale = Locale.GERMAN;
    }
    
}
