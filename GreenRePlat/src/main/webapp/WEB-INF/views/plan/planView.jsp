<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>SeoDash Free Bootstrap Admin Template by Adminmart</title>


  <style>
    .fc .fc-toolbar {
      align-items: center;
      display: flex;
      justify-content: space-between;
    }

    .fc .fc-button-group {
      display: inline-flex;
      position: relative;
      vertical-align: middle;
    }

    .calendar-day {
      flex: 0 0 14.28%;
      height: 200px;
      font-size: larger;
      margin: 0;
      padding: 4px;
      cursor: pointer;

    }

    .calendar-day:hover {
      background-color: #d0d5d8;
      color: rgba(255, 255, 255, 0.788);
      border-left: 2px solid white;
      
    }

    .calendar-head {
      flex: 0 0 14.28%;
      height: 56px;
      display: flex;
      justify-content: center;
      align-items: center;
      background-color: #4c5f6470;
      color: #242c33;
      border-left: 2px solid white;

    }
  </style>

</head>

<body>

	<%@ include file="/WEB-INF/inc/header.jsp" %>

	<!--  Header End -->
	
	      <!-- calendar overview -->
      <div class="container-fluid">
      </div>
      <div class="card-body calender-sidebar app-calendar">
        <div id="calendar" class="fc fc-media-screen fc-direction-ltr fc-theme-standard" style="height: 1052px;">
          <div class="fc-header-toolbar fc-toolbar fc-toolbar-ltr" style="padding: 30px 70px 30px 70px;">
      
            <div class="fc-toolbar-chunk">
      
      
              <button type="button" title="Add Event" aria-pressed="false" class="btn btn-primary m-1">Add
                Event</button>
            </div>
      
            <div class="fc-toolbar-chunk" style="display: flex; justify-content: center; align-items: center;">
              <button type="button" id="prevMonth" title="Previous month" aria-pressed="false" class="btn btn-light m-1">
                <span class="icon-item-icon"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                    viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                    stroke-linejoin="round" class="icon icon-tabler icons-tabler-outline icon-tabler-chevron-left">
                    <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                    <path d="M15 6l-6 6l6 6"></path>
                  </svg></span>
              </button>
      
              <h2 class="fc-toolbar-title" style="margin: 0px; padding: 10px;" id="calendarMonth"></h2>
      
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
          <div class="fc-dayGridMonth-view fc-view fc-daygrid" style="padding: 30px 70px 30px 70px;">
            <div class="d-flex justify-content-between">
              <div class="calendar-head">Sun</div>
              <div class="calendar-head">Mon</div>
              <div class="calendar-head">Tue</div>
              <div class="calendar-head">Wed</div>
              <div class="calendar-head">Thu</div>
              <div class="calendar-head">Fri</div>
              <div class="calendar-head">Sat</div>
            </div>
            <div id="calendarDates" class="d-flex flex-wrap">
              <!-- Dates will be injected here -->
            </div>
          </div>
        </div>
      
      </div>


<%@ include file="/WEB-INF/inc/footer.jsp" %>

<script>
const calendarDates = document.getElementById('calendarDates');
const calendarMonth = document.getElementById('calendarMonth');
let currentDate = new Date();

function renderCalendar(date) {
  const year = date.getFullYear();
  const month = date.getMonth();
  const firstDayOfMonth = new Date(year, month, 1).getDay();
  const lastDateOfMonth = new Date(year, month + 1, 0).getDate();

  calendarMonth.innerText = date.toLocaleString('default', { month: 'long' }) + year;
  calendarDates.innerHTML = '';

  for (let i = 0; i < firstDayOfMonth; i++) {
    calendarDates.innerHTML += '<div class="calendar-day"></div>';
  }

  for (let i = 1; i <= lastDateOfMonth; i++) {
    const day = document.createElement('div');
    day.classList.add('calendar-day');
    day.textContent = i;
    day.addEventListener('click', function () {
      document.querySelectorAll('.calendar-day.selected').forEach(el => el.classList.remove('selected'));
      day.classList.add('selected');
      alert(`Selected Date: ${year}-${month + 1}-${i}`);
    });
    calendarDates.appendChild(day);
  }
}

document.getElementById('prevMonth').addEventListener('click', function () {
  currentDate.setMonth(currentDate.getMonth() - 1);
  renderCalendar(currentDate);
});

document.getElementById('nextMonth').addEventListener('click', function () {
  currentDate.setMonth(currentDate.getMonth() + 1);
  renderCalendar(currentDate);
});

renderCalendar(currentDate);
</script>

</body>

</html>
