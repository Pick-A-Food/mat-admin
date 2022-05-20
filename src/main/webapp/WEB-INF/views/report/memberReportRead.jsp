<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<link href="/resources/css/table.css" rel="stylesheet" type="text/css">

<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800"></h1>
    <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
</div>
<div class="row">
    <div class="col-lg-9">
        <!-- Post content-->
        <article clss="memberReportOne">
            <!-- Post header-->
            <header class="mb-4">
                <!-- Post title-->
                <h4 class="fw-bolder mb-2" style="padding-bottom: 10px"><span style="color: #3c9a9a; font-size:25px">제&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp목 || </span> <c:out value="${dto.reportCategory}"></c:out></h4>
                <!-- Post meta content-->
                <div class="text-muted fst-italic mb-2" style="font-size:20px"><span style="color: #3c9a9a; font-size:23.3px">신고 회원 || </span><c:out value="${dto.id}"></c:out></div>
                <!-- Post categories-->
                <div align="right">
                    <a class="badge bg-secondary text-decoration-none link-light" style="color: black"><button style="text-decoration: none; border-style: none; background-color:transparent">목록</button></a>
                </div>
            </header>

            <section class="mb-5">
                <div style="font-size:15px"><c:out value="${dto.content}"></c:out></div>
            </section>
            <div class="text-muted fst-italic mb-2" style="font-size:20px"><span style="color: #3c9a9a; font-size:23.3px">신고 날짜 || </span><span class="dateType"><c:out value="${dto.regDate}"></c:out></span></div>

        </article>
        <!-- Comments section-->
        <section class="mb-5">
            <div class="card bg-light">
                <div class="card-body" id="replyArea">
                    <!-- Comment form-->
                    <c:if test="${dto.answerFlag == 1}">
                        <div class="d-flex">
                            <div class="ms-3">
                                <div class="flex-shrink-0">${dto.answerId}</div>
                                <div class="fw-bold">${dto.answerDate}</div>
                                <hr>
                                <ul class="answerContent" style="padding-left:1px">${dto.answerContent}</ul>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${dto.answerFlag == 0}">
                        <form action="/inquiry/read/${dto.inquirySeq}" method="post" >

                            <input type="hidden" name="inquirySeq" value="${dto.inquirySeq}">
                            <textarea class="form-control" rows="2" placeholder="답변 달기" name="answerContent"></textarea>
                            <div align="right" style="padding-top: 5px">
                                <a class="badge bg-secondary text-decoration-none link-light">
                                    <button style="text-decoration: none; border-style:none; color: white; background-color:transparent">등록</button>
                                </a>
                            </div></form>
                    </c:if>

                </div>
            </div>
        </section>
    </div>




</div>



<%-- Axios --%>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script>


</script>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>