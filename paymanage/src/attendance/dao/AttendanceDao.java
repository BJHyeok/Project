package attendance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import attendance.model.Attendance;
import jdbc.JdbcUtil;

public class AttendanceDao {

	// 조회(년도, 월을 선택), 관리(입력정보/ )

	public int insert(Connection conn, Attendance attendance) throws SQLException {
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("insert into kintai values (kintai_seq.nextval, sysdate, ?, ?, ?, ?, ?, ?");

			pstmt.setString(1, attendance.getAttendencetype());
			pstmt.setTimestamp(2, toTimestamp(attendance.getStartdate()));
			pstmt.setTimestamp(3, toTimestamp(attendance.getEnddate()));
			pstmt.setInt(4, attendance.getAttendencedays());
			pstmt.setString(5, attendance.getDescription());
			pstmt.setString(6, attendance.getEmp_no());

			return pstmt.executeUpdate();

		} finally {
			JdbcUtil.close(pstmt);
		}
	}

	public int selectTotal(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from kintai");

			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}

	public List<Attendance> select(Connection conn, int page) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
//			pstmt = conn.prepareStatement(
//					"select * from ( select rownum rnum, a.* from (select * from kintai order by emp_no desc) a) where rnum between ? and ?");
			pstmt = conn.prepareStatement(
					"select * from kintai");

//			pstmt.setInt(1, 1 + (page - 1) * 10);
//			pstmt.setInt(2, page * 10);

			rs = pstmt.executeQuery();

			List<Attendance> result = new ArrayList<>();

			while (rs.next()) {
				result.add(convertAttendance(rs));
				System.out.println(result);
			}

			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private Attendance convertAttendance(ResultSet rs) throws SQLException {
		System.out.println(rs.getInt("num"));
		System.out.println(toDate(rs.getTimestamp("entrydate")));
		System.out.println(rs.getInt("attendancetype"));
		System.out.println(toDate(rs.getTimestamp("startdate")));;
		System.out.println(rs.getInt("enddate"));
		System.out.println(rs.getInt("attendancedays"));
		System.out.println(rs.getInt("description"));
		System.out.println(rs.getInt("emp_no"));
		
		
		return new Attendance(rs.getInt("num"), toDate(rs.getTimestamp("entrydate")), rs.getString("attendancetype"),
				toDate(rs.getTimestamp("startdate")), toDate(rs.getTimestamp("enddate")), rs.getInt("attendancedays"),
				rs.getString("description"), rs.getString("emp_no"));

	}
	
	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}


	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());

	}
}
