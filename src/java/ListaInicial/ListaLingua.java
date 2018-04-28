/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaInicial;


import Classes.Lingua;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodri
 */
public class ListaLingua {
     private static List<Lingua> lingua;
    
    public static List<Lingua> getInstance(){
        if(lingua == null){
           lingua = new ArrayList<>();
           lingua.add(new Lingua(0,"Inglês"));
           lingua.add(new Lingua(1,"Portugues"));
           lingua.add(new Lingua(2,"Espanhol"));
           lingua.add(new Lingua(3,"Chinês"));
           lingua.add(new Lingua(4,"Francês"));
                             
           ListaAnfitriao.getInstance().get(0).getLinguagens().add(lingua.get(0));
           ListaAnfitriao.getInstance().get(0).getLinguagens().add(lingua.get(1));
           ListaAnfitriao.getInstance().get(0).getLinguagens().add(lingua.get(4));
           ListaEstrangeiro.getInstance().get(0).getLinguagens().add(lingua.get(1));
           ListaEstrangeiro.getInstance().get(0).getLinguagens().add(lingua.get(2));
           ListaEstrangeiro.getInstance().get(0).getLinguagens().add(lingua.get(3));
        }
        return lingua;
    }
}
