<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 12/11/2023
  Time: 9:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="offset-1"></div>
        <div class="col-11">
            <form class="form-inline my-2 my-lg-0" action="/students?action=seach" method="post">
                <input class="form-control mr-sm-2" type="search" name="seach" placeholder="Nhập ID Học Sinh "
                       aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
            <h1>Danh Sách Học Sinh</h1>
            <button type="button" class="btn btn-light"><a href="/students?action=create">Thêm Mới</a></button>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Tên Học Sinh</th>
                    <th scope="col">Tuổi</th>
                    <th scope="col">Giới Tính</th>
                    <th scope="col">Địa Chỉ</th>
                    <th scope="col">Điểm Trung Bình</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <c:forEach items='${danhSach}' var="student">
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.name}</td>
                        <td>${student.age}</td>
                        <td>${student.sex}</td>
                        <td>${student.address}</td>
                        <td>${student.score}</td>
                        <td>
                            <button type="button" class="btn btn-light"><a
                                    href="/students?action=edit&id=${student.id}">Sửa</a>
                            </button>
                        </td>
                        <td>
                            <button type="button" class="btn btn-light"><a
                                    href="/students?action=delete&id=${student.id}">Xóa</a>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <button type="button" class="btn btn-light"><a href="http://localhost:8080/students">Quay Lại</a></button>
        </div>
    </div>
</div>
</body>
</html>