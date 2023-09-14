package salary.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import salary.service.DeleteSalaryService;

public class DeleteSalaryHandler implements CommandHandler {

    private DeleteSalaryService deleteService = DeleteSalaryService.getInstance();

    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
        if (req.getMethod().equalsIgnoreCase("POST")) {
            return processSubmit(req, res);
        } else {
            res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
            return null;
        }
    }

    private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
        try {
            // emp_no 파라미터 받아오기
            String empNo = req.getParameter("emp_no");

            // DeleteSalaryService를 사용하여 급여 정보 삭제
            deleteService.deleteSalary(empNo);

            // 삭제가 성공하면 성공 페이지로 리다이렉트
            return "/view/salary/success.jsp"; // 적절한 성공 페이지의 경로로 변경
        } catch (Exception e) {
            // 예외 발생 시 오류 메시지를 설정하고 오류 페이지로 이동
            req.setAttribute("error", "급여 정보 삭제 중 오류가 발생했습니다.");
            return "/view/error.jsp"; // 오류 페이지의 경로를 적절히 변경
        }
    }
}
