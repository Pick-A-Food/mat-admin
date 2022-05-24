<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<div class="content-header">
  <div class="container-fluid">
    <div class="row mb-2">
      <div class="col-sm-6">
        <h1 class="m-0">Dashboard</h1>
      </div>
      <div class="col-sm-6">
        <ol class="breadcrumb float-sm-right">
          <li class="breadcrumb-item"><a href="#">Home</a></li>
          <li class="breadcrumb-item active">Dashboard v1</li>
        </ol>
      </div>
    </div>
  </div>
</div>
<section class="content">
  <div class="container-fluid">
    
    <div class="row">
      
      <section class="col-lg-6 connectedSortable">
        
        <div class="card">
          <div class="card-header">
            <h3 class="card-title">
              회원알레르기 통계
            </h3>
          </div>
          <div class="card-body">
            <div class="tab-content p-0">
              <div class="chart tab-pane active" style="position: relative; height: 300px;">
                <div class="bar-chart-allergy">
                  <canvas id="doughnutChart" width="400" height="600"
                          style="display: block; box-sizing: border-box; height: 496px; width: 496.5px;"
                  ></canvas>
                  
                </div>
              </div>
            </div>
          </div>
        </div>
        
        
       
        
        
        <div class="card">
        
        
          
        
        </div>
      
      </section>
      
      
      <section class="col-lg-6 connectedSortable">
        
        <div class="card">
          <div class="card-header">
            <h3 class="card-title">
              월간 회원가입자수
            </h3>
          </div>
        </div>
        <div class="card-body">
          <div class="tab-content p-0">
            <div class="chart tab-pane active" id="revenue-chart" style="position: relative; height: 300px;">
              <div class="bar-chart-allergy">
                <canvas id="myChart" width="400" height="400"></canvas>
              </div>
            </div>
          </div>
        </div>
        
        
       
        
        
        <div class="card bg-gradient-light">
          
  
          <div id="my-chart">
<%--           <svg width="300"  height="200"></svg>--%>
          </div>
          
        </div>
       
      </section>
    </div>
  </div>
</section>
<%--<script type="text/javascript"  src="/resources/js/barChart.js"></script>--%>
<%--<script src="http://106.241.252.54:8085/d3/dist/d3.min.js"></script>--%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.7.1/chart.min.js"></script>
<script type="text/javascript" src="/resources/js/pieChart.js"></script>
<script>
  const ctx = document.getElementById('myChart').getContext('2d');
  const myChart = new Chart(ctx, {
    type: 'bar',
    data: {
      labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
      datasets: [{
        label: '# of Votes',
        data: [12, 19, 3, 5, 2, 3],
        backgroundColor: [
          'rgba(255, 99, 132, 0.2)',
          'rgba(54, 162, 235, 0.2)',
          'rgba(255, 206, 86, 0.2)',
          'rgba(75, 192, 192, 0.2)',
          'rgba(153, 102, 255, 0.2)',
          'rgba(255, 159, 64, 0.2)'
        ],
        borderColor: [
          'rgba(255, 99, 132, 1)',
          'rgba(54, 162, 235, 1)',
          'rgba(255, 206, 86, 1)',
          'rgba(75, 192, 192, 1)',
          'rgba(153, 102, 255, 1)',
          'rgba(255, 159, 64, 1)'
        ],
        borderWidth: 1
      }]
    },
    options: {
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }
  });
  
  
  
  
  
</script>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>