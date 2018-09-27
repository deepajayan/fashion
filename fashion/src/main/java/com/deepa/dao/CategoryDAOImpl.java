package com.deepa.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deepa.model.Category;


@Repository("CategoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO
{
  @Autowired
  SessionFactory sessionFactory;
 
  public boolean addCategory(Category category) 
  {
	  System.out.println("entering addCategory...");
		try
		{
			System.out.println("Adding cat");
			
			sessionFactory.getCurrentSession().save(category);

		//Transaction tx=s.beginTransaction();
			//	tx.commit();
			System.out.println("Ad cat sucess");
			return true;
		}
		finally{
			
			
		}
		
	}

	public boolean deleteCategory(Category category) 
	{
		
		try
		{
			sessionFactory.getCurrentSession().delete(category);
			
			return true;
		}
		catch(Exception e)
		{
		
		return false;
		}
	}

	public boolean updateCategory(Category category) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(category);
			
			return true;
		}
		catch(Exception e)
		{
		
		return false;
		}
	}
	

	public List<Category> listCategories() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Category");
		List<Category> listCategories=query.list();
		session.close();
		return listCategories;
	}

	public Category getCategory(int categoryId) 
	{
		Session session=sessionFactory.openSession();
		Category category=(Category)session.get(Category.class, categoryId);
		session.close();
		return category;
	}

}
