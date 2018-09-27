package com.deepa.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.deepa.dao.UserDAO;
import com.deepa.model.User;

public class UserDAOTest {
	static UserDAO userDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.deepa");
		context.refresh();
	    userDAO=(UserDAO)context.getBean("UserDAO");
	}
	@Ignore
    @Test
    public void registerUserTest()
    {
    	User user=new User();
    	user.setUsername("Monisha");
        user.setPassword("moni");
        user.setCustomerName("Monisha");
        user.setMobileNumber("9626319002");
        user.setEmailId("monisha24@gmail.com");
        user.setRole("Admin");
        user.setEnabled("enable");
        assertTrue("Problem in Adding User:",userDAO.registerUser(user));
    }
   // @Ignore
    @Test
    public void modifyUserTest()
    {
    	User user=userDAO.getUser("Monisha");
    	user.setUsername("priya");
        user.setPassword("Nikatha");
        user.setCustomerName("Harini");
        user.setMobileNumber("9585115455");
        user.setEmailId("harinisri@gmail.com");
        user.setRole("Admin");
        user.setEnabled("enable");
        assertTrue("Problem in modifying the User:",userDAO.modifyUser(user));
    }
   

}
