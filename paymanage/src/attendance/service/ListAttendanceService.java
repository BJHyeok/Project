package attendance.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import attendance.dao.AttendanceDao;
import attendance.model.Attendance;
import jdbc.connection.ConnectionProvider;

public class ListAttendanceService {
	private AttendanceDao attendanceDao = new AttendanceDao();
	private int size = 10;

	public AttendancePage getAttendancePage(int pageNum) throws SQLException {
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = attendanceDao.selectTotal(conn);
			List<Attendance> content = attendanceDao.select(conn, pageNum);

				System.out.println(content);
				
			return new AttendancePage(total, pageNum, size, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
