/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Anfitriao;
import Classes.Estrangeiro;
import Classes.Intercambio;
import ListaInicial.ListaAnfitriao;
import ListaInicial.ListaEstrangeiro;
import ListaInicial.ListaLingua;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rodri
 */
@WebServlet(name = "BuddyServlet", urlPatterns = {"/index.html","/anfitriao.html","/estrangeiro.html","/pedirEstrangeiro.html","/intercambio.html"})
public class BuddyServlet extends HttpServlet {
    List<Intercambio> inter = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if ("/index.html".equals(request.getServletPath())) {
            listarDisponiveis(request, response);    
    }else if ("/anfitriao.html".equals(request.getServletPath())) {
            cadastrarAnfitriao(request, response);    
    }else if ("/estrangeiro.html".equals(request.getServletPath())) {
            cadastrarEstrangeiro(request, response);    
    }else if ("/pedirEstrangeiro.html".equals(request.getServletPath())) {
            pedirEstrangeiro(request, response);    
    }else if ("/intercambio.html".equals(request.getServletPath())) {
        try {    
            criarIntercambio(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(BuddyServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("/anfitriao.html".equals(request.getServletPath())) {
            String nome = request.getParameter("nome");
            String endereco = request.getParameter("endereco");
            String disponivel = "";
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date data =formato.parse(request.getParameter("disponivel"));
                Date data2 =formato.parse(request.getParameter("ate"));
                disponivel = formato2.format(data);
                disponivel += "¨"+ formato2.format(data2);
            } catch (ParseException ex) {
                Logger.getLogger(BuddyServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            String email = request.getParameter("email");
            int idioma = Integer.parseInt(request.getParameter("i1"));
            int idioma2 = Integer.parseInt(request.getParameter("i2"));
            String telefone = request.getParameter("telefone");
            Anfitriao a = new Anfitriao(ListaAnfitriao.getInstance().size()+1,nome,endereco,disponivel.replaceAll("¨", " "),email,telefone);
            a.getLinguagens().add(ListaLingua.getInstance().get(idioma));
            a.getLinguagens().add(ListaLingua.getInstance().get(idioma2));
            ListaAnfitriao.getInstance().add(a);
            
            response.sendRedirect("index.html");
        }
        else if ("/estrangeiro.html".equals(request.getServletPath())) {
            String nome = request.getParameter("nome");
            String disponivel = "";
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date data =formato.parse(request.getParameter("disponivel"));
                Date data2 =formato.parse(request.getParameter("ate"));
                disponivel = formato2.format(data);
                disponivel += "¨"+ formato2.format(data2);
            } catch (ParseException ex) {
                Logger.getLogger(BuddyServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            String email = request.getParameter("email");
            String telefone = request.getParameter("telefone");
            int idioma = Integer.parseInt(request.getParameter("i1"));
            int idioma2 = Integer.parseInt(request.getParameter("i2"));
            Estrangeiro a = new Estrangeiro(ListaEstrangeiro.getInstance().size()+1,nome,disponivel.replaceAll("¨", " "),email,telefone);
            a.getLinguagens().add(ListaLingua.getInstance().get(idioma));
            a.getLinguagens().add(ListaLingua.getInstance().get(idioma2));
            ListaEstrangeiro.getInstance().add(a);
            response.sendRedirect("index.html");
        }
        else if("/intercambio.html".equals(request.getServletPath())) {
            int idA = Integer.parseInt(request.getParameter("anfitriao"))-1;
            int idE = Integer.parseInt(request.getParameter("id"))-1;
            inter.add(new Intercambio(ListaAnfitriao.getInstance().get(idA),ListaEstrangeiro.getInstance().get(idE)));
            ListaAnfitriao.getInstance().remove(idA);
            ListaEstrangeiro.getInstance().remove(idE);
        }
    }
    
    

    private void listarDisponiveis(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("anfitrioes", ListaAnfitriao.getInstance());
        request.setAttribute("estrangeiros", ListaEstrangeiro.getInstance());
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/index.jsp");
        despachante.forward(request, response);
    }
    
    private void cadastrarAnfitriao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("lingua", ListaLingua.getInstance());
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/novoAnfitriao.jsp");
        despachante.forward(request, response);
    }
    
    private void cadastrarEstrangeiro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("lingua", ListaLingua.getInstance());
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/novoEstrangeiro.jsp");
        despachante.forward(request, response);
    }
    
    private void pedirEstrangeiro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("estrangeiros",ListaEstrangeiro.getInstance());
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/pedirEstrangeiro.jsp");
        despachante.forward(request, response);
    }
    
     private void criarIntercambio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        int id = Integer.parseInt(request.getParameter("id"))-1;
        Estrangeiro e = ListaEstrangeiro.getInstance().get(id);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataEstrangeiro = formato.parse(e.getDisponibilidade().split("¨")[0]);
        Date dataEstrangeiro2 = formato.parse(e.getDisponibilidade().split("¨")[1]);
        List<Anfitriao> lista = new ArrayList<>();
        for(int i = 0;i<ListaAnfitriao.getInstance().size();i++){
            if(dataEstrangeiro.after(formato.parse(ListaAnfitriao.getInstance().get(i).getDisponibilidade().split("¨")[0]))){
                lista.add(ListaAnfitriao.getInstance().get(i));
            }
        }
        
        request.setAttribute("anfitrioes", lista);
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/intercambio.jsp");
        despachante.forward(request, response);
    }
    
    
    
}
