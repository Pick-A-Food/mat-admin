<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<link href="/resources/css/table.css" rel="stylesheet" type="text/css">
<style>
    .box {
        width: 850px;
        white-space: nowrap;
        overflow: hidden;
        display: block;
        text-overflow:ellipsis;
    }
</style>
<div class="content-header">
    <div class="container-fluid">
        <div class="row mb-2">
            <div class="col-sm-6" style="margin-top: 1vw">
                <h1></h1>
            </div>
            <div class="col-sm-6">
                <ol class="breadcrumb float-sm-right">
                    <li class="breadcrumb-item"><a href="/">Home</a></li>
                    <li class="breadcrumb-item active" onclick="location.href='/food/main'" style="cursor: pointer">알레르기 지식창고</li>
                </ol>
            </div>
        </div>
    </div>
</div>

<div class="container-fluid">
    카테고리 들어갈 곳
    <hr>
    검색, 체크박스
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
                </div>
            <div class="row row-cols-1 row-cols-md-4 g-4">
                <c:forEach items="${companyList}" var="company">
                <div class="col" style="text-align: center; margin-bottom: 10px">
                    <a href="/food/list?type=${company.cateNum}">
                    <div class="card h-100" style="margin-bottom: 10px; max-height: 100vw; width: auto; display: flex; justify-content:center; align-items: center;">
                        <img src="${company.image}" class="card-img-top" alt="${company.name}" style="max-height: 10vw; width: 15vw">
                    </div>
                    </a>
                </div>
                </c:forEach>
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

<form class="actionForm" action="/food/main" method="get">
    <input type="hidden" name="page" value="${listDTO.page}">
    <input type="hidden" name="size" value="${listDTO.size}">
    <input type="hidden" name="type" value="${listDTO.type == null ? '':listDTO.type}">
    <input type="hidden" name="keyword" value="${listDTO.keyword == null ? '' : listDTO.keyword}">
</form>

<script>

    const foodList = document.querySelector(".foodList");

    const linkDiv = document.querySelector(".pagination")
    const actionForm = document.querySelector(".actionForm")


    linkDiv.addEventListener("click", (e) => {
        e.stopPropagation()
        e.preventDefault()

        const target = e.target

        if(target.getAttribute("class") !== 'page-link'){ //page 링크가 아니면 끝내기
            return
        }
        const pageNum = target.getAttribute("href")
        actionForm.querySelector("input[name='page']").value = pageNum
        actionForm.setAttribute("action","/food/list")
        actionForm.submit();

    }, false)
    // ↑ 버블링 ok 캡쳐링은 false

    foodList.addEventListener("click", (e) => {
        const target = e.target.closest("div");
        if (target.className !== "ingredients") {
            return;
        }

        const boxShort = target.querySelector(".box");
        const boxLong = target.querySelector(".show-box");

        boxShort.classList.toggle("hidden")
        boxLong.classList.toggle("hidden")

    }, false)

</script>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>