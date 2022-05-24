<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Pick A Food</title>
  <!-- Favicon-->
  <link rel="icon" type="image/x-icon" href="http://106.241.252.54:8085/img/icon/pickafood.ico" />
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  
  <link rel="stylesheet" href="https://adminlte.io/themes/v3/plugins/fontawesome-free/css/all.min.css">
  
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">

  <link rel="stylesheet" href="https://adminlte.io/themes/v3/dist/css/adminlte.min.css?v=3.2.0">
  
  <script src="http://106.241.252.54:8085/vendor/jquery/jquery.min.js"></script>
  
  <script src="http://106.241.252.54:8085/vendor/jquery/jquery-ui.min.js"></script>
  <script src="https://adminlte.io/themes/v3/dist/js/adminlte.js?v=3.2.0"></script>
  <script src="http://106.241.252.54:8085/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <body class="hold-transition sidebar-mini layout-fixed">
    <div class="wrapper">
      
      <div class="preloader flex-column justify-content-center align-items-center">
        <img class="animation__shake" src="http://106.241.252.54:8085/img/icon/icon_thumbnail.png" alt="AdminLTELogo" height="60" width="60">
      </div>
      
      <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
          </li>
        </ul>
      <sec:authorize access="isAuthenticated()">
        <sec:authentication property="principal.profile" var="profile" />
        <sec:authentication property="principal.name" var="name" />
    
        <ul class="navbar-nav ml-auto">
          <li class="nav-item dropdown user user-menu">
            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">${name} 관리자님 &nbsp;
              <img class="user-image img-circle elevation-2" src="${profile}">
              <%-- http://106.241.252.54:8085/img/undraw_profile.svg --%>
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="/admin/myPage">정보수정</a>
              <a class="dropdown-item" href="/logout">Logout</a>
            </div>
          </li>
        </ul>
      </sec:authorize>
      </nav>
      <%@ include file="/WEB-INF/views/includes/sidebar.jsp"%>
      <div class="content-wrapper">

