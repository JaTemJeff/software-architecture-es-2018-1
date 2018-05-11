/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.ui.control;

import com.mycompany.mavenproject1.business.CustomerBusiness;
import com.mycompany.mavenproject1.data.Country;
import com.mycompany.mavenproject1.data.Customer;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jeff
 */
@WebServlet ("/custumerController")
public class CustomerController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Country country = new Country();
        Customer newCustomer = new Customer(
                                        0, 
                                        req.getParameter("inputName"), 
                                        new Integer(req.getParameter("inputAge")), 
                                        req.getParameter("inputPhone"),
                                        req.getParameter("selectCountry"),
                                        new Double(req.getParameter("inputCreditLimit"))
                                        );
        
        CustomerBusiness business = new CustomerBusiness();
        try {
            business.create(newCustomer);
            req.getSession().setAttribute("custumerList", business.readAll());
            
        } catch (Exception ex) {
            Logger.getLogger(CountryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
