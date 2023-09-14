package salary.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import salary.dao.SalaryDao;

public class DeleteSalaryService {

	private static DeleteSalaryService instance = new DeleteSalaryService();

	public static DeleteSalaryService getInstance() {
		return instance;
	}

	private DeleteSalaryService() {
		super();
	}

	public void deleteSalary(String emp_no) {
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			SalaryDao salaryDao = new SalaryDao();

			// SalaryDao의 delete 메서드를 호출하여 급여 정보 삭제
			salaryDao.delete(conn, emp_no);

			conn.commit();
		} catch (SQLException e) {
			// SQLException 처리
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			// 리소스 정리
			JdbcUtil.close(conn);
		}
	}
}
