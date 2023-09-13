//package salary.command;
//
//import java.io.IOException;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import mvc.command.CommandHandler;
//import salary.model.Salary;
//import salary.service.ModifySalaryService;
//
//public class ModifySalaryHandler implements CommandHandler {
//
//	private static final String FORM_VIEW = "/view/salary/modifySalary.jsp";
//
//	private ModifySalaryService modifyService = new ModifySalaryService();
//
//	@Override
//	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
//		// TODO Auto-generated method stub
//		if (req.getMethod().equalsIgnoreCase("GET")) {
//			return processForm(req, res);
//		} else if (req.getMethod().equalsIgnoreCase("POST")) {
//			return processSubmit(req, res);
//		} else {
//			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
//			return null;
//		}
//	}
//
//	private String processForm(HttpServletRequest req, HttpServletResponse res) throws IOException {
//	    try {
//	        String empNoVal = req.getParameter("emp_no");
//	        int empNo = Integer.parseInt(empNoVal);
//	        
//	        // SalaryDao를 사용하여 급여 정보를 가져옵니다.
//	        Salary salary = modifyService.getSalaryByEmpNo(empNo);
//	        
//	        // 급여 정보를 request 속성에 저장하여 JSP에서 사용할 수 있도록 합니다.
//	        req.setAttribute("salary", salary);
//	        
//	        // 급여 수정을 위한 입력 폼을 보여줄 JSP 경로를 반환합니다.
//	        return FORM_VIEW;
//	    } catch (NumberFormatException e) {
//	        // emp_no 파라미터가 숫자가 아닌 경우, 오류 메시지를 설정하고 급여 목록 화면으로 이동합니다.
//	        req.setAttribute("error", "사원 번호는 숫자로 입력하세요.");
//	        req.getRequestDispatcher("/view/salary/listSalary.jsp").forward(req, res);
//	        return null;
//	    } catch (Exception e) {
//	        // 예외 발생 시 오류 메시지를 설정하고 오류 페이지로 이동합니다.
//	        req.setAttribute("error", "급여 정보를 불러오는 중 오류가 발생했습니다.");
//	        req.getRequestDispatcher("/view/error.jsp").forward(req, res);
//	        return null;
//	    }
//	}
//
//
//	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
//		try {
//			// 사용자로부터 입력받은 급여 정보를 파라미터로부터 추출하고, 필요한 유효성 검사를 수행합니다.
//			// 예를 들어, String empNoVal = req.getParameter("emp_no");
//			// int empNo = Integer.parseInt(empNoVal);
//
//			// TODO: 급여 정보를 수정하는 코드를 추가해야 합니다.
//			// 예를 들어, SalaryDao를 사용하여 급여 정보를 업데이트하는 메서드를 호출할 수 있습니다.
//
//			// 수정이 완료되면 급여 목록 화면으로 리다이렉트하거나 다른 적절한 화면으로 이동합니다.
//			// res.sendRedirect(req.getContextPath() + "/view/salary/listSalary.jsp");
//			// return null;
//		} catch (Exception e) {
//			// 예외 발생 시 오류 메시지를 설정하고 오류 페이지로 이동합니다.
//			req.setAttribute("error", "급여 정보 수정 중 오류가 발생했습니다.");
//			return null;
//		}
//		return null; // 다른 경우는 null을 반환하여 아무 처리도 하지 않습니다.
//	}
//
//}
