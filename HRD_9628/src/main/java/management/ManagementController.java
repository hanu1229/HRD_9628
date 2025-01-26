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
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> doGet 실행");
		
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<MemberListDto> result = ManagementDao.getInstance().findAll();
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("Application/json");
		resp.getWriter().print(jsonResult);
		
		System.out.println(">> doGet 끝");
	}
}
