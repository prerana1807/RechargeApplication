package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegisterDao;
import com.dao.RegisterDaoImpl;

/**
 * Servlet implementation class UpdateRecharge
 */
@WebServlet("/UpdateRecharge")
public class UpdateRecharge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRecharge() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String planDetails=request.getParameter("planDetails1");
		String planValidity=request.getParameter("planValidity2");
		float price=Float.parseFloat(request.getParameter("price3"));
		int id=Integer.parseInt(request.getParameter("id4"));
		
		PrintWriter pw=response.getWriter();
		RegisterDao rd=new RegisterDaoImpl();
	
		int i=rd.updateData(id, planDetails, planValidity, price);
		if(i>0)
		{
			pw.println("Updated successfully");
		}
		else {
			pw.println("Not update");
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
