package com.cg.uas.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.cg.uas.dao.UASDAO;
import com.cg.uas.dao.UASDAOImpl;
import com.cg.uas.entities.Application;
import com.cg.uas.entities.ProgramsOffered;
import com.cg.uas.entities.ProgramsScheduled;
import com.cg.uas.entities.User;
import com.cg.uas.exception.UniversityException;


@RunWith(MockitoJUnitRunner.class)
public class UASTest {
	
	TypedQuery<User> query;
	TypedQuery<ProgramsOffered> programsOffered;
	TypedQuery<ProgramsScheduled> programsScheduled;
	TypedQuery<Application> applications;
	
	User user;
	ProgramsOffered programOffered;
	ProgramsScheduled programScheduled;
	Application application;
	
	@Mock
	EntityManager entityManager;
	
	@InjectMocks
	private UASDAO dao = new UASDAOImpl();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		query=Mockito.mock(TypedQuery.class);
	}

	@Test
	public void testValidate(){
		User user=new User("akash","akash","mac");
		assertEquals(false, dao.validate(user));
	}
	
	
	@Test
	public void testSave() throws UniversityException{
		Application application=new Application("Sameer Tiwari", Date.valueOf("1995-04-02"), "BTech", 88, "Successful", "sameerkt@gmail.com", "1001","Pending");
		assertEquals(application, dao.save(application));
	}
	/*
	@Test
	public void testGetStatus() throws UniversityException{
		Application application=new Application("Sameer Tiwari", Date.valueOf("1995-04-02"), "BTech", 88, "Successful", "sameerkt@gmail.com", "1001","Pending");
		application=dao.save(application);
		assertEquals("Pending",dao.getStatus(application.getApplicationId()).getStatus());
	}
	
	@Test
	public void testGetPrograms() throws UniversityException{
		ProgramsScheduled acnt=new ProgramsScheduled();
		acnt.setProgramName("Accounting");
		ProgramsScheduled history=new ProgramsScheduled();
		history.setProgramName("History");
		List<ProgramsScheduled> programs=new ArrayList<>();
		programs.add(acnt);
		programs.add(history);
		assertEquals(programs, dao.viewProgrammes());
	}*/
