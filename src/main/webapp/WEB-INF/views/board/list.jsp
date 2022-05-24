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
              <div class="form-group searchDiv">
                <select class="type">
                  <option value="t" ${listDTO.type =="t"?"selected":""}>제목</option>
                  <option value="c" ${listDTO.type =="c"?"selected":""}>내용</option>
                  <option value="w" ${listDTO.type =="w"?"selected":""}>작성자</option>
                </select>
              </div>
            </div>
            <div class="col-sm-7">
              <div class="input-group" style="width: 150px;">
                <input type="text" name="keyword" class="form-control float-right" placeholder="Search">
                <div class="input-group-append">
                  <button type="submit" class="btn btn-default searchBtn">
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
              <th> </th>
              <th>제목</th>
              <th>닉네임</th>
              <th>등록일</th>
              <th>조회수</th>
              <th>좋아요</th>
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

<form class="actionForm" action="/board/list" method="get">
  <input type="hidden" name="page" value="${listDTO.page}">
  <input type="hidden" name="size" value="${listDTO.size}">
  <input type="hidden" name="type" value="${listDTO.type == null?'':listDTO.type}">
  <input type="hidden" name="keyword" value="${listDTO.keyword == null? '':listDTO.keyword}">
</form>

<script>

    const linkDiv = document.querySelector(".pagination")
    const actionForm = document.querySelector(".actionForm")

    linkDiv.addEventListener("click", (e) => {
        e.stopPropagation()
        e.preventDefault()

        const target = e.target

        if(target.getAttribute("class") !== 'page-link'){
            return
        }

        const pageNum = target.getAttribute("href")
        actionForm.querySelector("input[name='page']").value = pageNum
        actionForm.setAttribute("action","/board/list")
        actionForm.submit()

    },false)

    document.querySelector(".searchBtn").addEventListener("click",(e)=> {
        const type = document.querySelector('.searchDiv .type').value
        const keyword = document.querySelector("input[name='keyword']").value

        console.log(type, keyword)

        actionForm.setAttribute("action","/board/list")
        actionForm.querySelector("input[name='page']").value = 1
        actionForm.querySelector("input[name='type']").value = type
        actionForm.querySelector("input[name='keyword']").value = keyword
        actionForm.submit()

    },false)

</script>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>