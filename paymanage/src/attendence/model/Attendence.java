package attendence.model;

import java.util.Date;

public class Attendence {

	private String no;
	private String name;
	private String jobgrade;
	private Date entrydate;
	private String attendencetype;
	private Date startdate;
	private Date enddate;
	private int attendencedays;
	private String description;

	public Attendence(String no, String name, String jobgrade, Date entrydate, String attendencetype, Date startdate,
			Date enddate, int attendencedays, String description) {
		this.no = no;
		this.name = name;
		this.jobgrade = jobgrade;
		this.entrydate = entrydate;
		this.attendencetype = attendencetype;
		this.startdate = startdate;
		this.enddate = enddate;
		this.attendencedays = attendencedays;
		this.description = description;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobgrade() {
		return jobgrade;
	}

	public void setJobgrade(String jobgrade) {
		this.jobgrade = jobgrade;
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
		return "Work [no=" + no + ", name=" + name + ", jobgrade=" + jobgrade + ", entrydate=" + entrydate
				+ ", attendencetype=" + attendencetype + ", startdate=" + startdate + ", enddate=" + enddate
				+ ", attendencedays=" + attendencedays + ", description=" + description + "]";
	}

}
