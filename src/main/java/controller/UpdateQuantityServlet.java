package controller;
import models.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class UpdateQuantityServlet
 */
public class UpdateQuantityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateQuantityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        HttpSession session = request.getSession();
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        session.setAttribute("cart", cart);
        request.getRequestDispatcher("/Views/cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int productId = Integer.parseInt(request.getParameter("productId"));
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        List<Product> cart = (List<Product>) session.getAttribute("cart");

        if (cart != null) {
            for (Product product : cart) {
                if (product.getId() == productId) {
                    if ("increase".equals(action)) {
                        product.setQuantity(product.getQuantity() + 1);
                    } else if ("decrease".equals(action)) {
                        if (product.getQuantity() > 1) {
                            product.setQuantity(product.getQuantity() - 1);
                        } else {
                            cart.remove(product); // Xóa sản phẩm nếu số lượng <= 1
                        }
                    }
                    break; // Dừng khi đã tìm thấy sản phẩm
                }
            }
        }

        session.setAttribute("cart", cart);
        response.sendRedirect("cart.jsp");
	}

}
