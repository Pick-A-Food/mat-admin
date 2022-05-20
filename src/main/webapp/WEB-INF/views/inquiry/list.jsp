<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<link href="/resources/css/table.css" rel="stylesheet" type="text/css">

<div class="content-header">
  <div class="container-fluid">
    <div class="row mb-2">
      <div class="col-sm-6" style="margin-top: 1vw">
        <h1 class="m-0">회원 문의 게시판</h1>
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
    <a href="/inquiry/list?type=n" class="nav-link">미답변 문의만 보기</a>

    <div class="row">
      <div class="col-12">
        <div class="card card-primary card-outline">
          <div class="card-header">

           <%--
           검색
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
            </div>--%>

            <div class="row float-right">
              <button type="button" class="btn btn-primary btn-block btn-sm">
                <i class="fa fa-plus"></i>등록
              </button>
            </div>
          </div>

          <div class="card-body table-responsive p-0">
            <table class="table table-hover text-nowrap">
              <thead>
              <tr>
                <th>#</th>
                <th>문의일</th>
                <th>제목</th>
                <th>사용자</th>
                <th>답변일</th>
                <th>담당자</th>
              </tr>
              </thead>
              <tbody class="inquiryList">
              <c:forEach items="${dtoList}" var="inquiry">
                <tr>
                  <th scope="row">${inquiry.inquirySeq}</th>
                  <td class="dateType"><c:out value="${inquiry.inquiryDate}"/></td>
                  <td style="text-align: left;"><span><a href='/inquiry/read/${inquiry.inquirySeq}' class="dtoLink"><c:out value="${inquiry.title}"/></a></span></td>
                  <td><c:out value="${inquiry.id}"/></td>
                  <td class="dateType">
                    <c:choose>
                      <c:when test="${inquiry.answerId eq null}">
                        <span style="color:blue">답변대기</span>
                      </c:when>
                      <c:otherwise>
                        <span style="color:cadetblue">${inquiry.answerDate}</span>
                      </c:otherwise>
                    </c:choose>

                  </td>
                  <td><c:out value="${inquiry.answerId}"/></td>
                </tr>
              </c:forEach>
              </tbody>
            </table>
          </div>
          <div class="pagingArea">
            <nav aria-label="Page navigation example">
              <ul class="pagination" style="margin-top: 10px">
                <c:if test="${pageMaker.start > 1}">
                  <li class="page-item"><a class="page-link" href="${pageMaker.start-1}">이전</a></li>
                </c:if>
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

                <c:if test="${pageMaker.end < total/listDTO.size}">
                  <li class="page-item"><a class="page-link" href="${pageMaker.end+1}">다음</a></li>
                </c:if>
              </ul>
            </nav>
          </div>
        </div>

      </div>
    </div>
  </div>
</div>

<form class="actionForm" action="/inquiry/list" method="get">
  <input type="hidden" name="page" value="${listDTO.page}">
  <input type="hidden" name="size" value="${listDTO.size}">
  <input type="hidden" name="type" value="${listDTO.type == null ? '':listDTO.type}">
  <input type="hidden" name="keyword" value="${listDTO.keyword == null ? '' : listDTO.keyword}">
</form>

<script>
  const inquiryList = document.querySelector(".inquiryList");

  const dateStyle = inquiryList.querySelectorAll(".dateType");
  dateStyle.forEach(dateType => {
    const dateText = dateType.innerHTML;
    dateType.innerHTML = dateText.split('T')[0];
  });

  const linkDiv = document.querySelector(".pagination")
  const actionForm = document.querySelector(".actionForm")

  document.querySelector(".inquiryList").addEventListener("click", (e) => {
    e.preventDefault()
    e.stopPropagation()

    const target = e.target
    if(target.getAttribute("class").indexOf('dtoLink') < 0 ){
      return                  // class 는 이름이 길어질 수 있으므로 indexOf 그 안에 dtoLink가 있는 지 확인 하는 방식으로 가야함.
    }
    const url = target.getAttribute("href")

    actionForm.setAttribute("action", url)
    actionForm.submit()
  }, false)


  linkDiv.addEventListener("click", (e) => {
    e.stopPropagation()
    e.preventDefault()

    const target = e.target

    if(target.getAttribute("class") !== 'page-link'){ //page 링크가 아니면 끝내기
      return
    }
    const pageNum = target.getAttribute("href")
    actionForm.querySelector("input[name='page']").value = pageNum
    actionForm.setAttribute("action","/inquiry/list")
    actionForm.submit();

  }, false)
  // ↑ 버블링 ok 캡쳐링은 false

</script>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>