<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%--<link href="/resources/css/inquiry.css" rel="stylesheet" type="text/css">--%>

<div class="d-sm-flex align-items-center justify-content-between mb-4">
  <h1 class="h3 mb-0 text-gray-800">회원 정보</h1>
</div>
<div class="row">
  <table class="table table-hover">
    <thead>
    <tr style="background-color: #e9f2ec">
      <th scope="col" style="width: 14vw">id</th>
      <th scope="col" style="width: 30vw; text-align: left;">pw</th>
      <th scope="col" style="width: 14vw">nick name</th>
    </tr>
    </thead>
    <tbody class="memberList">
    <c:forEach items="${memberDTOList}" var="member">
      <tr>
        <th scope="row">${member.id}</th>
        <td class="dateType">${member.pw}</td>
        <td style="text-align: left; background-color:#f2f7f4;">${member.nickname}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  <div class="pagingArea">
    <nav aria-label="Page navigation example">
      <ul class="pagination">
        <li class="page-item"><a class="page-link" href="${pageMaker.start-1}">이전</a></li>
        <c:forEach begin="${pageMaker.start}" end ="${pageMaker.end}" var="num">

          <c:choose>
            <c:when test="${num eq listDTO.page}">
              <li class="page-item active" aria-current="page"><a class="page-link" href="${num}">${num}</a></li>
            </c:when>
            <c:otherwise>
              <li class="page-item"><a class="page-link" href="${num}">${num}</a></li>
            </c:otherwise>
          </c:choose>

        </c:forEach>
        <li class="page-item"><a class="page-link" href="${pageMaker.end+1}">다음</a></li>
      </ul>
    </nav>
  </div>
</div>

<form class="actionForm" action="/board/list" method="get">
  <input type="hidden" name="page" value="${listDTO.page}">
  <input type="hidden" name="size" value="${listDTO.size}">
  <input type="hidden" name="type" value="${listDTO.type == null ? '':listDTO.type}">
  <input type="hidden" name="keyword" value="${listDTO.keyword == null ? '' : listDTO.keyword}">
</form>



<%@ include file="/WEB-INF/views/includes/footer.jsp"%>