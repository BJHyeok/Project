package salary.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import salary.dao.SalaryDao;
import salary.model.Salary;

public class ModifySalaryService {
	private SalaryDao salaryDao = new SalaryDao();

	public void modify(ModifyRequest modReq) throws Exception {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			Salary salary = salaryDao.selectById(conn, modReq.getEmp_no());
			if (salary == null) {
				throw new Exception();
			}
			
		

			salaryDao.update(conn,modReq.getEmp_no(), modReq.getBase_pay(), modReq.getFood(), modReq.getDuty_charge(),
					modReq.getTransport(), modReq.getBonus());
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
		
		
		}
	}

