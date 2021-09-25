package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Drink;
import service.DrinkService;

@WebServlet(value = "/servlet/drink")
public class DrinkHttpServlet extends HttpServlet {
	
	private DrinkService drinkService = new DrinkService();
	
	// �q����ӦC��
	private List<Map> list = new ArrayList<>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String deleteRowId = req.getParameter("deleteRowId");
		if(deleteRowId != null) {
			// �i��R��B�z
			// ���o�渹
			int index = Integer.parseInt(deleteRowId);
			// �o��ӵ��w��
			Map item = list.get(index);
			// �^�u�w�s
			int id = Integer.parseInt(item.get("id").toString());
			int amount = Integer.parseInt(item.get("amount").toString());		
			drinkService.updateStock(id, amount * -1);
			// �����q��
			list.remove(index);
		}
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/drink_form.jsp");
		req.setAttribute("list", list);
		req.setAttribute("drinks", drinkService.queryAll());
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Integer amount = Integer.parseInt(req.getParameter("amount"));
		
		// �ھ� id ���o drink ����
		Drink drink = drinkService.getDrink(id);
		// map �̭��s�񪺴N�O�n��ܪ��q�����
		Map map = new LinkedHashMap<>();
		map.put("id", id);
		map.put("name", drink.getName());
		map.put("amount", amount);
		map.put("subtotal", amount * drink.getPrice());
		// �w�s�ˬd/��s
		boolean check = drinkService.updateStock(id, amount);
		if(check) {
			map.put("memo", "�q�ʦ��\");
			map.put("flag", "true");
		} else {
			map.put("memo", "�w�s����");
			map.put("flag", "false");
		}
		// �[�J��q����ӦC��
		list.add(map);
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/drink_form.jsp");
		req.setAttribute("list", list);
		req.setAttribute("drinks", drinkService.queryAll());
		rd.forward(req, resp);
	}
	
}