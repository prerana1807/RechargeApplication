package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegisterDao;
import com.dao.RegisterDaoImpl;
import com.model.Recharge;
import com.model.Register;

/**
 * Servlet implementation class RechargeController
 */
@WebServlet("/RechargeController")
public class RechargeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechargeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String opeName=request.getParameter("opeName");
		String planDetails=request.getParameter("planDetails");
		String planValidity=request.getParameter("planValidity");
		Float price=Float.parseFloat(request.getParameter("price"));
		
		
		Recharge plan=new Recharge();
		plan.setId(id);
		plan.setOpeName(opeName);
		plan.setPlanDetails(planDetails);
		plan.setPlanValidity(planValidity);
		plan.setPrice(price);
		
		RegisterDao rdao=new RegisterDaoImpl();
		int i=rdao.saveData(plan);
		if(i>0)
		{
			System.out.println("Rechrge plan created");
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
