package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;



public class CycleServlet extends GenericServlet {
    //point BmiServlet,有2個選項,選add....
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=utf-8");//文件格式要記住
		//1.接收資料../servlet/bmi?h=170&w=60
		String radiu = req.getParameter("r");
		PrintWriter out = res.getWriter();
		if(radiu == null) {
			out.print("Please input r !");
		} else {
			double r = Double.parseDouble(radiu);
			double area = Math.PI * Math.pow(r, 2);
			double volume = 4.0/3 * Math.PI * Math.pow(r, 3);
			String result = String.format("area=%.2f volumn=%.2f", area, volume);
			out.print(result);
			
		}
		
		
	}
	
}