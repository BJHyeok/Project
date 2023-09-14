package attendence.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import attendence.service.ListWorkService;
import attendence.service.WorkPage;
import mvc.command.CommandHandler;

public class ListAttendenceHandler implements CommandHandler{
	private ListWorkService listService = new ListWorkService();
	
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String pageNoVal = req.getParameter("pageNo");
		int pageNo = 1;
		
		if(pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		
		WorkPage workPage = listService.getWorkPage(pageNo);
		req.setAttribute("workPage", workPage);
		
		return "/view/attendence/listAttendence.jsp";
	}
}
