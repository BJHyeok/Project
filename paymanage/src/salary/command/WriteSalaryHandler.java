package salary.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import salary.model.SalaryPay;
import salary.service.WriteSalaryService;

public class WriteSalaryHandler implements CommandHandler {
	private static final String FORM_VIEW = "/view/salary/writeSalaryForm.jsp";
	private WriteSalaryService writeService = new WriteSalaryService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		// 급여 내역을 입력받아서 데이터베이스에 저장하는 작업 수행
		// 폼에서 입력된 데이터를 읽어와 SalaryPay 객체를 생성
		// WriteSalaryService를 사용하여 급여 내역을 데이터베이스에 저장

		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		try {
			// 폼에서 입력된 데이터를 읽어와서 SalaryPay 객체를 생성
			String emp_no = req.getParameter("emp_no");
			int base_pay = Integer.parseInt(req.getParameter("base_pay"));
			int food = Integer.parseInt(req.getParameter("food"));
			int duty_charge = Integer.parseInt(req.getParameter("duty_charge"));
			int transport = Integer.parseInt(req.getParameter("transport"));
			int bonus = Integer.parseInt(req.getParameter("bonus"));

			SalaryPay salaryPay = new SalaryPay(emp_no, base_pay, food, duty_charge, transport, bonus);

			// WriteSalaryService를 사용하여 급여 내역을 데이터베이스에 저장
			Integer savedEmpNo = writeService.write(salaryPay);

			// 급여 내역이 성공적으로 저장되면 성공 페이지로 리다이렉트
			// 실패하면 에러 메시지를 설정하고 급여 내역 입력 폼으로 다시 포워딩
			if (savedEmpNo != null) {
				return "/salary/success.jsp";
			} else {
				errors.put("saveFailed", Boolean.TRUE);
				return FORM_VIEW;
			}
		} catch (NumberFormatException e) {
			// 숫자 변환 오류 발생 시 에러 메시지 설정
			errors.put("invalidNumberFormat", Boolean.TRUE);
			return FORM_VIEW;
		}
	}
}
