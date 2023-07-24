package com.dao;

import java.util.List;

import com.model.Admin;
import com.model.Login;
import com.model.Recharge;
import com.model.Register;

public interface RegisterDao {
	public int saveData(Register reg);
	public boolean VaildateUser(Login lobj);
	public int savaData(Admin adm);
	public int saveData(Recharge plan);
	public List<Recharge> searchData(int id);
	public int updateData(int id,String planDetails,String planValidity, Float price);
	public int deleteRechagre(int id);
	public List<Recharge> displayAll();
}
