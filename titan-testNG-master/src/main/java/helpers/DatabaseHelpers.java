package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DatabaseHelpers {
	static String hostname = "tek-instrance-db.mysql.database.azure.com";
	static String dbName = "tek_insurance_app";
	static String username = "tek_db_admin";
	static String password = "ADMIN_MAY_2022";

	static String query = "Select * From primary_Person;";
	
	public static void main(String[] args) {
		
		List<Map<String, Object>> data = getResultSet(query);
		
		for (Map<String, Object> map : data) {
			System.out.println(map);
		}
	}
	
	public static Connection getMySQLConnection(String hostName, String dbName, String userName, String password)
			throws SQLException {
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

		Connection conn = DriverManager.getConnection(connectionURL, userName, password);

		return conn;
	}

	public static List<Map<String, Object>> getResultSet(String sql) {

		List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();

		try (Connection conn = getMySQLConnection(hostname, dbName, username, password);
				ResultSet rs = conn.createStatement().executeQuery(sql);) {
			while (rs.next()) {
				Map<String, Object> row = new LinkedHashMap<String, Object>();
				ResultSetMetaData meta = rs.getMetaData();
				for (int i = 1; i <= meta.getColumnCount(); i++)
					row.put(meta.getColumnName(i), rs.getObject(i));
				rows.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	
}
