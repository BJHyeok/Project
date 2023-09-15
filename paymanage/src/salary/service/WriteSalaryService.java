package salary.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import salary.dao.SalaryDao;
import salary.model.SalaryPay;

public class WriteSalaryService {
    private SalaryDao salaryDao = new SalaryDao();

    public SalaryPay write(SalaryPay salaryPay) {
        Connection conn = null;
        try {
            conn = ConnectionProvider.getConnection();
            conn.setAutoCommit(false);

            SalaryPay result = salaryDao.insert(conn, salaryPay);


            conn.commit();
            return result; // Insert된 급여 내역의 개수를 반환하도록 수정

        } catch (SQLException e) {
            JdbcUtil.rollback(conn);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {
            JdbcUtil.rollback(conn);
            throw e;
        } finally {
            JdbcUtil.close(conn);
        }
    }
}
