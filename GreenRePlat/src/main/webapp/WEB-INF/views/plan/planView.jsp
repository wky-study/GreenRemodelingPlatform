<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>SeoDash Free Bootstrap Admin Template by Adminmart</title>


<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/libs/simplebar/dist/simplebar.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css" />
<link href="https://cdn.jsdelivr.net/npm/fullcalendar@5.11.0/main.min.css" rel="stylesheet">

<style>
	/* 날짜단위 div */
  .fc .fc-daygrid-day-frame {
  }
  .body-wrapper {
  padding: 0px;
  }
  .dropdown-menu.content-ff.dropdown-menu-end.dropdown-menu-animate-up {
  	width: 276px;
  
  }
  /* 이벤트바 div */
  .fc-daygrid-event-harness{
  }

  

  



</style>
</head>

<body>

	<%@ include file="/WEB-INF/inc/header.jsp" %>

	<!--  Header End -->
	
      <!-- calendar overview -->

      <div class="card-body calender-sidebar app-calendar" style="padding: 100px 200px 30px 150px;" >
        <div id="calendar" class="fc fc-media-screen fc-direction-ltr fc-theme-standard" style="height: 1052px; ">
          <div class="fc-header-toolbar fc-toolbar fc-toolbar-ltr" style="">

            <div class="fc-toolbar-chunk">


              <button type="button" title="Add Event" aria-pressed="false" class="btn btn-primary m-1" id="addEvent">Add
                Event</button>
            </div>

            <div class="fc-toolbar-chunk" style="display: flex; justify-content: center; align-items: center;">
              <button type="button" id="prevMonth" title="Previous month" aria-pressed="false"
                class="btn btn-light m-1">
                <span class="icon-item-icon"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                    viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                    stroke-linejoin="round" class="icon icon-tabler icons-tabler-outline icon-tabler-chevron-left">
                    <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                    <path d="M15 6l-6 6l6 6"></path>
                  </svg></span>
              </button>

              <h2 class="fc-toolbar-title" id="calendarMonth"></h2>

              <button type="button" id="nextMonth" title="Next month" aria-pressed="false" class="btn btn-light m-1">
                <span class="icon-item-icon"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                    viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                    stroke-linejoin="round" class="icon icon-tabler icons-tabler-outline icon-tabler-chevron-right">
                    <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                    <path d="M9 6l6 6l-6 6"></path>
                  </svg></span>
              </button>
            </div>

            <div class="fc-toolbar-chunk">
              <div class="fc-button-group">
                <button type="button" title="month view" aria-pressed="true" class="btn btn-dark m-1">month</button>
                <button type="button" title="week view" aria-pressed="false" class="btn btn-dark m-1">week</button>
                <button type="button" title="day view" aria-pressed="false" class="btn btn-dark m-1">day</button>
              </div>
            </div>
          </div>
          <div class="fc-dayGridMonth-view fc-view fc-daygrid" >
            <div class="d-flex justify-content-between">
            </div>
            <div id="calendarDates" class="d-flex flex-wrap">
              <!-- Dates will be injected here -->

            </div>
          </div>
        </div>

      </div>


      <!-- BEGIN MODAL -->
      <div class="modal fade" id="addEventsModal" tabindex="-1" aria-labelledby="eventModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-scrollable modal-lg">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="addEventsModalLabel">Add / Edit Event</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <div class="row">
                <!-- Event Title Input -->
                <div class="col-md-12">
                  <label class="form-label" for="event-title">Event Title</label>
                  <input id="event-title" type="text" class="form-control" placeholder="Enter event title" />
                </div>

                <!-- Event Color Selection -->
                <div class="col-md-12 mt-4">
                  <label class="form-label">Event Color</label>
                  <div class="d-flex">
                    <div class="form-check form-check-inline">
                      <input class="form-check-input" type="radio" name="event-level" value="Danger" id="modalDanger" />
                      <label class="form-check-label" for="modalDanger">Danger</label>
                    </div>
                    <div class="form-check form-check-inline">
                      <input class="form-check-input" type="radio" name="event-level" value="Success"
                        id="modalSuccess" />
                      <label class="form-check-label" for="modalSuccess">Success</label>
                    </div>
                    <div class="form-check form-check-inline">
                      <input class="form-check-input" type="radio" name="event-level" value="Primary"
                        id="modalPrimary" />
                      <label class="form-check-label" for="modalPrimary">Primary</label>
                    </div>
                    <div class="form-check form-check-inline">
                      <input class="form-check-input" type="radio" name="event-level" value="Warning"
                        id="modalWarning" />
                      <label class="form-check-label" for="modalWarning">Warning</label>
                    </div>
                  </div>
                </div>

                <!-- Event Start Date -->
                <div class="col-md-6 mt-4">
                  <label class="form-label" for="event-start-date">Enter Start Date</label>
                  <input id="event-start-date" type="date" class="form-control" />
                </div>

                <!-- Event End Date -->
                <div class="col-md-6 mt-4">
                  <label class="form-label" for="event-end-date">Enter End Date</label>
                  <input id="event-end-date" type="date" class="form-control" />
                </div>
              </div>
              <!-- 컨텐츠 첨부 -->
              <div class="col-md-12 mt-6">
                <div>
                  <label class="form-label">Contents</label>
                  <input id="event-end-date" type="text" class="form-control" />
                </div>
              </div>
              <div class="col-md-12 mt-6">
                <div>
                  <label class="form-label">Images</label>
                  <input id="event-end-date" type="text" class="form-control" />
                </div>
              </div>
            </div>
            <div class="modal-footer">
              <!-- Close Button -->
              <button type="button" class="btn btn bg-danger-subtle text-danger" data-bs-dismiss="modal">Close</button>

              <!-- Update Event Button -->
              <button type="button" class="btn btn-success btn-update-event" data-fc-event-public-id="">
                Update changes
              </button>

              <!-- Add Event Button -->
              <button type="button" class="btn btn-primary btn-add-event">
                Add Event
              </button>
            </div>
          </div>
        </div>
      </div>
      <!-- END MODAL -->
        </div>
      </div>




<%@ include file="/WEB-INF/inc/footer.jsp" %>

  <!-- FullCalendar JS -->
  <script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/iconify-icon@1.0.8/dist/iconify-icon.min.js"></script>
 

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
    
    <c:forEach var="plan" items="${planList}">
    data.id = "${plan.quoId}"
    data.title = "${plan.estId}"
    data.start = "${plan.quoSdate}"
    data.end = "${plan.quoEdate}"
   	data.extendedProps = { calendar: "Primary" };
    	
    calendarEventsList.push(data);
	</c:forEach>
    


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
      customButtons: {
        addEventButton: {
          text: "Add Event",
          click: calendarAddEvent
        }
      },
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

</script>
 
 

</body>

</html>
