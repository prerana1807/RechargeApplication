package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegisterDao;
import com.dao.RegisterDaoImpl;
import com.model.Recharge;

/**
 * Servlet implementation class DisplayRechargeServlet
 */
@WebServlet("/DisplayRechargeServlet")
public class DisplayRechargeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayRechargeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisterDao rdao=new RegisterDaoImpl();
		List<Recharge> plst=rdao.displayAll();
		PrintWriter out=response.getWriter();
		out.print("<table>");
		for(Recharge plan:plst)
		{
			 out.print("<tr><td>"+plan.getId()+"</td><td>"+plan.getOpeName()+"</td><td>"+plan.getPlanDetails()+"</td><td>"+plan.getPlanValidity()+"</td><td>"+plan.getPrice()+"</td></tr>");
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
