package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Coin;
import model.Collection;

/**
 * Servlet implementation class createNewCollectionServlet
 */
@WebServlet("/createNewCollectionServlet")
public class createNewCollectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewCollectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CoinHelper ch = new CoinHelper();
		String name = request.getParameter("name");
		System.out.println("Collection Name: " + name);


		String[] selectedCoins = request.getParameterValues("allCoinsToAdd");
		List<Coin> selectedCoinsInList = new ArrayList<Coin>();
		if (selectedCoins != null && selectedCoins.length > 0) {
			for (int i = 0; i < selectedCoins.length; i++) {
				System.out.println(selectedCoins[i]);
				Coin c = ch.searchForCoinById(Integer.parseInt(selectedCoins[i]));
				selectedCoinsInList.add(c);

			}
		}

		Collection cl = new Collection(name);
		cl.setListOfCoins(selectedCoinsInList);
		CollectionHelper slh = new CollectionHelper();
		slh.insertNewCollection(cl);

		System.out.println("Success!");
		System.out.println(cl.toString());

		getServletContext().getRequestDispatcher("/ViewAllCollectionsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
