package servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/servlet/circlecalc")
public class CircleCalcHttpServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/circle_form.jsp");
		rd.forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String radius = req.getParameter("radius");
		String[] items = req.getParameterValues("item");
		System.out.println("radius:" + radius);
		System.out.println("items:" + Arrays.toString(items));
		
		double r = Double.parseDouble(radius);
		StringBuilder result = new StringBuilder();
		for(String item : items) {
			switch (item) {
			case "A":
				System.out.println("���|:" + (2*r));
				result.append("���|:" + (2*r)).append("br />");
				break;
			case "B":
				System.out.println("��P:" + ((2*r) * Math.PI));
				result.append("��P:" + ((2*r) * Math.PI)).append("br />");
				break;	
			case "C":
				System.out.println("���n:" + (Math.PI * Math.pow(r, 2)));
				result.append("���n:" + (Math.PI * Math.pow(r, 2))).append("br />");
				break;
			case "D":
				System.out.println("��n:" + (4.0/3 *Math.PI * Math.pow(r,3)));
				result.append("��n:" + (4.0/3 *Math.PI * Math.pow(r,3))).append("br />");
				break;	

			}
		}
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/circle_result.jsp");
		req.setAttribute("result", result);
		rd.forward(req, resp);
	}

	
}
