package sf;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tiago
 */
public class VerExtrato extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int numero = Integer.parseInt("0" + request.getParameter("numero"));
        Cliente c = Repositorio.getCliente(numero);
        List<Extrato> e = Repositorio.verExtrato(numero);
        if (e == null) {
            String address = "/WEB-INF/ErrorPage.html";
            RequestDispatcher dispatcher = request.getRequestDispatcher(address);
            dispatcher.forward(request, response);
            return;
        }
        String address = "/WEB-INF/ExtratoResponse.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        String resposta = "<p><h3>Olá " + c.getNome() + ", ashaBank agradece sua visita</h3></p>"
                + "<p>O extrato da sua conta é:</p>";
        resposta += "<div  class=\"extrato\">";
        for(Extrato ex : e){
            resposta += "<p>";
            resposta += "Às <b>" + ex.getDataFormatada() + "</b>";
            if(ex.getTipo() == Repositorio.DEPOSIT_TYPE){
                resposta += String.format(" - DEPÓSITO: R$%.2f", ex.getValor());
            }else if(ex.getTipo() == Repositorio.TRANSFER_TYPE){
                resposta += String.format(" - TRANSFERÊNCIA: R$%.2f", ex.getValor());
            }else if(ex.getTipo() == Repositorio.WITHDRAW_TYPE) {
                resposta += String.format(" - SAQUE: R$%.2f", ex.getValor());
            }
            resposta += " foi realizado.</p>";
        }
        resposta += "</div>";
        request.setAttribute("ExtratoResponse", resposta);
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
