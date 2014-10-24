package de.pinboard.web;


import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author akaibel
 */
@SessionScoped
@Named
public class PinboardListBean implements Serializable {
    
    private String name = "Hallo";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void doSth() {
        System.out.println("Hallo");
    }
    
}
