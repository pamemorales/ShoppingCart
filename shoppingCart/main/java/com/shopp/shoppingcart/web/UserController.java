package com.shopp.shoppingcart.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopp.shoppingcart.dao.UserDAO;
import com.shopp.shoppingcart.model.User;

@Controller
public class UserController {

	@Autowired 
	UserDAO userDao;
	
	@RequestMapping(value="users/{id}",
            method=RequestMethod.POST)
	
	@ResponseBody
	public User FindUser(@PathVariable int idUser){
		User user = userDao.findUser(idUser);
		
		return user;
	}
	
		
	
	
	
}
