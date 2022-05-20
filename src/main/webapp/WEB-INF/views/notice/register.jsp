<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<link href="/resources/css/table.css" rel="stylesheet" type="text/css">

<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800"></h1>
    <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
</div>

    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="/">Home</a></li>
                        <li class="breadcrumb-item active"><a href="/notice/list" style="color: #3c3b3b">공지사항</a></li>
                    </ol>
            </div>
        </div>
    </section>

    <section class="content">
        <div class="row">
            <div class="col-12">
                <div class="form-group" style="margin-bottom: 10px">
                    <button class="btn btn-success float-right registerBtn" style="padding-bottom: 10px"><i class="fa fa-plus"></i>저장</button>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12" style="margin-top: 20px;">
                <div class="card card-primary card-outline">
                    <form class="actionForm" name="notice" action="/notice/register" method="post">
                    <div class="card-body" style="display: block;">
                        <div class="form-group" style="display: flex">
                            <label for="inputName" style="width: 7vw; ">제 목</label>
                            <input type="text" id="inputName" name="title" class="form-control inputName" style="margin-right: 5vw">
                            <label for="inputName" style="width: 10vw;">닉네임</label>
                            <input type="text" class="form-control inputId" name="nickname" placeholder="로그인 하면 자동으로 들어갈 곳" >
                            <input type="hidden" name="id" value="member123">
                        </div>
                        <div class="hiddenClass"></div>
                        <div class="form-group">
                            <label for="inputDescription">내용</label>
                            <textarea id="inputDescription" class="form-control inputContent" rows="6" name="content"></textarea>
                        </div>
                    </div>
                    </form>

                    <div class="card-header">
                        <h3 class="card-title" style="list-style: none">첨부파일</h3>
                    </div>
                    <div class="card-body" style="display: block;">
                        <div class="uploadInputDiv">
                            <input type="file" name="upload" multiple class="uploadFile">
                            <button class="btn bg-gradient-info float-right file-add uploadBtn">업로드</button>
                        </div>
                    </div>
                    <style>
                        .uploadResult{
                            display: flex;
                            padding-left: 20px;
                            padding-bottom: 10px;
                        }

                        .uploadResult > div {
                            padding-right: 20px;
                            border-color: sienna;

                            /*   자동으로 줄 바꾸는 것 넣기 */
                        }

                        .uploadResult > div > span{
                            font-size : 10px;
                        }

                        .delBtn{
                            cursor: pointer;
                            border-style: none;
                            background-color: #ffffff;
                        }
                    </style>

                    <div class="uploadResult">
                    </div>
                </div>
            </div>
            <div class="col-md-12">

            </div>
        </div>
    </section>



<%-- Axios --%>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script>

    const uploadResult = document.querySelector(".uploadResult")
    const cloneInput = document.querySelector(".uploadFile").cloneNode()

    /* 등록 버튼 */
    document.querySelector(".registerBtn").addEventListener("click", (e) => {
        e.preventDefault()
        e.stopPropagation()

        /* 이미지 정보 */
        const divArr = document.querySelectorAll(".uploadResult > div")
        let str = "";

        for(let i= 0;i < divArr.length; i++){
            const fileObj = divArr[i]

            if(i === 0){
                const mainImageLink = fileObj.querySelector("img").getAttribute("src")
                str += `<input type='hidden' name='mainImage' value='\${mainImageLink}'>`
            }

            const fileSeq = fileObj.getAttribute("data-fileSeq")
            // const uuid = fileObj.getAttribute("data-uuid")
            // const img = fileObj.getAttribute("data-img")
            // const savePath = fileObj.getAttribute("data-savepath")
            // const fileName = fileObj.getAttribute("data-filename")

            str += `<input type='hidden' name='fileSeq' value='\${fileSeq}'>`
            // str += `<input type='hidden' name='uploads[\${i}].uuid' value='\${uuid}'>`
            // str += `<input type='hidden' name='uploads[\${i}].img' value='\${img}'>`
            // str += `<input type='hidden' name='uploads[\${i}].savePath' value='\${savePath}'>`
            // str += `<input type='hidden' name='uploads[\${i}].fileName' value='\${fileName}'>`
        }//for

        const actionForm =  document.querySelector(".actionForm")
        document.querySelector(".hiddenClass").innerHTML += str

       // actionForm.submit();
    }, false)



    /* 첨부파일 */
    uploadResult.addEventListener("click", (e) => {
        if(e.target.getAttribute("class").indexOf("delBtn") < 0){
            return
        }
        const btn = e.target
        const link = btn.getAttribute("data-link")
        deleteToServer(link).then(result => {
            btn.closest("div").remove()
        })
    },false)


    document.querySelector(".uploadBtn").addEventListener("click",(e)=> {

        const formObj = new FormData();
        const fileInput = document.querySelector(".uploadFile")
        console.log("file", fileInput.files)

        const files = fileInput.files

        for (let i = 0; i < files.length; i++) {
            formObj.append("files", files[i]);
        }
      
        //resultArr 은 uploadResultDTO

        uploadToServer(formObj).then(resultArr => {
            uploadResult.innerHTML += resultArr.map( ({fileSeq ,uuid,thumbnail,link, fileName,savePath, img}) => `
                <div data-fileSeq='\${fileSeq}' data-uuid='\${uuid}' data-img='\${img}'  data-filename='\${fileName}'  data-savepath='\${savePath}'>
                <img src='/view?fileName=\${thumbnail}'><button data-link='\${link}' class="delBtn" >x</button>
                <br><span>\${fileName}</span>
                </div>`).join(" ")

            fileInput.remove();
            document.querySelector(".uploadInputDiv").appendChild(cloneInput).cloneNode()
            //업로드 버튼을 눌렀을 때 그제서야 버튼을 찾기 때문에 이렇게 하는 게 가능
            //업로드 버튼을 누르면 dom 이 복구된 상태에서 찾기 때문에 읽을 수 있다.
        })

    },false)

    //업로드 된 이미지 삭제
    async function deleteToServer(fileName){
        const options = {headers: { "Content-Type": "application/x-www-form-urlencoded"}}

        const res = await axios.post("/delete", "fileName="+fileName, options )

        return res.data
    }

    //이미지 업로드
    async function uploadToServer (formObj) {
        const response = await axios({
            method: 'post',
            url: '/upload',
            data: formObj,
            headers: {
                'Content-Type': 'multipart/form-data',
            },
        });

        return response.data
    }

</script>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>