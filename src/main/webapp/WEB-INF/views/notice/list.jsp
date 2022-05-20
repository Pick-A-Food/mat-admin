<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<link href="/resources/css/table.css" rel="stylesheet" type="text/css">

<div class="content-header">
    <div class="container-fluid">
        <div class="row mb-2">
            <div class="col-sm-6" style="margin-top: 1vw">
                <h1 class="m-0">공지사항</h1>
            </div>
            <div class="col-sm-6">
                <ol class="breadcrumb float-sm-right">
                    <li class="breadcrumb-item"><a href="/">Home</a></li>
                    <li class="breadcrumb-item active">공지사항</li>
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
                        <button type="button" class="btn btn-primary btn-block btn-sm" onclick="location.href='/notice/register'">
                            <i class="fa fa-plus"></i>등록
                        </button>
                    </div>
                </div>

                <div class="card-body table-responsive p-0">
                    <table class="table table-hover text-nowrap">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th></th>
                            <th>제목</th>
                            <th>닉네임</th>
                            <th>작성일</th>
                            <th>조회수</th>
                            <th>좋아요</th>
                        </tr>
                        </thead>
                        <tbody class="boardList">
                        <c:forEach items="${dtoList}" var="board">
                            <tr>
                                <th scope="row">${board.boardSeq}</th>

                                <c:choose>
                                    <c:when test="${board.mainImage eq null}">
                                        <td></td>
                                    </c:when>
                                    <c:otherwise>
                                        <td style="padding: 4px"><img src='${board.mainImage}' style="max-height: 40px;"></td>
                                    </c:otherwise>
                                </c:choose>

                                <td style="text-align: left;"><span><a href='/notice/read/${board.boardSeq}' class="dtoLink" style="color:darkblue"><c:out value="${board.title}"></c:out><c:if test="${board.replyCount != 0}">
                                    <span style="color:black"><c:out value=" [${board.replyCount}]"/></span></c:if></a></span></td>
                                <td><c:out value="${board.nickname}"></c:out></td>

                                <c:choose>
                                    <c:when test="${board.date < 1}">
                                        <td class="dateType">방금전</td>
                                    </c:when>
                                    <c:when test="${board.date < 60}">
                                        <td class="dateType">${board.date}분전</td>
                                    </c:when>
                                    <c:when test="${board.date <= 60*24}">
                                        <td class="dateType">${Integer.valueOf(Math.floor(board.date/60))}시간 전</td>
                                    </c:when>
                                    <c:when test="${board.date <= 60*24*7}">
                                        <td class="dateType">${Integer.valueOf(Math.floor(board.date/1440))}일 전</td>
                                    </c:when>
                                    <c:when test="${board.date > 60*24}">
                                        <td class="dateType">${board.regDate}</td>
                                    </c:when>
                                </c:choose>

                                <td>${board.viewsCount}</td>
                                <td>${board.likeCount}</td>
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

<form class="actionForm" action="/notice/list" method="get">
    <input type="hidden" name="page" value="${listDTO.page}">
    <input type="hidden" name="size" value="${listDTO.size}">
    <input type="hidden" name="type" value="${listDTO.type == null ? '':listDTO.type}">
    <input type="hidden" name="keyword" value="${listDTO.keyword == null ? '' : listDTO.keyword}">
</form>

<script>
    const boardList = document.querySelector(".boardList");
    const actionForm = document.querySelector(".actionForm")

    document.querySelector(".boardList").addEventListener("click", (e) => {
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



    /* 페이지 넘김 */
    const pageDiv = document.querySelector(".pagination")

    pageDiv.addEventListener("click", (e) => {
        e.stopPropagation()
        e.preventDefault()

        const target = e.target

        if(target.getAttribute("class") !== 'page-link'){ //page 링크가 아니면 끝내기
            return
        }
        const pageNum = target.getAttribute("href")
        actionForm.querySelector("input[name='page']").value = pageNum
        actionForm.setAttribute("action","/notice/list")
        actionForm.submit();

    }, false)

</script>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>