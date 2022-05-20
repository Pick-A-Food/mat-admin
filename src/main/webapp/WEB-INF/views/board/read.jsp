<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<section class="content-header">
  <div class="container-fluid">
    <div class="row mb-2">
      <div class="col-sm-6">
        <h1>조회</h1>
      </div>
      <div class="col-sm-6">
        <ol class="breadcrumb float-sm-right">
          <li class="breadcrumb-item"><a href="/">Home</a></li>
          <li class="breadcrumb-item active">조회</li>
        </ol>
      </div>
    </div>
  </div>
</section>

<section class="content">
  <div class="row">
    <div class="col-12">
      <div class="form-group">
        <a href="/board/list" class="btn btn-secondary">목록</a>
      </div>
    </div>
  </div>

  <div class="row">
    <div class="col-md-12">
      <div class="card card-primary card-outline">
        <div class="card-body" style="display: block;">
            <div class="form-group" style="display: flex">
              <label for="inputName" style="width: 10vw;">제목</label>
              <input type="text" id="inputName" name="title" class="for m-control" style="margin-right: 2vw; width: 1800px;"
              value='<c:out value="${board.title}"/>' readonly="readonly">
              <label for="inputName" style="width: 10vw;">닉네임</label>
              <input type="text" name="nickname" class="form-control" value='<c:out value="${board.nickname}"/>' readonly="readonly">
            </div>
            <input type="hidden" value="kim" name="id">
            <div class="form-group board">
              <label for="inputDescription">내용</label>
              <textarea id="inputDescription" name="content" class="form-control" rows="5" readonly="readonly"><c:out value="${board.content}"/></textarea>
            </div>
        </div>
      </div>
    </div>
  </div>
</section>

<section class="content">
  <div class="row">
    <div class="col-md-12">
      <div class="card card-info">
        <div class="card-header">
          <h3 class="card-title">댓글</h3>
        </div>
        <div class="card-body">
          <div class="card card-info card-outline">
            <div class="card-body">
              <p>댓글 냄겼어요 짱짱아아앙아아뽕</p>
            </div>

            <div class="form-group" >
              <button class="btn bg-gradient-info float-right" style="margin-right: 1em">
                <i class="fas fa-pen"></i>수정</button>
            </div>
          </div>

        </div>
        <form class="form-horizontal">
          <div class="card-body">
            <div class="form-group row">
              <label for="recommand" class="col-sm-2 col-form-label">댓글</label>
              <div class="col-sm-10">
                <textarea id="recommand" class="form-control inputContent" rows="5"></textarea>
              </div>
            </div>
          </div>
          <div class="card-footer">
            <button type="submit" class="btn btn-default float-right">댓글 달기</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</section>

</div>

</div>
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

</script>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>