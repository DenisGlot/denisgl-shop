<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var = "contextRoot" value = "${pageContext.request.contextPath}"/>
<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images  " value="/resources/images"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="An example of e-shop which made by Denis Glotov">
    <meta name="author" content="Denis Glotov">

    <title>${title}</title>

    <script>
        window.menu = '${jsActiveMenu}';
    </script>

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${css}/shop-homepage.css" rel="stylesheet">
    <!--Bootstrap theme-->
    <link href="${css}/bootstrap-theme.css" rel="stylesheet">

</head>

<body>
    <div class="wrapper">

        <!-- Navigation -->
        <%@include file="shared/navbar.jsp"%>

        <!-- Page Content -->
        <div class="content">
            <c:if test="${userClickHome}">
                <%@include file="home.jsp"%>
            </c:if>

            <c:if test="${userClickAbout}">
                <%@include file="about.jsp"%>
            </c:if>

            <c:if test="${userClickContact}">
                <%@include file="contact.jsp"%>
            </c:if>
            <c:if test="${userClickListProducts}">
                <%@include file="listProducts.jsp"%>
            </c:if>
        </div>
        <!-- Footer -->
        <%@include file="shared/footer.jsp"%>

        <!-- Bootstrap core JavaScript -->
        <script src="${js}/jquery.min.js"></script>
        <script src="${js}/shop.js"></script>
        <script src="${js}/bootstrap.bundle.min.js"></script>

    </div>
</body>

</html>