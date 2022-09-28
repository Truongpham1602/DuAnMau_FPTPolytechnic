/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author THIS PC
 */
public class NewClass {
    ArrayList<DateHelper> lst;
    
    public NewClass(){
        lst = new ArrayList<>();
    }

    public ArrayList<DateHelper> getLst() {
        return lst;
    }

    public void setLst(ArrayList<DateHelper> lst) {
        this.lst = lst;
    }
    
    public ArrayList<DateHelper> getvaitro(){
        return lst;
    }
    
}
