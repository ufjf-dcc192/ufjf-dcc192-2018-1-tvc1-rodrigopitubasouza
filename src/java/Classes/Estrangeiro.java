/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodri
 */
public class Estrangeiro {
    private int id;
    private String nome;
    private String disponibilidade;
    private String email;
    private String telefone;
    private List<Lingua> linguagens;

    public Estrangeiro() {
    }
    
    public Estrangeiro(int id,String nome, String disponibilidade, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.disponibilidade = disponibilidade;
        this.email = email;
        this.telefone = telefone;
        this.linguagens = new ArrayList();
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Lingua> getLinguagens() {
        return linguagens;
    }

    public void setLinguagens(List<Lingua> linguagens) {
        this.linguagens = linguagens;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
    
}
