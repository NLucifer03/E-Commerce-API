package com.masai.service;

import java.util.List;

import com.masai.exception.AdminException;
import com.masai.exception.CustomerException;
import com.masai.model.Admin;
import com.masai.model.Customer;

public interface AdminService {

//	--------------------------------------creating Admin------------------------------------------------------------
	public Admin addAdmin(Admin admin) throws AdminException;
	
//	---------------------------------------------delete admin Account----------------------------------------------
	public Admin deleteAdmin(Integer adminId) throws AdminException;
	
//	--------------------------------------------update Admin Account------------------------------------------------
	public Admin updateAdmin(Admin admin) throws AdminException;
	
//	---------------------------------------------get admin Account---------------------------------------------------
	public Admin getAdminById(Integer adminId) throws AdminException;

//	----------------------------------------------view All admins----------------------------------------------------
	public List<Admin> viewAllAdmins() throws AdminException;
	
}
