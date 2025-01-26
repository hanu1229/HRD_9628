package management;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/management/sales")
public class SalesController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> Sales doGet 실행");
		
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<SalesDto> result = ManagementDao.getInstance().salesAll();
		System.out.println(">> " + result);
		String jsonResult = mapper.writeValueAsString(result);
		System.out.println(">> jsonResult : " + jsonResult);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
		
		System.out.println(">> sales doGet 끝");
	}
	
}
