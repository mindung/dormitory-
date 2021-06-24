package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Setting {

	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost?allowLoadLocalInfile=true&serverTimezone=UTC","root","1234");
		Statement stmt = con.createStatement();

		stmt.execute("SET GLOBAL local_infile = 'on'");
		stmt.execute("drop database if exists dormitory");
		stmt.execute("create database dormitory default character set utf8");
		stmt.execute("use dormitory");
		
		stmt.execute("create table user(no int primary key not null auto_increment,"
				+ "id varchar(10),"
				+ "pw varchar(10),"
				+ "name varchar(5),"
				+ "r_no int)");
		
		stmt.execute("create table room(no int primary key not null auto_increment,"
				+ "room int ,"
				+ "r_peo int)");
		
		stmt.execute("create table attendance(no int primary key not null auto_increment,"
				+ "a_date date,"
				+ "r_no int,"
				+ "ect varchar(200))");
		
		var str = "user,room,attendance".split(",");
		for (int i = 0; i < str.length; i++) {
			stmt.execute("load data local infile './지급자료/" + str[i] + ".txt' into table " + str[i] + " ignore 1 lines");
		}
				
		stmt.execute("drop user if exists user");
		stmt.execute("create user 'user' identified by '1234'");
		stmt.execute("grant select, insert, delete, update on dormitory.* to 'user'");
		stmt.execute("flush privileges");

		System.err.println("실햐ㅐㅇ");
	}
}
