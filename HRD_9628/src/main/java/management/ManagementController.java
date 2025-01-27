package management;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/management")
public class ManagementController extends HttpServlet {
	
	/** 회원목록조회 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> ManagementController 회원목록조회(doGet) 실행");
		
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<MemberListDto> result = ManagementDao.getInstance().findAll();
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("Application/json");
		resp.getWriter().print(jsonResult);
		
		System.out.println(">> ManagementController 회원목록조회(doGet) 끝");
	}
	
	/** 회원등록 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> ManagementController 회원등록(doPost) 실행");
		
		ObjectMapper mapper = new ObjectMapper();
		MemberListDto memberListDto = mapper.readValue(req.getReader(), MemberListDto.class);
		boolean result = ManagementDao.getInstance().create(memberListDto);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
		
		System.out.println(">> ManagementController 회원등록(doPost) 끝");
	}
	
}
