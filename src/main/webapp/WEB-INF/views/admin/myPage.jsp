<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<link href="/resources/css/table.css" rel="stylesheet" type="text/css">

<section class="content-header">
    <div class="container-fluid">
        <div class="row mb-2">
            <ol class="breadcrumb float-sm-right">
                <li class="breadcrumb-item"><a href="/">Home</a></li>
                <li class="breadcrumb-item active">정보수정</li>
            </ol>
        </div>
    </div>
</section>

<form class="modifyForm" name="modifyForm" action="/admin/modify" method="post">
<section class="content">
    <div class="row">
        <div class="col-12">
            <div class="form-group" style="margin-bottom: 10px">
                <button class="btn btn-success float-right modifyBtn" type="submit" style="padding-bottom: 10px; margin-right: 10vw"><i class="fa fa-plus"></i>수정</button>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12" style="margin-top: 20px; padding-left: 10vw; padding-right: 10vw">
            <div class="card card-primary card-outline">
<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal.profile" var="profile" />
    <sec:authentication property="principal.name" var="name" />
    <sec:authentication property="principal.position" var="position" />
    <sec:authentication property="principal.nickname" var="nickname" />
    <sec:authentication property="principal.adminSeq" var="adminSeq" />

    <input type="hidden" name="adminSeq" value="${adminSeq}">

        <div class="card-body" style="display: block;">
            <p><c:out value="${position} | ${name}"></c:out> 님</p>
            <p style="width: 20vw; ">닉네임 <input type="text"
                                               class="nickname" name="nickname"
                                               value="${nickname}" style="width: 50vw">
            </p>
            <p style="width: 20vw; ">프로필(URL)
                <input type="text" class="profile" name="profile" value="${profile}" style="width: 50vw">
            <div class="profileImage"><img src="${profile}" style="max-height: 100px"></div>
            </p>
           <%-- <p style="width: 20vw; ">비밀번호
                <input type="password" class="pwMod" name="pw" style="width: 50vw">
            </p>
            <p style="width: 20vw; ">비번확인
                <input type="password" class="pwCheck" name="pwCheck" style="width: 50vw"></p>--%>
        </div>
    </form>
</sec:authorize>

            </div>
        </div>

    </div>
</section>


<%-- Axios --%>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script>


</script>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>