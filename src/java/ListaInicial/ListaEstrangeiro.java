/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaInicial;

import Classes.Estrangeiro;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodri
 */
public class ListaEstrangeiro {
     private static List<Estrangeiro> Estrangeiro;
    
    public static List<Estrangeiro> getInstance(){
        if(Estrangeiro == null){
           Estrangeiro = new ArrayList<>();
           Estrangeiro.add(new Estrangeiro(1,"Yan Paiva", "28/12/2016¨28/12/2018","emailfalso@gmail.com","9999-9999"));
           ListaLingua.getInstance();                 
        }
        return Estrangeiro;
    }
}
