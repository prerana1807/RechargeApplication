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
 * Servlet implementation class SearchRecharge
 */
@WebServlet("/SearchRecharge")
public class SearchRecharge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchRecharge() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str=request.getParameter("id");
		RegisterDao rd=new RegisterDaoImpl();
		int id=Integer.parseInt(str);
		List<Recharge>plst=rd.searchData(id);
		
		PrintWriter out=response.getWriter();
		Recharge plan=(Recharge)plst.get(0);
		out.print(plan.getId()+"\t"+plan.getOpeName()+"\t"+plan.getPlanDetails()+"\t"+plan.getPlanValidity()+"\t"+plan.getPrice());
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
