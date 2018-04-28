/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaInicial;

import Classes.Anfitriao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodri
 */
public class ListaAnfitriao {
     private static List<Anfitriao> Anfitriao;
    
    public static List<Anfitriao> getInstance(){
        if(Anfitriao == null){
           Anfitriao = new ArrayList<>();
           Anfitriao.add(new Anfitriao(0,"Rodrigo Pituba", "Av. Presidente Costa e Silva Bloco 6/501,", "27/04/2018¨31/12/2018","emailfalso@gmail.com","9999-9999"));
           ListaLingua.getInstance();
        }
        return Anfitriao;
    }
}
