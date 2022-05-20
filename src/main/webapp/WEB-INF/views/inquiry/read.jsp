<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<div class="row">

  <section class="content-header" style="margin-left: 10px; width: 300px;">
    <div class="container-fluid">
      <div class="row mb-2">
        <div class="col-sm-6" style="">
          <ol class="breadcrumb float-sm-right">
            <li class="breadcrumb-item"><a href="/">Home</a></li>
            <li class="breadcrumb-item active"><a href="/inquiry/list?page=${listDTO.page}&size=${listDTO.size}"
                                                  style="color:#3c3b3b;">문의 목록</a></li>
          </ol>
        </div>
      </div>
    </div>
  </section>


  <div class="col-md-12">
    <div class="card card-primary card-outline">
      <div class="card-body" style="display: block;">
        <div class="form-group" style="display: flex">
          <label style="width: 7vw;">제 목</label>
          <c:out value="${dto.title}"></c:out>
          <label style="width: 10vw;  margin-left: 5vw;">아이디</label>
          <c:out value="${dto.id}"></c:out>
          <label style="width: 10vw; margin-left: 5vw;">문의날짜</label>
          <c:out value="${dto.inquiryDate}"></c:out>
        </div>
        <div class="form-group">
          <label for="inputDescription">내용</label>
          <textarea id="inputDescription" class="form-control inputContent" rows="5" readonly><c:out
                  value="${dto.content}"></c:out></textarea>
        </div>
      </div>
    </div>
  </div>

  <div class="col-md-12">
    <div class="card card-info">
      <div class="card-header">
        <h3 class="card-title">관리자 답변</h3>
      </div>

      <%-- 답변 단 경우 --%>
      <c:if test="${dto.answerFlag == 1}">
        <div class="card-body">
          <div class="card card-info card-outline">
            <div class="card-body">
              <div class="flex-shrink-0">${dto.answerId}</div>
              <div class="fw-bold">${dto.answerDate}</div>
            </div>

            <div class="form-group">
              <div class="answerContent" style="margin-left: 20px;">${dto.answerContent}</div>
              <button class="btn bg-gradient-info float-right" style="margin-right: 1em">
                <i class="fas fa-pen"></i>수정
              </button>
            </div>
          </div>

        </div>
      </c:if>

<sec:authorize access="isAuthenticated()">
  <sec:authentication property="principal.nickname" var="nickname"/>

      <%-- 답변 안 단 경우 --%>
      <c:if test="${dto.answerFlag == 0}">
        <form class="form-horizontal" action="/inquiry/read/${dto.inquirySeq}" method="post">
          <input type="hidden" name="inquirySeq" value="${dto.inquirySeq}">
          <input type="hidden" name="answerId" value="${nickname}">
          <div class="card-body">
            <div class="form-group row">
              <label for="recommand" class="col-sm-2 col-form-label">답 변</label>
              <div class="col-sm-10">
                <textarea id="recommand" name="answerContent" class="form-control" rows="5"></textarea>
              </div>
            </div>
          </div>
          <div class="card-footer">
            <button type="submit" class="btn btn-default float-right">댓글 달기</button>
          </div>
        </form>
      </c:if>
</sec:authorize>
    </div>
  </div>


</div>











<%-- Axios --%>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script>


</script>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>