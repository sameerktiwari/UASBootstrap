package com.cg.uas.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Date;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.cg.uas.dao.UASDAO;
import com.cg.uas.dao.UASDAOImpl;
import com.cg.uas.entities.Application;
import com.cg.uas.exception.UniversityException;

@RunWith(MockitoJUnitRunner.class)
public class DaoTest {

	@Mock
	EntityManager entityManager;
	
	@InjectMocks
	private UASDAO dao = new UASDAOImpl();
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void test() throws UniversityException {
		Application application=new Application("Sameer Tiwari", Date.valueOf("1995-04-02"), "BTech", 88, "Successful", "sameerkt@gmail.com", "1001","Pending");
		assertEquals(application, dao.save(application));
	}

}
