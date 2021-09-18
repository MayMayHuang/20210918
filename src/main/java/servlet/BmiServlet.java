package servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class BmiServlet extends GenericServlet {
    //point BmiServlet,��2�ӿﶵ,��add....
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=utf-8");
		//1.�������../servlet/bmi?h=170&w=60
		String height = req.getParameter("h");
		String weight = req.getParameter("w");
		//2.�B�z�P�p��
		double h = Double.parseDouble(height);
		double w = Double.parseDouble(weight);
		double bmi = w / Math.pow(h/100, 2);
		//�^�����
		res.getWriter().print("BMI =" + bmi);
	}
	
}