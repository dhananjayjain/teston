package com.javatpoint;
import javax.servlet.*;
import java.sql.*;
// DHAAN 
//SECOND
//THIRD   by other 
// FOURTH   MASTER 
// SEVETH MASTER IN MASTER
// EIRGTH MASTER
// FIFTH WITH NEW BRANCH 
// SIX COMMIT IN NEW BRANCH

// NEW CODE START IN STAGING BRANCH

public class MyListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent arg0) {
		
		Connection con=null;
	try{
		ResultSet rs=null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		if(null==con) {
			System.out.println("DATABASE CONNECTED..............");
			PreparedStatement ps1=con.prepareStatement("Select * from QUIZCONTACT");
			rs=ps1.executeQuery();
		}
		else 
			System.out.println("NODATABASE");
		if(rs.next())
		{System.out.println("your table name already exist");}
		else 
		{System.out.println("else if part table does not exist new table has created");
	
		// Comment Start and check project and 
		// system .out println
		PreparedStatement ps2= con.prepareStatement("CREATE SEQUENCE JAVATPOINT MINVALUE 1 MAXVALUE 999999999 INCREMENT BY 1 START WITH 1 NOCACHE NOORDER NOCYCLE");
		ps2.executeUpdate();
		PreparedStatement ps=con.prepareStatement("CREATE TABLE QUIZCONTACT (NAME VARCHAR2(4000),EMAIL VARCHAR2(4000),PHONE VARCHAR2(4000),MESSAGE VARCHAR2(4000))");
		ps.executeUpdate();
		PreparedStatement ps4=con.prepareStatement("CREATE TABLE QUIZINFO (SUBJECT VARCHAR2(4000),QUIZNAME VARCHAR2(4000))");
		ps4.executeUpdate();		
		
	
		PreparedStatement  ps5=con.prepareStatement("CREATE TABLE  QUIZQ(NAME VARCHAR2(4000),EMAIL VARCHAR2(4000),PHONE VARCHAR2(4000),QUESTION VARCHAR2(4000))");
		ps5.executeUpdate();
		
		
		ps5= con.prepareStatement("CREATE TABLE  QUIZQUES(QUESTION VARCHAR2(4000),OPTION1 VARCHAR2(4000),OPTION2 VARCHAR2(4000),OPTION3 VARCHAR2(4000),OPTION4 VARCHAR2(4000),ANSWER VARCHAR2(4000),QUIZNAME VARCHAR2(4000),QID VARCHAR2(4000),DESCRIPTION VARCHAR2(4000),CONSTRAINT QUIZQUES_PK PRIMARY KEY (QID) ENABLE)");
		ps5.executeUpdate();
		
		
		ps5= con.prepareStatement("CREATE TABLE  QUIZREGISTER (USERNAME VARCHAR2(4000),USERPASS VARCHAR2(4000),CATEGORY VARCHAR2(4000),EMAIL VARCHAR2(4000))");
		ps5.executeUpdate();
		Statement stmt=con.createStatement();
		stmt.executeUpdate("CREATE TRIGGER  BI_QUIZINFO before insert on QUIZINFO for each row begin select JAVATPOINT.nextval into :NEW.QUIZNAME from dual;end");
		stmt.executeUpdate("CREATE TRIGGER  BI_QUIZQUES before insert on QUIZQUES for each row begin select JAVATPOINT.nextval into :NEW.QID from dual;end");
		}	
	}
		
	    catch(Exception e){
	    	System.out.println("IF TABLE NOT CREATED ="+e.getMessage()	);
	    	e.printStackTrace();
	    }
	    }
	    
	    public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("project undeployed");
		
		System.out.println("Start deployement and start project");
		//===========================================================================
		
		// NEW DEVELOPMENT START
		
		String sql = "SELECT id, username FROM users WHERE id = ?";
	    String url = "jdbc:sqlite:path-to-db-file/chinook/chinook.db";
	    try (Connection conn = DriverManager.getConnection(url);
	      Statement stmt = conn.createStatement()) {

	      try {
	        ResultSet rs = stmt.executeQuery("select * from albums");
	        while (rs.next()) {
	          String name = rs.getString("title");
	          System.out.println(name);
	        }
	      } catch (SQLException e ) {
	            throw new Error("Problem", e);
	      } 

	    } catch (SQLException e) {
	      throw new Error("Problem", e);
	    } 
		//  Now again commit in branch--------------------------------------------------------
	}
}
