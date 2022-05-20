<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<link href="/resources/css/table.css" rel="stylesheet" type="text/css">

<div class="content-header">
    <div class="container-fluid">
        <div class="row mb-2">
            <div class="col-sm-6" style="margin-top: 1vw">
                <h1 class="m-0">자유 게시판</h1>
            </div>
            <div class="col-sm-6">
                <ol class="breadcrumb float-sm-right">
                    <li class="breadcrumb-item"><a href="/">Home</a></li>
                    <li class="breadcrumb-item active">문의 게시판</li>
                </ol>
            </div>
        </div>
    </div>
</div>

<div class="container-fluid">
  <div class="row">
    <div class="col-12">
      <div class="card card-primary card-outline">
        <div class="card-header">
          <div class="row float-left">
            <div class="col-sm-5">
              <div class="form-group">
                <select class="form-control">
                  <option>option 1</option>
                  <option>option 2</option>
                  <option>option 3</option>
                  <option>option 4</option>
                  <option>option 5</option>
                </select>
              </div>
            </div>
            <div class="col-sm-7">
              <div class="input-group" style="width: 150px;">
                <input type="text" name="table_search" class="form-control float-right" placeholder="Search">
                <div class="input-group-append">
                  <button type="submit" class="btn btn-default">
                    <i class="fas fa-search"></i>
                  </button>
                </div>
              </div>
            </div>
          </div>
          <div class="row float-right">
            <button type="button" class="btn btn-primary btn-block btn-sm" onclick="location.href='/board/register/';">
              <i class="fa fa-plus"></i>등록
            </button>
          </div>
        </div>

        <div class="card-body table-responsive p-0">
          <table class="table table-hover text-nowrap">
            <thead>
            <tr>
              <th>Num</th>
              <th>Title</th>
              <th>NickName</th>
              <th>regDate</th>
              <th>Views</th>
              <th>Like</th>
            </tr>
            </thead>
            <tbody> <%-- 내용 forEach로 감싸기 --%>

            <c:forEach items="${boardList}" var="board">
            <tr>
              <td><c:out value="${board.boardSeq}"/></td>
              <td><a href="/board/read/${board.boardSeq}"><c:out value="${board.title}"/></a></td>
              <td><c:out value="${board.nickname}"/></td>
              <td><c:out value="${board.regDate}"/></td>
              <td><c:out value="${board.viewsCount}"/></td>
              <td><c:out value="${board.likeCount}"/></td>
            </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
        <div class="card-footer clearfix">
          <ul class="pagination pagination-sm m-0 float-right">
            <li class="page-item"><a class="page-link" href="#">«</a></li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#">»</a></li>
          </ul>
        </div>

      </div>
    </div>
  </div>
</div>
<script>

</script>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>