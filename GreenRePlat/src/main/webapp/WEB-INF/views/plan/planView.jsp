<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>시공 일정</title>


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/libs/simplebar/dist/simplebar.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/styles.css" />
<link
	href="https://cdn.jsdelivr.net/npm/fullcalendar@5.11.0/main.min.css"
	rel="stylesheet">

<style>
/* 날짜단위 div */
.app-calendar .fc-theme-standard td {
	pointer-events: none;
}

.body-wrapper {
	padding: 0px;
}

.dropdown-menu.content-ff.dropdown-menu-end.dropdown-menu-animate-up {
	width: 276px;
}
/* 이벤트바 div */
.fc-daygrid-event-harness {
	pointer-events: none;
}
.fc-addEventButton-button{
	display: none !important;
}
</style>
</head>

<body>

	<%@ include file="/WEB-INF/inc/header.jsp"%>

	<!--  Header End -->

	<!-- calendar overview -->

	<div class="card-body calender-sidebar app-calendar"
		style="padding: 100px 200px 30px 150px;">
		<div id="calendar"
			class="fc fc-media-screen fc-direction-ltr fc-theme-standard"
			style="height: 1052px;">
			<div class="fc-header-toolbar fc-toolbar fc-toolbar-ltr" style="">

				<div class="fc-toolbar-chunk"></div>

				<div class="fc-toolbar-chunk"
					style="display: flex; justify-content: center; align-items: center;">
					<button type="button" id="prevMonth" title="Previous month"
						aria-pressed="false" class="btn btn-light m-1">
						<span class="icon-item-icon"><svg
								xmlns="http://www.w3.org/2000/svg" width="24" height="24"
								viewBox="0 0 24 24" fill="none" stroke="currentColor"
								stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
								class="icon icon-tabler icons-tabler-outline icon-tabler-chevron-left">
                    <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                    <path d="M15 6l-6 6l6 6"></path>
                  </svg></span>
					</button>

					<h2 class="fc-toolbar-title" id="calendarMonth"></h2>

					<button type="button" id="nextMonth" title="Next month"
						aria-pressed="false" class="btn btn-light m-1">
						<span class="icon-item-icon"><svg
								xmlns="http://www.w3.org/2000/svg" width="24" height="24"
								viewBox="0 0 24 24" fill="none" stroke="currentColor"
								stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
								class="icon icon-tabler icons-tabler-outline icon-tabler-chevron-right">
                    <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                    <path d="M9 6l6 6l-6 6"></path>
                  </svg></span>
					</button>
				</div>

				<div class="fc-toolbar-chunk">
					<div class="fc-button-group">
						<button type="button" title="month view" aria-pressed="true"
							class="btn btn-dark m-1">month</button>
						<button type="button" title="week view" aria-pressed="false"
							class="btn btn-dark m-1">week</button>
						<button type="button" title="day view" aria-pressed="false"
							class="btn btn-dark m-1">day</button>
					</div>
				</div>
			</div>
			<div class="fc-dayGridMonth-view fc-view fc-daygrid">
				<div class="d-flex justify-content-between"></div>
				<div id="calendarDates" class="d-flex flex-wrap">
					<!-- Dates will be injected here -->

				</div>
			</div>
		</div>

	</div>


	<!-- BEGIN MODAL -->
	<form action='<c:url value="/planEditDo" />' method="POST">
		<div class="modal fade" id="addEventsModal" tabindex="-1"
			aria-labelledby="eventModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-dialog-scrollable modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="addEventsModalLabel">Add / Edit
							Event</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<div class="row">
							<!-- Event Title Input -->
							<div class="col-md-12">
								<label class="form-label" for="event-title">제목</label>
								<input id="event-title" type="text" class="form-control"
									placeholder="프로젝트 제목입력" />
							</div>

							<!-- Event Color Selection -->
							<div class="col-md-12 mt-4">
								<label class="form-label">Event Color</label>
								<div class="d-flex">
									
									
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="radio"
											name="event-level" value="Primary" id="modalPrimary" /> <label
											class="form-check-label" for="modalPrimary">Primary</label>
									</div>
									
								</div>
							</div>

							<!-- Event Start Date -->
							<div class="col-md-6 mt-4">
								<label class="form-label" for="event-start-date">시작일</label> <input id="event-start-date" type="date"
									class="form-control" name="quoSdate" />
							</div>

							<!-- Event End Date -->
							<div class="col-md-6 mt-4">
								<label class="form-label" for="event-end-date">종료일</label> <input id="event-end-date" type="date"
									class="form-control" name="quoEdate" />
							</div>
						</div>
	</form>
						<!-- 컨텐츠 첨부 -->
						<div class="col-md-12 mt-6">
							<div>
								<label class="form-label">Contents</label>
							 	<form id="contForm" action="<c:url value="/writeContDo" />" method="POST">
								<input id="contInput" type="text" class="form-control" name="cont" >
								<input type="hidden" id="hiddenQuoId" name="hiddenQuoId" value="">
								<input type="hidden" name="memId" value="${sessionScope.memInfo.memId }">
								
								<button id="contBtn" type="button">등록</button>
								</form>
							</div>
							<ul class = "list-group d-flex" id = "myConts"></ul>
						</div>
						<input type="hidden" name="quoId" id="event-quo-id" />


					</div>
					<div class="modal-footer">
						<!-- Close Button -->
						<button type="button" class="btn btn bg-danger-subtle text-danger"
							data-bs-dismiss="modal">Close</button>

						<!-- Update Event Button -->

						<button type="submit" class="btn btn-success btn-update-event">
							Update changes</button>
						<button type="button" class="btn btn-danger btn-update-event"
							data-fc-event-public-id="">Delete event</button>


						<!-- Add Event Button -->
						<button type="button" class="btn btn-primary btn-add-event">
							Add Event</button>
					</div>
				</div>
			</div>
		</div>
	<!-- END MODAL -->
	</div>
	</div>




	<%@ include file="/WEB-INF/inc/footer.jsp"%>

	<!-- FullCalendar JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/iconify-icon@1.0.8/dist/iconify-icon.min.js"></script>


	<script>

