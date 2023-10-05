/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bukhoree
 */
public class ResultServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            // Get the radius from the URL query parameter
            String radiusStr = request.getParameter("radius");
            double radius = Double.parseDouble(radiusStr);
            
            // Determine whether to calculate area or perimeter based on the button clicked
            String calculateType = request.getParameter("calculateType");
            double result = 0.0;
            String resultType = "";
            
            if ("Calculate Area".equals(calculateType)) {
                result = Math.PI * radius * radius;
                resultType = "Area";
            } else if ("Calculate Perimeter".equals(calculateType)) {
                result = 2 * Math.PI * radius;
                resultType = "Perimeter";
            }

            // Generate the HTML response
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Circle Calculator - Result</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Results for Circle " + resultType + " with Radius " + radius + "</h1>");
            out.println("<p>" + resultType + " is " + result + "</p>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
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
