package attendence.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import attendence.dao.AttendenceDao;
import employee.model.Employee;
import jdbc.connection.ConnectionProvider;

public class ListWorkService {
	private AttendenceDao workDao = new AttendenceDao();
	private int size = 10;
	
	public WorkPage getWorkPage(int pageNum) throws SQLException {
		try(Connection conn = ConnectionProvider.getConnection()) {
			int total = workDao.selectCount(conn);
			List<Employee> content = workDao.select(conn, pageNum);
			
			return new WorkPage(total, pageNum, size, content);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