/*
	@Test
	public void testGetAllBooks() throws Exception {
		List<BookInventory> bookInventories = new ArrayList<BookInventory>();
		BookInventory book1 = new BookInventory();
		BookInventory book2 = new BookInventory();
		BookInventory book3 = new BookInventory();
		book1.setBookId("123");
		book2.setBookId("1234");
		book3.setBookId("345");
		bookInventories.add(book1);
		bookInventories.add(book2);
		bookInventories.add(book3);
		stub(libraryDao.getAllBooks()).toReturn(bookInventories);

		assertEquals(bookInventories, libraryServiceImpl.getAllBooks());
		verify(libraryDao).getAllBooks();
	}

	@Test
	public void testValidateUser() throws Exception {
		User users = new User();
		String userName = "username";
		String password = "password";
		users.setUserName(userName);
		users.setPassword(password);
		users.setLibrarian("true");

		stub(libraryDao.validateUser(userName, password)).toReturn(users);

		assertEquals(1, libraryServiceImpl.validateUser(userName, password));
		verify(libraryDao).validateUser(userName, password);
	}

	@Test
	public void testInsertBook() throws Exception {
		BookInventory bookInventory = new BookInventory();
		String bookId = "123";
		bookInventory.setBookId(bookId);

		stub(libraryDao.insertBook(bookInventory)).toReturn(bookInventory);

		assertEquals(bookInventory,
				libraryServiceImpl.insertBook(bookInventory));
		verify(libraryDao).insertBook(bookInventory);
	}

	@Test
	public void testDeleteBookById() throws Exception {
		BookInventory bookInventory = new BookInventory();
		String bookId = "123";
		bookInventory.setBookId(bookId);

		stub(libraryDao.deleteBookById(bookId)).toReturn(bookInventory);

		assertEquals(bookInventory, libraryServiceImpl.deleteBookById(bookId));
		verify(libraryDao).deleteBookById(bookId);
	}

	@Test
	public void testGetUserDetails() throws Exception {
		User users = new User();
		String userName = "username";
		String password = "password";
		users.setUserName(userName);
		users.setPassword(password);
		users.setLibrarian("true");

		stub(libraryDao.getUserDetails()).toReturn(users);

		assertEquals(users, libraryServiceImpl.getUserDetails());
		verify(libraryDao).getUserDetails();
	}

	@Test
	public void testRequestBook() throws Exception {
		BookRegistration bookRegistration = new BookRegistration();
		bookRegistration.setBookId("123");
		bookRegistration.setRegistrationDate(Date.valueOf(LocalDate.now()));
		bookRegistration.setRegistrationId(12);
		bookRegistration.setStatus(Constants.pending);
		bookRegistration.setUserId(1234);
		BookInventory bookInventory = new BookInventory();
		bookInventory.setBookId("123");
		bookInventory.setNoOfBooks(12);
		stub(libraryDao.getBookById(Mockito.anyString())).toReturn(
				bookInventory);
		stub(libraryDao.requestBook(bookRegistration)).toReturn(
				bookRegistration);
		assertEquals(bookRegistration,
				libraryServiceImpl.requestBook(bookRegistration));
		verify(libraryDao).requestBook(bookRegistration);
		verify(libraryDao).getBookById(Mockito.anyString());
	}

	@Test
	public void testReturnBook() throws Exception {
		BookTransaction bookTransaction = new BookTransaction();
		bookTransaction.setRegistrationId(1234);
		bookTransaction.setIssueDate(Date.valueOf(LocalDate.now()));
		BookRegistration bookRegistration = new BookRegistration();
		bookRegistration.setRegistrationId(1234);

		stub(libraryDao.returnBookTransaction(Mockito.anyInt())).toReturn(
				bookTransaction);
		stub(libraryDao.getBookRegistration(Mockito.anyInt())).toReturn(
				bookRegistration);
		assertEquals(0, libraryServiceImpl.returnBook(Mockito.anyInt()));
		verify(libraryDao).updateBookTransaction(bookTransaction);
		verify(libraryDao).updateBookQuantity(Mockito.anyString(),
				Mockito.anyInt());
		verify(libraryDao).updateBookRegistration(bookRegistration);
	}

	@Test
	public void testIssueBook() throws Exception {
		BookRegistration bookRegistration = new BookRegistration();
		bookRegistration.setRegistrationId(1234);
		stub(libraryDao.getBookRegistration(Mockito.anyInt())).toReturn(
				bookRegistration);

		BookTransaction bookTransaction = new BookTransaction();
		bookTransaction.setIssueDate(Date.valueOf(LocalDate.now()));
		bookTransaction.setRegistrationId(1234);
		libraryServiceImpl.issueBook(1234);
		verify(libraryDao, Mockito.times(1)).updateBookQuantity(
				Mockito.anyString(), Mockito.anyInt());
		verify(libraryDao, Mockito.times(1)).updateBookRegistration(
				bookRegistration);
	}

	@Test
	public void testGetAllRequest() throws Exception {
		List<BookRegistration> bookRegistrations = new ArrayList<BookRegistration>();
		BookRegistration bookRegistration1 = new BookRegistration();
		BookRegistration bookRegistration2 = new BookRegistration();

		bookRegistration1.setRegistrationId(123);
		bookRegistration2.setRegistrationId(321);
		bookRegistrations.add(bookRegistration1);
		bookRegistrations.add(bookRegistration2);
		stub(libraryDao.getAllRequests()).toReturn(bookRegistrations);

		assertEquals(bookRegistrations, libraryServiceImpl.getAllRequests());
		verify(libraryDao).getAllRequests();
	}

	@Test
	public void testAddUser() throws Exception {
		User users = new User();
		String userName = "username";
		String password = "password";
		users.setUserName(userName);
		users.setPassword(password);
		users.setLibrarian("true");

		stub(libraryDao.addUser(users)).toReturn(users);
		assertEquals(users, libraryServiceImpl.addUser(users));
		verify(libraryDao).addUser(users);
	}

	@Test
	public void testGetRequestByStatus() throws Exception {
		List<BookRegistration> bookRegistrations = new ArrayList<BookRegistration>();
		BookRegistration bookRegistration1 = new BookRegistration();
		BookRegistration bookRegistration2 = new BookRegistration();

		bookRegistration1.setRegistrationId(123);
		bookRegistration1.setStatus("issued");
		bookRegistration2.setRegistrationId(321);
		bookRegistration2.setStatus("issued");
		bookRegistrations.add(bookRegistration1);
		bookRegistrations.add(bookRegistration2);

		stub(libraryDao.getRequestByStatus(Mockito.anyString())).toReturn(
				bookRegistrations);
		assertEquals(bookRegistrations,
				libraryServiceImpl.getRequestByStatus(Mockito.anyString()));
		verify(libraryDao).getRequestByStatus(Mockito.anyString());
	}

	@Test
	public void testSearchBookByAuthor() throws Exception {
		List<BookInventory> bookInventories = new ArrayList<BookInventory>();
		BookInventory book1 = new BookInventory();
		BookInventory book2 = new BookInventory();
		BookInventory book3 = new BookInventory();
		book1.setBookId("123");
		book1.setAuthor("author");
		book2.setBookId("1234");
		book2.setAuthor("author");
		book3.setBookId("345");
		book3.setAuthor("author");
		bookInventories.add(book1);
		bookInventories.add(book2);
		bookInventories.add(book3);

		stub(libraryDao.searchBookByAuthor(Mockito.anyString())).toReturn(
				bookInventories);
		assertEquals(bookInventories,
				libraryServiceImpl.searchBookByAuthor(Mockito.anyString()));
		verify(libraryDao).searchBookByAuthor(Mockito.anyString());
	}

	@Test
	public void testSearchBookByName() throws Exception {
		List<BookInventory> bookInventories = new ArrayList<BookInventory>();
		BookInventory book1 = new BookInventory();
		BookInventory book2 = new BookInventory();
		BookInventory book3 = new BookInventory();
		book1.setBookId("123");
		book1.setAuthor("author");
		book1.setBookName("book1");
		book2.setBookId("1234");
		book2.setAuthor("author");
		book1.setBookName("book2");
		book3.setBookId("345");
		book3.setAuthor("author");
		book3.setBookName("book1");
		bookInventories.add(book1);
		bookInventories.add(book2);
		bookInventories.add(book3);

		stub(libraryDao.searchBookByName(Mockito.anyString())).toReturn(
				bookInventories);
		assertEquals(bookInventories,
				libraryServiceImpl.searchBookByName(Mockito.anyString()));
		verify(libraryDao).searchBookByName(Mockito.anyString());
	}*/
}