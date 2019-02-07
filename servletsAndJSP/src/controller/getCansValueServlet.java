package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CansToCoins;

/**
 * Servlet implementation class getCansValueServlet
 */
@WebServlet("/getCansValueServlet")
public class getCansValueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getCansValueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String cans = request.getParameter("cans");
		
		CansToCoins amount = new CansToCoins(Integer.parseInt(cans));
		
		request.setAttribute("userAmount", amount);
		getServletContext().getRequestDispatcher("/CansResult.jsp").forward(request, response);
	}

}
