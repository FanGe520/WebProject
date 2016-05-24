package com.hzt.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.hzt.bean.Student;

public class DbHelper {
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/mydb";

	public Connection ConnectToDb() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "hzt");
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Student> getStudents() {
		try {
			List<Student> listStudents = new ArrayList<Student>();
			Statement sm = ConnectToDb().createStatement();
			String sql = "select * from student";
			ResultSet result = sm.executeQuery(sql);
			while (result.next()) {
				int stuId = result.getInt("stuId");
				String name = result.getString("name");
				String address = result.getString("address");
				listStudents.add(new Student(stuId, name, address));
			}
			sm.close();
			return listStudents;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
