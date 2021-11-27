package com.mindtree.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mindtree.exception.ConnectionUtilityException;

public class ConnectionUtility {
Connection con=null;
private static final String URL="jdbc:mysql://localhost:3306/jobpost";
private static final String USER="root";
private static final String PASSWORD="12345";
public Connection getMyConnection() throws ConnectionUtilityException
{
	try {
		con=DriverManager.getConnection(URL,USER,PASSWORD);
	} catch (SQLException e) {
	throw new ConnectionUtilityException(e);
	}
	
	return con;
	
}
public Connection closeResource(Connection con) throws ConnectionUtilityException {
	if (con != null) {
		try {
			con.close();
		} catch (SQLException e) {
			throw new ConnectionUtilityException();
		}
	}
	return con;
}
public Connection closeResource(PreparedStatement ps) throws ConnectionUtilityException {
	if (con != null) {
		try {
			ps.close();
		} catch (SQLException e) {
			throw new ConnectionUtilityException();
		}
	}
	return con;
}
public Connection closeResource(ResultSet rs) throws ConnectionUtilityException {
	if (con != null) {
		try {
			rs.close();
		} catch (SQLException e) {
			throw new ConnectionUtilityException();
		}
	}
	return con;
}

}
