package salary.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import salary.service.ModifyRequest;
import salary.service.ModifySalaryService;

public class ModifySalaryHandler implements CommandHandler {
	private static final String FORM_VIEW = "/view/salary/modifySalary.jsp";
	private ModifySalaryService modifyService = new ModifySalaryService();

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

	private String processForm(HttpServletRequest req, HttpServletResponse res) throws IOException {

		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		try {
			// POST 요청으로 제출된 데이터를 추출하고 유효성 검사를 수행
			String emp_no = req.getParameter("emp_no");
			int basePay = Integer.parseInt(req.getParameter("base_pay"));
			int food = Integer.parseInt(req.getParameter("food"));
			int dutyCharge = Integer.parseInt(req.getParameter("duty_charge"));
			int transport = Integer.parseInt(req.getParameter("transport"));
			int bonus = Integer.parseInt(req.getParameter("bonus"));

			// ModifyRequest 객체 생성
			ModifyRequest modReq = new ModifyRequest(emp_no, basePay, food, dutyCharge, transport, bonus);

			ModifyRequest savedEmpNo = modifyService.modify(modReq);

//			// ModifySalaryService를 사용하여 급여 정보 수정
//			modifyService.modify(modReq);
//			req.setAttribute("modReq", modReq);
//			// 수정이 성공하면 성공 페이지로 리다이렉트
//			return "/view/salary/success.jsp"; // 적절한 성공 페이지의 경로로 변경
//
//		} catch (Exception e) {
//			// 예외 발생 시 오류 메시지를 설정하고 오류 페이지로 이동
//			req.setAttribute("error", "급여 정보 수정 중 오류가 발생했습니다.");
//			return "/view/error.jsp"; // 오류 페이지의 경로를 적절히 변경
//		}
//	}
//}

			if (savedEmpNo != null) {
				// 이렇게 작성하면 잘 동작함
//				return "salary/success.jsp";  
				return "/view/salary/success.jsp";
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
