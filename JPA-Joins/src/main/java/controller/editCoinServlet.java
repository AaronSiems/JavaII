package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Coin;

/**
 * Servlet implementation class editCoinServlet
 */
@WebServlet("/editCoinServlet")
public class editCoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editCoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CoinHelper dao = new CoinHelper();
		
		String coin = request.getParameter("coin");
		Integer year = Integer.parseInt(request.getParameter("year"));
		String mint = request.getParameter("mint");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Coin coinToUpdate = dao.searchForCoinById(tempId);
		coinToUpdate.setCoin(coin);
		coinToUpdate.setYear(year);
		coinToUpdate.setMint(mint);
		
		dao.updateCoin(coinToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllCoinsServlet").forward(request, response);
	}

}
