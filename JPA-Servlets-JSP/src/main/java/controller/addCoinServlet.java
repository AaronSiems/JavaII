package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Coin;

/**
 * Servlet implementation class addCoinServlet
 */
@WebServlet("/addCoinServlet")
public class addCoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public addCoinServlet() {
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String coin = request.getParameter("coin");
		Integer year = Integer.parseInt(request.getParameter("year"));
		String mint = request.getParameter("mint");
		
		Coin coinToAdd = new Coin(coin, year, mint);
		CoinHelper dao = new CoinHelper();
		dao.addCoin(coinToAdd);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request,  response);
	}

}
