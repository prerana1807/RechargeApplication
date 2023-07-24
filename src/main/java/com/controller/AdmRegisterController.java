package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegisterDao;
import com.dao.RegisterDaoImpl;
import com.model.Admin;
import com.model.Register;

/**
 * Servlet implementation class AdmRegisterController
 */
@WebServlet("/AdmRegisterController")
public class AdmRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdmRegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int regNo=Integer.parseInt(request.getParameter("regNo"));
		String name=request.getParameter("name");
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		String mail=request.getParameter("mail");
		
	
		Admin adm=new Admin();
		adm.setRegNo(regNo);
		adm.setName(name);
		adm.setUserName(uname);
		adm.setEmail(mail);
		adm.setPass(pass);
		
		RegisterDao rdao=new RegisterDaoImpl();
		int i=rdao.savaData(adm);
		if(i>0)
		{
			response.sendRedirect("Login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
