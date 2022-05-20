<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/includes/header.jsp"%>

    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>등록</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="/">Home</a></li>
              <li class="breadcrumb-item active">등록</li>
            </ol>
          </div>
        </div>
      </div>
    </section>
    
    <section class="content">
      <div class="row">
        <div class="col-12">
          <div class="form-group">
            <a href="/board/list" class="btn btn-secondary">취소</a>
            <button data-toggle="modal"  data-target="#modal-testNew" class="btn btn-success float-right sendBtn">
              <i class="fa fa-plus"></i>저장
            </button>
          </div>
          <div id="modal-testNew" class="modal" tabindex="-1" role="dialog" aria-labelledby="테스트정보 등록" aria-describedby="테스트 모달">
            <div class="modal-dialog">
              <div class="modal-content">
              
              </div>
            </div>
          </div>
        </div>
      </div>
      

      <div class="row">
        <div class="col-md-12">
          <div class="card card-primary card-outline">
            <div class="card-body" style="display: block;">

              <form class="board" action="/board/register" method="post">
              <div class="form-group" style="display: flex">
                <label for="inputName" style="width: 10vw; ">제목</label>
                <input type="text" id="inputName" name="title" class="for m-control" style="margin-right: 2vw; width: 1800px;">
                <label for="inputName" style="width: 10vw;">닉네임</label>
                <input type="text" value="연느짱" name="nickname" class="form-control">
              </div>
                <input type="hidden" value="kim" name="id">
              <div class="form-group board">
                <label for="inputDescription">내용</label>
                <textarea id="inputDescription" name="content" class="form-control" rows="5"></textarea>
              </div>
              </form>
            </div>
          </div>
        </div>
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
<script src="/resources/js/modal.js"></script>
<script type="text/javascript">
  document.querySelector(".file-add").addEventListener("click",(e) =>{
    console.log("123")
   // const filePath = document.querySelector("input[type=file]").value;
   //  console.log("filePaht", filePath);
     const fileInput = document.querySelector(".file-list");
    fileInput.innerHTML += "<li><input type='file'></li>";
  },false);

  document.querySelector(".sendBtn").addEventListener("click", (e) => {
   
      e.preventDefault()
      document.querySelector(".modal-content").innerHTML = modalText();
      addModalSubmit(".board");
  },false)

</script>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>