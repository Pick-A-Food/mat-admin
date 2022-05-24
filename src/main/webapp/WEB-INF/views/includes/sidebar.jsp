<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Sidebar -->
<aside class="main-sidebar sidebar-light-primary elevation-4">
  
  <a href="/" class="brand-link logo-switch">
    <img src="http://106.241.252.54:8085/img/icon/pickafood.png" alt="AdminLTE Logo" class="brand-image-xl" style="left:12px">
    <span class="brand-text font-weight-light">Pick <sup>A</sup> Food</span>
  </a>
  
  <div class="sidebar">
    <nav class="mt-2">
      <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">

        <%-- 회원 --%>
        <li class="nav-item">
          <a class="nav-link">
            <i class="nav-icon fas fa-user"></i>
            <p> 회원 관리
              <i class="fas fa-angle-left right"></i>
            </p>
          </a>
          <ul class="nav nav-treeview">
            <li class="nav-item">
              <a href="/member/list" class="nav-link">
                <i class="far fa-circle nav-icon"></i>
                <p>회원 정보</p>
              </a> 
            </li>
          </ul>
        </li>

        <%-- 게시글 --%>
        <li class="nav-item">
          <a href="/board/list" class="nav-link">
            <i class="nav-icon fas fa-clipboard-list"></i>
            <p> 게시글 관리
              <i class="fas fa-angle-left right"></i>
            </p>
          </a>
          <ul class="nav nav-treeview">
            <li class="nav-item">
              <a href="/board/list" class="nav-link">
                <i class="far fa-circle nav-icon"></i>
                <p>자유 게시판</p>
              </a>
            </li>
          </ul>
        </li>

        <%-- 문의/신고 --%>
        <li class="nav-item">
          <a class="nav-link">
            <i class="nav-icon fas fa-comments"></i>
            <p> 문의/신고
              <i class="fas fa-angle-left right"></i>
            </p>
          </a>
          <ul class="nav nav-treeview">
            <li class="nav-item">
              <a href="/notice/list" class="nav-link">
                <i class="far fa-circle nav-icon"></i>
                <p>공지사항</p>
              </a>
            </li>
            <li class="nav-item">
              <a href="/inquiry/list" class="nav-link">
                <i class="far fa-circle nav-icon"></i>
                <p>문의 사항</p>
              </a>
            </li>
            <li class="nav-item">
              <a href="/report/memberReport" class="nav-link">
                <i class="far fa-circle nav-icon"></i>
                <p>회원 신고 사항</p>
              </a>
            </li>
          </ul>
        </li>

          <%-- 급식 --%>
          <li class="nav-item">
             <a href="/meal/school" class="nav-link">
                <i class="nav-icon fas fa-apple-alt"></i>
                <p>급식 관리</p>
            </a>
          </li>

        <%-- 음식 재료 정보들 --%>
          <li class="nav-item">
            <a href="/food/main" class="nav-link">
              <i class="nav-icon fas fa-apple-alt"></i>
              <p>알레르기 지식창고</p>
            </a>
          </li>
      </ul>
    </nav>
  
  </div>

</aside>
<!-- End of Sidebar -->
<style>
  .logo_images {
    width : 100%
  }
</style>