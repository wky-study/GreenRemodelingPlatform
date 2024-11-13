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
  .fc .fc-daygrid-day-frame:hover {
    cursor: pointer;
  }
  .body-wrapper {
  padding: 0px;
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
      <div class="modal fade" id="eventModal" tabindex="-1" aria-labelledby="eventModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-scrollable modal-lg">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="eventModalLabel">Add / Edit Event</h5>
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
            </div>
            <div class="modal-footer">
              <!-- Close Button -->
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>

              <!-- Update Event Button -->
              <button type="button" class="btn btn-warning btn-update-event" data-fc-event-public-id="">
                Update changes
              </button>

              <!-- Add Event Button -->
              <button type="button" class="btn btn-success btn-add-event">
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
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/js/apps/calendar-init.js"></script>


</body>

</html>
