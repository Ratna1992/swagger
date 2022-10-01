package com.core.spring.intro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.core.spring.intro.beans.Student;
import com.core.spring.intro.config.BeanConfig;

@SpringBootApplication
public class SpringCoreIntroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreIntroApplication.class, args);

		ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
		Student bean1 = ctx.getBean("getStudent", Student.class);
		System.out.println(bean1.hashCode());

		Student bean2 = ctx.getBean("getStudent", Student.class);
		System.out.println(bean2.hashCode());

		Student bean3 = ctx.getBean("getStudentPara", Student.class);
		System.out.println(bean3.hashCode());
	}

}
