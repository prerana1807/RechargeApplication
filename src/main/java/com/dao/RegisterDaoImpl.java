package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.model.Admin;
import com.model.Login;
import com.model.Recharge;
import com.model.Register;

public class RegisterDaoImpl implements RegisterDao{
	 static Connection con=null;

	@Override
	public int saveData(Register reg) {
		int i=0;
		con=MyConnection.myConnection();
		try
		{
			PreparedStatement ps=con.prepareStatement("insert into Register values(?,?,?,?,?)");
			ps.setString(1, reg.getName());
			ps.setString(2, reg.getUname());
			ps.setString(3, reg.getMail());
			ps.setString(4, reg.getPass());
			ps.setString(5, reg.getMobNo());
			i=ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
		return i;
	}

	@Override
	public boolean VaildateUser(Login lobj) {
		boolean b=false;
		con=MyConnection.myConnection();
		try {
		  PreparedStatement ps=con.prepareStatement("select * from Register where uname=? and pass=?");
		  ps.setString(1, lobj.getUname());
		  ps.setString(2, lobj.getPass());
		  ResultSet rs=ps.executeQuery();
		  if(rs.next())
		  {
			  b=true;
		  }
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	 return b;
	}

	@Override
	public int savaData(Admin adm) {
		int i=0;
		con=MyConnection.myConnection();
		try
		{
			PreparedStatement ps=con.prepareStatement("insert into Admin values(?,?,?,?,?)");
			ps.setInt(1, adm.getRegNo());
			ps.setString(2, adm.getName());
			ps.setString(3, adm.getUserName());
			ps.setString(4, adm.getEmail());
			ps.setString(5, adm.getPass());
			i=ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
		return i;
	}

	@Override
	public int saveData(Recharge plan) {
		int i=0;
		con=MyConnection.myConnection();
		try
		{
			PreparedStatement ps=con.prepareStatement("insert into Recharge values(?,?,?,?,?)");
			ps.setInt(1, plan.getId());
			ps.setString(2, plan.getOpeName());
			ps.setString(3, plan.getPlanDetails());
			ps.setString(4, plan.getPlanValidity());
			ps.setFloat(5, plan.getPrice());
			i=ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
		return i;
	}

	@Override
	public List<Recharge> searchData(int id) {
			ResultSet rs=null;
			Recharge plan=null;
			LinkedList<Recharge> plst=new LinkedList<>();
			con=MyConnection.myConnection();
			int i=0;
			try
			{
				PreparedStatement ps=con.prepareStatement("select * from Recharge where id=?");
				ps.setInt(1, id);
				rs=ps.executeQuery();	
			} 
			catch(Exception e) {
				System.out.println(e);
			}
			try
			{
			if(rs.next())
			{
			    plan=new Recharge();
				plan.setId(rs.getInt(1));
				plan.setOpeName(rs.getString(2));
				plan.setPlanDetails(rs.getString(3));
				plan.setPlanValidity(rs.getString(4));
				plan.setPrice(rs.getFloat(5));
				plst.add(plan);
			}
		}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return plst;
	}

	@Override
	public int updateData(int id, String planDetails, String planValidity, Float price) {
		con=MyConnection.myConnection();
		int i=0;
		try {
			PreparedStatement pstate=con.prepareStatement("update Recharge set PLANDETAILS=?, PLANVALIDITY=?, PRICE=? where  ID=?");
			pstate.setString(1, planDetails);
			pstate.setString(2, planValidity);
			pstate.setFloat(3, price);
			pstate.setInt(4, id);
			i=pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
	}

	@Override
	public int deleteRechagre(int id) {
		con=MyConnection.myConnection();
		int i=0;
		try {
			PreparedStatement pstate=con.prepareStatement("delete from Recharge where ID=?");
			pstate.setInt(1,id);
			i=pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<Recharge> displayAll() {
		ResultSet rs=null;
		Recharge plan=null;
		LinkedList<Recharge> plst=new LinkedList<>();
		con=MyConnection.myConnection();
		Statement state=null;
		String str=null;
		try
		{
			state=con.createStatement();
			rs=state.executeQuery("select * from Recharge");
			if(rs.next())
			{
				plan=new Recharge();
				plan.setId(rs.getInt(1));
				plan.setOpeName(rs.getString(2));
				plan.setPlanDetails(rs.getString(3));
				plan.setPlanValidity(rs.getString(4));
				plan.setPrice(rs.getFloat(5));
				plst.add(plan);
			}
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return plst;
	}
}
