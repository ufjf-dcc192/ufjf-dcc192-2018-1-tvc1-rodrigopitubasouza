/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author rodri
 */
public class Intercambio {
    private Anfitriao anfitriao;
    private Estrangeiro estrangeiro;

    public Intercambio(Anfitriao anfitriao, Estrangeiro estrangeiro) {
        this.anfitriao = anfitriao;
        this.estrangeiro = estrangeiro;
    }

    public Anfitriao getAnfitriao() {
        return anfitriao;
    }

    public void setAnfitriao(Anfitriao anfitriao) {
        this.anfitriao = anfitriao;
    }

    public Estrangeiro getEstrangeiro() {
        return estrangeiro;
    }

    public void setEstrangeiro(Estrangeiro estrangeiro) {
        this.estrangeiro = estrangeiro;
    }
    
    
}
