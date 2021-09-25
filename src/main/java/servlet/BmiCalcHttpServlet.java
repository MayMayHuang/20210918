package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BmiService;

@WebServlet(value = {"/servlet/bmicalc"})
public class BmiCalcHttpServlet extends HttpServlet {
	
	private BmiService bmiService = new BmiService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//���o�ѼƸ��
		String height = req.getParameter("height");//���o��� height��쪺���,all���String,�n�p��ndouble
		String weight = req.getParameter("weight");//���o��� weight��쪺���
		
		//���o bmi���G
		double bmi = bmiService.getBmi(height, weight);
		//�૬,�Y�t�~���ߤ@��service,�h�U�C���μ��g
		//double h = Double.parseDouble(height);
		//double w = Double.parseDouble(weight);
		//�p��bmi
		//double bmi = w /Math.pow(h/100, 2);
		
		//----------------------------------------------
		//�z�Ljsp����
		//1.�إߤ�����(�ë��wjsp)
		//2.�إ߭n�e���
		//2.�����覡forward, include
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/bmi_result.jsp");
		req.setAttribute("bmi", bmi);//�إߤ@��request�ܼƦW�sbmi�̭���Jbmi���p�⵲�G
		rd.forward(req, resp);//���s�ɦV
		
	}
	
	
	

}
