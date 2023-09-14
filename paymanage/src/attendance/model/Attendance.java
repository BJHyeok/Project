package attendance.model;

import java.util.Date;

public class Attendance {

	private String emp_no; // 사원번호
	private String emp_name; // 사원명
	private String classify; // 구분
	private String dept; // 부서
	private String position; // 직급
	private Date entrydate; // 입력일자
	private String attendencetype; // 근태항목
	private Date startdate; // 근태 시작일
	private Date enddate;// 근태 종료일
	private int attendencedays;// 근태일수
	private String description;// 근태 설명

	public Attendance(String emp_no, String emp_name, String classify, String dept, String position, Date entrydate,
			String attendencetype, Date startdate, Date enddate, int attendencedays, String description) {
		this.emp_no = emp_no;
		this.emp_name = emp_name;
		this.classify = classify;
		this.dept = dept;
		this.position = position;
		this.entrydate = entrydate;
		this.attendencetype = attendencetype;
		this.startdate = startdate;
		this.enddate = enddate;
		this.attendencedays = attendencedays;
		this.description = description;
	}

	public String getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(Date entrydate) {
		this.entrydate = entrydate;
	}

	public String getAttendencetype() {
		return attendencetype;
	}

	public void setAttendencetype(String attendencetype) {
		this.attendencetype = attendencetype;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public int getAttendencedays() {
		return attendencedays;
	}

	public void setAttendencedays(int attendencedays) {
		this.attendencedays = attendencedays;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Attendence [emp_no=" + emp_no + ", emp_name=" + emp_name + ", classify=" + classify + ", dept=" + dept
				+ ", position=" + position + ", entrydate=" + entrydate + ", attendencetype=" + attendencetype
				+ ", startdate=" + startdate + ", enddate=" + enddate + ", attendencedays=" + attendencedays
				+ ", description=" + description + "]";
	}
	
	

}