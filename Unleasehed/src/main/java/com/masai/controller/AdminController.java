package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.AdminException;
import com.masai.model.Admin;
import com.masai.service.AdminService;


@RestController
public class AdminController {

//	--------injection Admin Service dependency---------
@Autowired
AdminService adminService;

//------------------------ add Admin handler------------------------------------

@PostMapping("/admins")
public ResponseEntity<Admin> addAdminHandler(@RequestBody Admin admin) throws AdminException
{
	return new ResponseEntity<Admin>(adminService.addAdmin(admin),HttpStatus.CREATED);
}

//------------------------- update Admin handler --------------------------------

@PutMapping("/admins")
public ResponseEntity<Admin> updateAdminHandler(@RequestBody Admin admin) throws AdminException
{	
	return new ResponseEntity<Admin>(adminService.updateAdmin(admin),HttpStatus.OK);
}

//----------------------------get Admin by id handler ------------------------------

@GetMapping("/admins/{adminId}")
public ResponseEntity<Admin> getAdminByIdHandler(@PathVariable Integer adminId) throws AdminException
{	
	return new ResponseEntity<Admin>(adminService.getAdminById(adminId),HttpStatus.OK);
}

//-----------------------------delete Admin by product id handler --------------------

@DeleteMapping("/admins/{adminId}")
public ResponseEntity<Admin> deleteAdminHandler(@PathVariable Integer adminId) throws AdminException
{	
	return new ResponseEntity<Admin>(adminService.deleteAdmin(adminId),HttpStatus.OK);
}

//--------------------------------get all Admin handler------------------------------

@GetMapping("/admins")
public ResponseEntity<List<Admin>> viewAllAdminHandler() throws AdminException
{	
	return new ResponseEntity<List<Admin>>(adminService.viewAllAdmins(),HttpStatus.OK);
}
	
}
