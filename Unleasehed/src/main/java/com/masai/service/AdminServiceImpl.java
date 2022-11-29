package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.exception.AdminException;
import com.masai.model.Admin;
import com.masai.repository.AdminRepository;


public class AdminServiceImpl implements AdminService{

//	----------------injecting customerReposityr interface---------------
	@Autowired
	AdminRepository adminRepository;
	
//	----------------------------------------------------------------adding admin into database-------------------------------------------------------------
	
	@Override
	public Admin addAdmin(Admin admin) throws AdminException {
		
		if(admin.getAdminId() != null) throw new AdminException("Admin Id is not required");
		
		Admin saveAdmin = adminRepository.save(admin);
		if(saveAdmin == null) throw new AdminException("Failed to register Admin into database");
		
		return admin;
		
	}

//	----------------------------------------------------------------------deleting admin by customer id----------------------------------------------------
	
	@Override
	public Admin deleteAdmin(Integer adminId) throws AdminException {
		
		Admin admin = adminRepository.findById(adminId)
							.orElseThrow(() -> new AdminException("Please provide valid Admin Id..."));
		
		adminRepository.delete(admin);
		return admin;
		
	}
	
//	----------------------------------------------------------------------updating admin by customer object-------------------------------------------------

	@Override
	public Admin updateAdmin(Admin admin) throws AdminException {
		
		adminRepository.findById(admin.getAdminId())
		.orElseThrow(() -> new AdminException("Please provide valid Admin Id..."));
		
		return adminRepository.save(admin);
		
	}

//	------------------------------------------------------------------------get admin by customer id-------------------------------------------------------	

	@Override
	public Admin getAdminById(Integer adminId) throws AdminException {

		return adminRepository.findById(adminId)
				.orElseThrow(() -> new AdminException("Please provide valid Admin Id..."));
		
	}

//	--------------------------------------------------------------------------view all admins from database--------------------------------------------------
	
	@Override
	public List<Admin> viewAllAdmins() throws AdminException {
		
		List<Admin> admins = adminRepository.findAll();
		
		if(admins.size() == 0) throw new AdminException("No Admin is registered into the database");
		return admins;
		
	}
	
}
