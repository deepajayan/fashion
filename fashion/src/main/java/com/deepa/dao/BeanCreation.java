package com.deepa.dao;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.deepa.model.Category;
import com.deepa.model.Supplier;

@Configuration

public class BeanCreation
{
	@Bean(name="category")
	public Category createCategoryBean()
	{
		System.out.println("i am in create category bean");
		return new Category();
	}

	@Bean(name="supplier")
	public Supplier createSupplierBean()
	{
		System.out.println("i am in create category bean");
		return new Supplier();
	}
}
