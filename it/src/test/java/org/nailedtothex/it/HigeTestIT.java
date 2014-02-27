package org.nailedtothex.it;

import static org.junit.Assert.*;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HigeTestIT {

	Context context;
	Hige instance;

	@Before
	public void before() throws Exception {
		context = new InitialContext();
		instance = (Hige) context.lookup("ejb:/it//HigeImpl!org.nailedtothex.it.Hige");
	}

	@After
	public void after() throws Exception {
		if (context != null) {
			context.close();
		}
	}

	@Test
	public void test() {
		System.out.println("***THIS IS A INTEGRATION TEST***");
		assertEquals(6, instance.doHige(2, 3));
	}

}
