package attendance.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import attendance.dao.AttendanceDao;
import employee.model.Employee;
import jdbc.connection.ConnectionProvider;

public class ListAttendanceService {
	private AttendanceDao attendanceDao = new AttendanceDao();
	private int size = 10;

	public AttendancePage getWorkPage(int pageNum) throws SQLException {
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = attendanceDao.selectByemp_no(conn);
			List<Employee> content = attendanceDao.select(conn, pageNum);

			return new AttendancePage(total, pageNum, size, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
