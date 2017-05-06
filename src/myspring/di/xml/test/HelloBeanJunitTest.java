package myspring.di.xml.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

public class HelloBeanJunitTest {

	ApplicationContext context;

	@Before
	public void init() {
		// IoC 컨테이너 생성
		context = new GenericXmlApplicationContext("config/beans.xml");
	}

	@Test
	public void test2() {
		// 2. Hello Bean 가져오기
		Hello hello = (Hello) context.getBean("hello");
		Hello hello2 = (Hello) context.getBean("hello");

		assertSame(hello, hello2);
		assertEquals(hello, hello2);
	}

	@Ignore
	@Test
	public void test1() {
		// TODO Auto-generated method stub
		// 2. Hello Bean 가져오기
		Hello hello = (Hello) context.getBean("hello");
		assertEquals("Hello Spring", hello.sayHello());
		hello.print();

		// 3. StringPrinter Bean 가져오기
		Printer printer = context.getBean("printer", Printer.class);
		assertEquals("Hello Spring", printer.toString());

		Hello hello2 = context.getBean("hello", Hello.class);
		System.out.println(hello == hello2);

	}

}
