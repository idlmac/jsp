package co.dev.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class AddMemberAjaxController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		MemberService service = MemberService.getInstance();
		resp.setContentType("text/json;charset=UTF-8");
		// 회원정보 등록 -> json 값 반환
		
		String id = req.getParameter("id");
		String pw = req.getParameter("passwd");
		String nm = req.getParameter("name");
		String ml = req.getParameter("mail");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPasswd(pw);
		vo.setName(nm);
		vo.setMail(ml);

		service.addMember(vo);
		
		// json 반환
		Gson gson = new GsonBuilder().create();
		try {
			resp.getWriter().print(gson.toJson(vo));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
