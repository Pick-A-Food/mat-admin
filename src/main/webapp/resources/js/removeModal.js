const modalText = () => {
    return `
  <div class="modal-header">
    <h3 class="smaller lighter blue no-margin modal-title">삭제</h3>
    <button type="button" class="close" data-dismiss="modal" aria-label="Close" aria-hidden="true">×</button>
  </div>

  <div class="modal-body">
    삭제하시겠습니까?
  </div>
  <div class="modal-footer">
    <button class="btn btn-sm btn-success modal-submit" id="testSave">
          예
      </button>
    <button class="btn btn-sm btn-danger pull-right" data-dismiss="modal" id="btnClose">
      아니오
    </button>
  </div>`;
}

const removeModalSubmit = function(query){
    document.querySelector(".modal-submit").addEventListener("click" , (e) =>{
        document.querySelector(query)
            .submit()
    },false)}

