package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Collection;

/**
 * Servlet implementation class collectionNavServlet
 */
@WebServlet("/collectionNavServlet")
public class collectionNavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public collectionNavServlet() {
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
String act = request.getParameter("doThisToItem");
		
		CollectionHelper ch = new CollectionHelper();
		
		if(act == null) {
			getServletContext().getRequestDispatcher("/ViewAllCollectionsServlet").forward(request, response);
		} else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Collection collectionToDelete = ch.searchForCollectionById(tempId);
				ch.deleteCollection(collectionToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/ViewAllCollectionsServlet").forward(request, response);
			}
			
			//todo vvvvvv
		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Collection coinToEdit = ch.searchForCollectionById(tempId);
				request.setAttribute("coinToEdit", coinToEdit);
				getServletContext().getRequestDispatcher("/edit-coin.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/ViewAllCollectionsServlet").forward(request, response);
			}
			//todo^^^^^^
		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/addCoinsForCollectionServlet").forward(request, response);
		}
	}

}
