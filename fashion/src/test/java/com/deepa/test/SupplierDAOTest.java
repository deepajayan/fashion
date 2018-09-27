package com.deepa.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.deepa.dao.SupplierDAO;
import com.deepa.model.Supplier;

public class SupplierDAOTest {
	 static SupplierDAO supplierDAO;
		@BeforeClass
		public static void initialize()
		{
			System.out.println("Enter SuppTest init");
			AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			context.scan("com.deepa");
			context.refresh();
		    supplierDAO=(SupplierDAO)context.getBean("SupplierDAO");
		}
	
		//@Ignore
	    @Test
	    public void addSupplierTest()
	    {
	    	System.out.println("Enter addSupptest");
	    	Supplier supplier=new Supplier();
	    	supplier.setSupplierName("Samsung");
	        supplier.setAddress("London");
	        supplier.setSupplierName("Sony");
	        supplier.setAddress("Delhi");
	        assertTrue("Problem in Adding Supplier:",supplierDAO.addSupplier(supplier));
	    }
		//@Ignore
	    @Test
	    public void updateSupplierTest()
	    {
	    	Supplier supplier=supplierDAO.getSupplier(24);
	    	supplier.setSupplierName("LG");
	        supplier.setAddress("Paris");
	        assertTrue("Problem in updating the Supplier:",supplierDAO.updateSupplier(supplier));
	    }
	   // @Ignore
	    @Test
	    public void deleteSupplierTest()
	    {
	    	Supplier supplier=supplierDAO.getSupplier(23);
	        supplier.setAddress("Noida");
	        assertTrue("Problem in deleting the Supplier:",supplierDAO.deleteSupplier(supplier));
	    }
	    
	    @Ignore
	    @Test
	    public void listSuppliersTest()
	    {
	    	List<Supplier>listSuppliers=supplierDAO.listSuppliers();
	    	assertNotNull("Problem in listing supppliers",listSuppliers);
	    	for(Supplier supplier:listSuppliers)
	    	{
	    		System.out.print(supplier.getSupplierId()+":::");
	    		System.out.print(supplier.getSupplierName()+":::");
	    		System.out.print(supplier.getAddress());
	    	}
	    		
	    	
	    }


}
