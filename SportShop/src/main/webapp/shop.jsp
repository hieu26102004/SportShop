<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
	uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop Bán Đồ Thể Thao</title>
	<style>
	    body {
	        font-family: Arial, sans-serif;
	        margin: 0;
	        padding: 0;
	        background-color: #f4f4f4;
	    }
	    header, footer {
	        background-color: #333;
	        color: white;
	        text-align: center;
	        padding: 10px 0;
	    }
	    .container {
	        margin: 20px auto;
	        width: 90%;
	        max-width: 1200px;
	    }
	    .products {
	        display: flex;
	        flex-wrap: wrap;
	        gap: 20px;
	    }
	    .product {
	        background-color: white;
	        border: 1px solid #ddd;
	        padding: 20px;
	        width: 150px;
	        text-align: center;
	        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	    }
	    .product img {
	        max-width: 100%;
	        height: auto;
	    }
	    .product h3 {
	        font-size: 18px;
	        margin: 15px 0;
	    }
	    .product p {
	        color: #777;
	    }
	    .product .price {
	        font-size: 16px;
	        color: #e74c3c;
	        margin: 10px 0;
	    }
	    .product button {
	        background-color: #3498db;
	        color: white;
	        border: none;
	        padding: 10px 15px;
	        cursor: pointer;
	        
	    }
	    .product button:hover {
	        background-color: #2980b9;
	    }
	    .cart-button {
	        margin-top: 20px;
	        text-align: right;
	    }
	    .cart-button button {
	        background-color: #2ecc71;
	        color: white;
	        padding: 10px 20px;
	        border: none;
	        cursor: pointer;
	    }
	    .cart-button button:hover {
	        background-color: #27ae60;
	    }
	</style>
</head>
<body>
<!-- Header -->
    <header>
        <h1>Shop Bán Đồ Thể Thao</h1>
    </header>

    <!-- Main Container -->
    <div class="container">

        <!-- Khu vực hiển thị sản phẩm -->
        <div class="cart-button">
            <button><a href="cart.jsp">Xem Giỏ Hàng</a></button>
        </div>

        <div class="products">
            <!-- Sử dụng foreach để lặp qua các sản phẩm -->
            <c:forEach var="product" items="${products}">
            
  				<form action="shop" method="post">	
			    <div class="product">
			        <h3>${product.name}</h3>
			        <p>${product.description}</p>
			        <div class="price">${product.price} VND
			            <input type="hidden" name="productId" value="${product.id}">
			            <input type="hidden" name="productName" value="${product.name}">
			            <input type="hidden" name="productImage" value="${product.image}">
			            <input type="hidden" name="productDescription" value="${product.description}">
			            <input type="hidden" name="productPrice" value="${product.price}">
                        <input type="hidden" name="productId" value="${product.id}">
                    </div>
                        <button type="submit">Thêm vào giỏ hàng</button>
			    </div>
				</form>
			</c:forEach>

        </div>
    </div>

    <!-- Footer -->
    <footer>
        <p>&copy; 2024 Shop Bán Đồ Thể Thao. All Rights Reserved.</p>
    </footer>
    
</body>
</html>