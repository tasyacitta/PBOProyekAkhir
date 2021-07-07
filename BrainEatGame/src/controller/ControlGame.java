package controller;

import view.*;

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
    
}
