<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<section class="content-header">
  <div class="container-fluid">
    <div class="row mb-2">
      <div class="col-sm-6">
        <h1>수정</h1>
      </div>
      <div class="col-sm-6">
        <ol class="breadcrumb float-sm-right">
          <li class="breadcrumb-item"><a href="/">Home</a></li>
          <li class="breadcrumb-item active">수정</li>
        </ol>
      </div>
    </div>
  </div>
</section>

<section class="content">
  <div class="row">
    <div class="col-12">
      <div class="form-group">
        <a href="/board/read/{boardSeq}" class="btn btn-secondary">수정 취소</a>
        <button class="btn btn-success float-right modBtn"><i class="fa fa-plus"></i>수정 완료</button>
      </div>
    </div>
  </div>

  <div class="row">
    <div class="col-md-12">
      <div class="card card-primary card-outline">
        <div class="card-body" style="display: block;">

          <form class="board" action="/board/modify/${board.boardSeq}" method="post">
            <input type="hidden" name="page" value="${listDTO.page}">
            <input type="hidden" name="size" value="${listDTO.size}">
            <input type="hidden" name="type" value="${listDTO.type}">
            <input type="hidden" name="keyword" value="${listDTO.keyword}">
            <div class="form-group" style="display: flex">
              <label for="inputName" style="width: 10vw; ">제목</label>
              <input type="text" id="inputName" name="title" class="for m-control" style="margin-right: 2vw; width: 1800px;"
              value="<c:out value="${board.title}"/>">
              <label for="inputName" style="width: 10vw;">닉네임</label>
              <input type="text" value="연느짱" name="nickname" class="form-control">
            </div>
            <input type="hidden" value="kim" name="id">
            <div class="form-group board">
              <label for="inputDescription">내용</label>
              <textarea id="inputDescription" name="content" class="form-control" rows="5"> <c:out value="${board.content}"/> </textarea>
            </div>
          </form>
        </div>
      </div>
    </div>
    <form class="removeForm card-body" action="/board/remove/${boardSeq}" method="post">
    <div class="form-group">
      <button class="btn bg-gradient-info float-right removeBtn">
        <i class="fa-file-image-o"></i>삭제</button>
    </div>
    </form>
    <div class="col-md-12">
      <div class="card card-primary card-outline">
        <div class="card-header">
          <h3 class="card-title">첨부파일</h3>
        </div>
        <div class="card-body" style="display: block;">
          <div>
            <ul class="file-list">
              <li>
                <input type="file"/>
              </li>
            </ul>
          </div>
          <div class="form-group">
            <button class="btn bg-gradient-info float-right file-add">
              <i class="fa-file-image-o"></i>파일 추가</button>
          </div>
        </div>
      </div>
    </div>
  </div>

</section>

<style>
    .file-list {
        list-style: none;
    }
</style>

<script type="text/javascript">
    document.querySelector(".file-add").addEventListener("click",(e) =>{
        console.log("123")
        const fileInput = document.querySelector(".file-list");
        //
        fileInput.innerHTML += "<li><input type='file'></li>";
    },false);

    // 삭제
    <%-- function sQuery(expression){--%>

    <%--     return document.querySelector(expression)--%>
    <%-- }--%>

    <%--const removeForm = sQuery(".removeForm")--%>

    <%--sQuery(".removeBtn").addEventListener("click",(e)=> {--%>
    <%--    removeForm.setAttribute("remove", `/board/remove/${board.boardSeq}`)--%>
    <%--    removeForm.submit()--%>
    <%--}, false)--%>

    document.querySelector(".removeBtn").addEventListener("click", (e) => {
        e.preventDefault()
        e.stopPropagation()

        const removeForm = document.querySelector(".removeForm")
        removeForm.setAttribute("action", `/board/remove/${board.boardSeq}`)
        removeForm.submit()

    },false)


        // 수정
    document.querySelector(".modBtn").addEventListener("click", (e) => {
        e.preventDefault()
        e.stopPropagation()

        const actionForm = document.querySelector(".board")
        actionForm.submit()

    },false)

</script>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>