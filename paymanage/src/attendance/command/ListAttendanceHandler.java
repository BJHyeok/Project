package attendance.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import attendance.service.ListAttendanceService;
import attendance.service.AttendancePage;
import mvc.command.CommandHandler;

public class ListAttendanceHandler implements CommandHandler{
	private ListAttendanceService listService = new ListAttendanceService();
	
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String pageNoVal = req.getParameter("pageNo");
		int pageNo = 1;
		
		if(pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		
		AttendancePage attendancePage = listService.getWorkPage(pageNo);
		req.setAttribute("attendancePage", attendancePage);
		
		return "/view/attendance/listAttendence.jsp";
	}
}
