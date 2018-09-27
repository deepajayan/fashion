package com.deepa.test;


	import org.springframework.context.annotation.AnnotationConfigApplicationContext;

	import com.deepa.model.Category;

	public class TestBean 
	{
		public static void main(String arg[])
		{
			
			AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			
			context.scan("com.deepa");
			
			context.refresh();
			
			Category category=(Category)context.getBean("category");
			
			category.display();
			context.close();
		}

}
