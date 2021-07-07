package controller;

import view.*;
import model.*;

public class ControlGame {
        
    public void registrasi(){
        RegisterView rv = new RegisterView();
        rv.formRegis();
    }
    
    public void login(){
        
        Loginview lv = new Loginview();
        lv.formLogin();
    }
    
    public void menuAdmin(){
        new MenuAdminView();
    }
    
    public void menuUser(){
        new MenuAdminView();
    }
    
    public void inputRegis(String[] data){
        ModelRegis mr=new ModelRegis();
        mr.inputRegis(data);
    }
    
}
