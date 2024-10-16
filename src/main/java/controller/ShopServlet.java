package controller;
import models.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Servlet implementation class ShopServlet
 */
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Giày Thể Thao", "images/product1.jpg", "Giày thể thao chất lượng cao, bền bỉ.", 1200000));
        products.add(new Product(2, "Bóng Đá", "images/product2.jpg", "Bóng đá tiêu chuẩn FIFA, thích hợp cho mọi sân chơi.", 300000));
        products.add(new Product(3, "Áo Thể Thao", "images/product3.jpg", "Áo thun thể thao thoáng mát, co giãn tốt.", 450000));
        products.add(new Product(4, "Găng Tay Tập Gym", "images/product4.jpg", "Găng tay tập gym giúp bảo vệ tay, tăng cường khả năng bám.", 150000));

        // Đưa danh sách sản phẩm vào request
        request.setAttribute("products", products);

        // Chuyển hướng tới file JSP để hiển thị
        request.getRequestDispatcher("shop.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		int productId = Integer.parseInt(request.getParameter("productId"));
        HttpSession session = request.getSession();
        List<Product> cart = (List<Product>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
        }

        boolean found = false;
        for (Product product : cart) {
            if (product.getId() == productId) {
                product.setQuantity(product.getQuantity() + 1); // Nếu sản phẩm đã có, tăng số lượng
                found = true;
                break;
            }
        }

        if (!found) {
            List<Product> products = new ArrayList<>();
            products.add(new Product(1, "Giày Thể Thao", "images/product1.jpg", "Giày thể thao chất lượng cao, bền bỉ.", 1200000));
            products.add(new Product(2, "Bóng Đá", "images/product2.jpg", "Bóng đá tiêu chuẩn FIFA, thích hợp cho mọi sân chơi.", 300000));
            products.add(new Product(3, "Áo Thể Thao", "images/product3.jpg", "Áo thun thể thao thoáng mát, co giãn tốt.", 450000));
            products.add(new Product(4, "Găng Tay Tập Gym", "images/product4.jpg", "Găng tay tập gym giúp bảo vệ tay, tăng cường khả năng bám.", 150000));
            
            for (Product product : products) {
                if (product.getId() == productId) {
                    cart.add(product); // Nếu sản phẩm chưa có trong giỏ, thêm sản phẩm vào
                    break;
                }
            }
        }

        session.setAttribute("cart", cart);
        response.sendRedirect("cart.jsp");
	}

}