</script>

	<script>
console.log(document.getElementById('addEventsModal')); // DOM에 존재하는지 확인



  document.addEventListener("DOMContentLoaded", function () {
    // Calender Date 변수
    var newDate = new Date();

    function getDynamicMonth() {
      var getMonthValue = newDate.getMonth();
      var _getUpdatedMonthValue = getMonthValue + 1;
      if (_getUpdatedMonthValue < 10) {
        return "0" + _getUpdatedMonthValue;
      } else {
        return "" + _getUpdatedMonthValue;
      }
    }

    // Calender Modal Elements
    var getModalTitleEl = document.querySelector("#event-title");
    var getModalStartDateEl = document.querySelector("#event-start-date");
    var getModalEndDateEl = document.querySelector("#event-end-date");
    var getModalAddBtnEl = document.querySelector(".btn-add-event");
    var getModalUpdateBtnEl = document.querySelector(".btn-update-event");

    var calendarsEvents = {
      Danger: "danger",
      Success: "success",
      Primary: "primary",
      Warning: "warning"
    };

    // Calendar Elements and options
    var calendarEl = document.querySelector("#calendar");
    var checkWidowWidth = function () {
      return window.innerWidth <= 1199;
    };

    var calendarHeaderToolbar = {
      left: "prev next addEventButton",
      center: "title",
      right: "dayGridMonth,timeGridWeek,timeGridDay"
    };

    var calendarEventsList = [];
    
    let data = {};
    <c:forEach var="est" items="${estList}">
	    data = {};
	    data.id = "${est.estId}";
	    data.title = "${est.estAddress}";
	    data.start = "${est.estSdate}";
	    data.end = "${est.estEdate}";
	   	data.extendedProps = { calendar: "Primary" };
	    calendarEventsList.push(data);
	</c:forEach>
	console.log(calendarEventsList); 



    // Calendar Select fn.
    var calendarSelect = function (info) {
      getModalAddBtnEl.style.display = "block";
      getModalUpdateBtnEl.style.display = "none";
      myModal.show();
      getModalStartDateEl.value = info.startStr;
      getModalEndDateEl.value = info.endStr;
    };

    // Calendar AddEvent fn.
    var calendarAddEvent = function () {
      var currentDate = new Date();
      var dd = String(currentDate.getDate()).padStart(2, "0");
      var mm = String(currentDate.getMonth() + 1).padStart(2, "0");
      var yyyy = currentDate.getFullYear();
      var combineDate = yyyy + "-" + mm + "-" + dd + "T00:00:00";
      getModalAddBtnEl.style.display = "block";
      getModalUpdateBtnEl.style.display = "none";
      myModal.show();
      getModalStartDateEl.value = combineDate;
    };

    // Calender Event Function
    var calendarEventClick = function (info) {
      var eventObj = info.event;

      if (eventObj.url) {
        window.open(eventObj.url);
        info.jsEvent.preventDefault();
      } else {
        var getModalEventId = eventObj._def.publicId;
        var getModalEventLevel = eventObj._def.extendedProps["calendar"];
        var getModalCheckedRadioBtnEl = document.querySelector(
          'input[value="' + getModalEventLevel + '"]'
        );
        
     // 모달에 quoId 값 설정
        var quoId = eventObj.id;  // 이미 이벤트 객체에 quoId가 들어있다고 가정
        let quoIdValue = '';
        console.log("픈ㅇㅇ",quoId);
        document.querySelector("#event-quo-id").value = quoId; // #event-quo-id는 quoId를 입력 받을 input 필드
         	
    	$.ajax({
    		type: 'GET',
    		url: '${pageContext.request.contextPath}/getData',
    		data: {'quoId': quoId },
    		success: function(response){
    			console.log(response);
    			
    			if (response && response.length > 0) {
    	            v_quoIdValue = response[0].quoId; // 첫 번째 객체의 quoId
    	            console.log("quoId:", v_quoIdValue);
    	        }
    			
    			document.getElementById("hiddenQuoId").value = v_quoIdValue;
    			
    			const v_dataContainer = document.getElementById("myConts");
    	        // response는 JSON 배열로 가정, 해당 데이터를 HTML 형식으로 변환하여 삽입
    	        let v_htmlContent = '';
    	        response.forEach(item => {
    	        	v_htmlContent += '<li class="list-group-item">'+item.memId + item.cont + item.contDate+'</li>';
    	        });

    	        // innerHTML을 사용하여 데이터를 삽입
    	        v_dataContainer.innerHTML = v_htmlContent;
    			
    		}
    		
    	
    			
    	});
        
        
        
		


        getModalTitleEl.value = eventObj.title;
        getModalStartDateEl.value = eventObj.startStr.slice(0, 10);
        getModalEndDateEl.value = eventObj.endStr.slice(0, 10);
        getModalCheckedRadioBtnEl.checked = true;
        getModalUpdateBtnEl.setAttribute("data-fc-event-public-id", getModalEventId);
        getModalAddBtnEl.style.display = "none";
        getModalUpdateBtnEl.style.display = "block";
        myModal.show();
        
      }
    };

    // Active Calender
    var calendar = new FullCalendar.Calendar(calendarEl, {
      selectable: true,
      height: checkWidowWidth() ? 900 : 1052,
      initialView: checkWidowWidth() ? "listWeek" : "dayGridMonth",
      initialDate: newDate.getFullYear() + "-" + getDynamicMonth() + "-07",
      headerToolbar: calendarHeaderToolbar,
      events: calendarEventsList,
      select: calendarSelect,
      unselect: function () {
        console.log("unselected");
      },
      /* customButtons: {
        addEventButton: {
          text: "Add Event",
          click: calendarAddEvent
        }
      }, */
      eventClassNames: function ({ event: calendarEvent }) {
        const getColorValue = calendarsEvents[calendarEvent._def.extendedProps.calendar];
        return ["event-fc-color fc-bg-" + getColorValue];
      },
      eventClick: calendarEventClick,
      windowResize: function (arg) {
        if (checkWidowWidth()) {
          calendar.changeView("listWeek");
          calendar.setOption("height", 900);
        } else {
          calendar.changeView("dayGridMonth");
          calendar.setOption("height", 1052);
        }
      }
    });

    // Update Calender Event
    getModalUpdateBtnEl.addEventListener("click", function () {
      var getPublicID = this.dataset.fcEventPublicId;
      var getTitleUpdatedValue = getModalTitleEl.value;
      var setModalStartDateValue = getModalStartDateEl.value;
      var setModalEndDateValue = getModalEndDateEl.value;
      var getEvent = calendar.getEventById(getPublicID);
      var getModalUpdatedCheckedRadioBtnEl = document.querySelector(
        'input[name="event-level"]:checked'
      );

      var getModalUpdatedCheckedRadioBtnValue =
        getModalUpdatedCheckedRadioBtnEl !== null
          ? getModalUpdatedCheckedRadioBtnEl.value
          : "";

      getEvent.setProp("title", getTitleUpdatedValue);
      getEvent.setDates(setModalStartDateValue, setModalEndDateValue);
      getEvent.setExtendedProp("calendar", getModalUpdatedCheckedRadioBtnValue);
      myModal.hide();
    });

    // Add Calender Event
    getModalAddBtnEl.addEventListener("click", function () {
      var getModalCheckedRadioBtnEl = document.querySelector(
        'input[name="event-level"]:checked'
      );

      var getTitleValue = getModalTitleEl.value;
      var setModalStartDateValue = getModalStartDateEl.value;
      var setModalEndDateValue = getModalEndDateEl.value;
      var getModalCheckedRadioBtnValue =
        getModalCheckedRadioBtnEl !== null ? getModalCheckedRadioBtnEl.value : "";

      calendar.addEvent({
        id: 12,
        title: getTitleValue,
        start: setModalStartDateValue,
        end: setModalEndDateValue,
        allDay: true,
        extendedProps: { calendar: getModalCheckedRadioBtnValue }
      });
      myModal.hide();
    });

    // Calendar Init
    calendar.render();
    var myModal = new bootstrap.Modal(document.getElementById("addEventsModal"), {
      keyboard: false
    });
  });
  console.log(document.getElementById('addEventsModal')); // DOM에 존재하는지 확인

  const v_contBtn = document.getElementById("contBtn");
  const v_contForm = document.getElementById("contForm");
  
  v_contBtn.addEventListener('click',()=>{
	  let v_contForm = $('#contForm');
	  let v_url = v_contForm.attr('action');
	  let v_formData = v_contForm.serialize();
	  
	  v_formData += '&quoId=' + v_quoIdValue;  // quoId 값을 POST 데이터에 추가

	    console.log(v_contForm);
	    console.log(v_url);
	    console.log(v_formData);

	    $.ajax({
	        type: 'POST',
	        url: v_url,
	        data: v_formData,
	        success: function(data) {
	            console.log(data);
	        }
	    });
  });

  

  

  
</script>

<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>



</body>

</html>
