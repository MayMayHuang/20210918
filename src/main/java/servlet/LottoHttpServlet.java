package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/servlet/lotto"})
public class LottoHttpServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//�ѨM������D,�s�Xutf-8
		req.setCharacterEncoding("UTF-8");//�ШD���s�X
		resp.setCharacterEncoding("UTF-8");//�^�����s�X
		resp.setContentType("text/html;charset=UTF-8");//���s��
		
		//539�ֳz: 1~39 �������X5 �Ӥ����ƪ��Ʀr
		Set<Integer> nums = new LinkedHashSet<>();
		Random r = new Random();
		while(nums.size()< 5) {
			nums.add(r.nextInt(39) + 1);
		}
		PrintWriter out = resp.getWriter();
		out.println("539�ֳz:"+ nums);
	}
	
}
