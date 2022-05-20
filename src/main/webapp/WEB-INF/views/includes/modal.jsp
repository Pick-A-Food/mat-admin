<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>Modal body text goes here.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">Save changes</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>

<div class="modal-header">
  <button type="button" class="close" data-dismiss="modal" aria-label="Close" aria-hidden="true">×</button>
  <h3 class="smaller lighter blue no-margin modal-title">검수정보 등록</h3>
</div>

<div class="modal-body">
  테스트입니다.
</div>

<div class="modal-footer">
    <span class="btn btn-sm btn-warning" id="testDel">
        전체삭제<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
    </span>
  <span class="btn btn-sm btn-success" id="testSave">
        저장<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
    </span>
  <button class="btn btn-sm btn-danger pull-right" data-dismiss="modal" id="btnClose">
    <i class="ace-icon fa fa-times"></i>닫기
  </button>

</div>