package management;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/management/update")
public class updateController extends HttpServlet {

	/** 개별 회원 조회 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> updateController 개별 회원 조회(doGet) 실행");
		
		int custno = Integer.parseInt(req.getParameter("custno"));
		System.out.println(">> custno : " + custno);
		ObjectMapper mapper = new ObjectMapper();
		MemberListDto result = ManagementDao.getInstance().find(custno);
		String jsonResult = mapper.writeValueAsString(result);
		System.out.println(">> jsonResult : " + jsonResult);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);		
		
		System.out.println(">> updateController 개별 회원 조회(doGet) 끝");
	}
	
	/** 회원정보 수정 */
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> updateController 회원정보 수정(doPut) 실행");
		
		ObjectMapper mapper = new ObjectMapper();
		MemberListDto memberListDto = mapper.readValue(req.getReader(), MemberListDto.class);
		boolean result = ManagementDao.getInstance().update(memberListDto);
		System.out.println(">> result : " + result);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
		System.out.println(">> updateController 회원정보 수정(doPut) 끝");
	}
	
}
