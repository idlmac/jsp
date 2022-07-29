package co.dev.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;

public class RemoveMemberAjaxController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// 삭제 처리 => JSON 타입 반환
		resp.setContentType("text/json;charset=UTF-8");
		String id = req.getParameter("id");

		MemberService service = MemberService.getInstance();
		boolean isDeleted = service.removeMember(id);

		// {"retCode" : "Success"}
		try {
			if (isDeleted)
				resp.getWriter().print("{\"returnCode\" : \"Success\"}");
			else
				resp.getWriter().print("{\"returnCode\" : \"Fail\"}");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
