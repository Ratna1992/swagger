package com.core.spring.intro.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.core.spring.intro.beans.People;
import com.core.spring.intro.beans.Student;
import com.core.spring.intro.config.BeanConfig;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	@Qualifier("employee")
	private People people1;
	@Autowired
	@Qualifier("manager")
	private People people2;

	@Override
	public void run(String... args) throws Exception {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
		Student bean1 = ctx.getBean("getStudent", Student.class);
		System.out.println(bean1.hashCode());

		Student bean2 = ctx.getBean("getStudent", Student.class);
		System.out.println(bean2.hashCode());

		Student bean3 = ctx.getBean("getStudentPara", Student.class);
		System.out.println(bean3.hashCode());

		System.out.println(people1.designation());
		System.out.println(people2.designation());
	}

}
