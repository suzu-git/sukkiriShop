package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;
import model.RegisterDTO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//"regsiter.jspにフォワード
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
		dispatcher.forward(request, response);
	}
		// TODO Auto-generated method stub
		/*response.getWriter().append("Served at: ").append(request.getContextPath());

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//フォームからパラメータを取り出す
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String mail = request.getParameter("mail");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		try{int number = Integer.parseInt(age);
		
		
		//RegisterDTO を生成
		RegisterDTO dto = new RegisterDTO(userId, pass, mail, name, number);
		//RegisterDAOを生成
		RegisterDAO dao = new RegisterDAO();
		int result = dao.RegisterCustomer(dto);
		
		//INSERT文の成否を判定
		if(result == 0) {
			//失敗したら"registerFailure.jsp"にリダイレクト
			response.sendRedirect("/sukkiriShop/registerFailure.jsp");
		}else {
		//リクエストスコープに"DTOを保存
		request.setAttribute("dto",dto);
		// "registerOK.jsp"にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerOK.jsp");
		dispatcher.forward(request,response);
		
		// TODO Auto-generated method stub
		//doGet(request, response);
	}
	}catch(NumberFormatException e) {
		e.printStackTrace();

}
	}
}
