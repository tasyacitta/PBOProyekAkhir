package controller;

import model.ActionModel;
import model.ModelRegis;
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
    
    public void menuAdmin(String[] data){
       ActionModel am = new ActionModel();
       am.cekLogin(data);
    }
    
    public void menuAdminView(){
      new MenuAdminView();
    }
    
    public void cekUser(String[] data){
       ActionModel am = new ActionModel();
       am.cekUser(data);
    }
    
    public void menuUserView(){
      new MenuUserView();
    }
    
    public void inputRegis(String[] data){
        ModelRegis mr = new ModelRegis();
        mr.inputRegis(data);
    }
    
    public void delete(String nama){
        ActionModel model = new ActionModel();
        model.delete(nama);
    }
    
    public void lihatData(){
        ActionModel model = new ActionModel();
        String[][] data = model.lihatData();
        if(data == null)
            System.out.println("Tidak ada data!");
        else
            new DataView(data);
    }

public void lihatData(String nama){
        ActionModel model = new ActionModel();
        DataView view = new DataView();
        view.openDetail(model.lihatData(nama));
}
}