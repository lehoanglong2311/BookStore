<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : Header
    Created on : Mar 24, 2023, 2:51:54 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--begin of menu-->
<nav class="navbar navbar-expand-md navbar navbar-light" style="background-image: linear-gradient(-225deg, #B7F8DB 0%, #50A7C2 100%);">
    <div class="container">
        <a class="navbar-brand" href="home"> <i class="fa fa-book" aria-hidden="true"></i> BookStore</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">
                <c:if test="${sessionScope.acc.isAdmin==1}">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Manager Account</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.acc.isSell==1}">
                    <li class="nav-item">
                        <a class="nav-link" href="manage">Manager Product</a>
                    </li>
                </c:if>

                <c:if test="${sessionScope.acc!=null}">

                    <li class="nav-item">
                        <a class="btn btn-outline-light nav-link" href="logout">Logout</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Hello ${sessionScope.acc.user}</a>
                    </li> 
                </c:if>
                <c:if test="${sessionScope.acc==null}">
                    <li class="btn btn-outline-light nav-item">
                        <a class="nav-link" href="Login.jsp">Login</a>
                    </li>
                </c:if>

            </ul>

            <form action="search" method="post" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <input value="${hienthiValueSearch}" name="nameSearch" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-info btn-number">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
             
            </form>
        </div>
    </div>
</nav>
<!--<section class="jumbotron text-center">-->
<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img class="d-block w-100" src="http://static.nhanam.com.vn/thumb/0x0/crop/Features/Images/2019/4/25/6HHNAJ7E.jpg" alt="First slide">
        </div>
        <div class="carousel-item">
            <img class="d-block w-100" src="http://static.nhanam.com.vn/thumb/0x0/crop/Features/Images/2018/9/13/OJ4M48Q3.jpg" alt="Second slide">
        </div>
        <div class="carousel-item">
            <img class="d-block w-100" src="http://static.nhanam.com.vn/thumb/0x0/crop/Features/Images/2018/9/13/3XSUDF44.jpg" alt="Third slide">
        </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<!--</section>-->
<!--end of menu-->
