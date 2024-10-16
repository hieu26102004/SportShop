<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" 
	uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giỏ Hàng</title>
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
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 15px;
            text-align: center;
        }
        .cart-button {
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

    <header>
        <h1>Giỏ Hàng Của Bạn</h1>
    </header>

    <div class="container">

        <table>
		    <thead>
		        <tr>
		            <th>Mã sản phẩm</th>
		            <th>Tên</th>
		            <th>Giá</th>
		            <th>Số lượng</th>
		            <th>Hành động</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach var="product" items="${cart}">
		            <tr>
		                <td>${product.id}</td>
		                <td>${product.name}</td>
		                <td>${product.price}</td>
		                <td>${product.quantity}</td>
		                <td>
		                    <form action="cart" method="post" style="display:inline-block;">
		                        <input type="hidden" name="productId" value="${product.id}">
		                        <input type="hidden" name="action" value="increase">
		                        <button type="submit">+</button>
		                    </form>
		                    <form action="cart" method="post" style="display:inline-block;">
		                        <input type="hidden" name="productId" value="${product.id}">
		                        <input type="hidden" name="action" value="decrease">
		                        <button type="submit">-</button>
		                    </form>
		                    <form action="remove" method="post" style="display:inline-block;">
		                        <input type="hidden" name="productId" value="${product.id}">
		                        <button type="submit">Xóa</button>
		                    </form>
		                </td>
		            </tr>
		        </c:forEach>
		    </tbody>
		</table>


        <div class="cart-button">
            <button onclick="alert('Xác nhận mua hàng!')">Xác Nhận Mua Hàng</button>
        </div>

    </div>

    <footer>
    	<a href="shop">Tiếp tục mua sắm</a>
        <p>&copy; 2024 Shop Bán Đồ Thể Thao. All Rights Reserved.</p>
    </footer>

</body>
</html>