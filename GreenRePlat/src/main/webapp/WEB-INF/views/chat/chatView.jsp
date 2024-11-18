<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>채팅</title>


<%@ include file="/WEB-INF/inc/header.jsp"%>

<style>
.chatcontent {
	height: 700px;
	width: 100%;
	overflow-y: scroll;
}

.myChat {
	background-color: #E0B1D0;
}

li {
	list-style-type: none;
}

.me {
	text-align: right;
}

.chat-box {
	max-width: 200px;
	display: inline-block;
	border-radius: 15px;
}
</style>
</head>
<body>


	<!-- Contact Section-->
	<div class="container-fluid" id="contact">
		<div class="container pt-5">

			<!-- Contact Section Form-->
			<div class="row justify-content-center">
				<div class="col-lg-8 col-xl-7">
					<div class="chatWrap">
						<div class="main_tit">
							<h1>방 정보: [ ${room.roomNo}번방 ${room.roomName } ]</h1>
							<button type="button" id="downloadBtn" class="btn btn-primary float-right">
            				채팅내역 다운로드
       						 </button>
						</div>
						<div class="content chatcontent border border-secondary"
							data-room-no="${room.roomNo}">
							<div id="chatList" class="">
								<c:forEach items="${chatList}" var="chat">
									<!-- 내 채팅일 경우 -->
									<c:if test="${sessionScope.memInfo.memId  eq chat.memId}">
										<li data-no="${chat.chatNo}" class="me pr-2"><strong
											class="">${chat.memNick}</strong>
											<div class="me">
												<strong style="display: inline;" class="align-self-end">${chat.sendDate }</strong>
												<p class='myChat chat-box text-left p-3'>${chat.chatMsg }</p>
											</div></li>
									</c:if>
									<!-- 다른사람의 채팅일 경우 -->
									<c:if test="${sessionScope.memInfo.memId ne chat.memId}">
										<li data-no="${chat.chatNo}" class="pl-2"><strong>${chat.memNick}</strong>
											<div>
												<p class='chat-box bg-light p-3'>${chat.chatMsg }</p>
												<strong style="display: inline;" class="align-self-center">${chat.sendDate }</strong>
											</div></li>
									</c:if>
								</c:forEach>
							</div>
						</div>
						<div>
							<div class="d-flex justify-content-center" style="height: 60px">
								<input type="text" id="msgi" name="msg" class="form-control"
									style="width: 75%; height: 100%">
								<button type="button" id="btnSend"
									class="send btn btn-secondary "
									style="width: 25%; height: 100%">보내기</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- footer 부분 -->
	<%@ include file="/WEB-INF/inc/footer.jsp"%>

	<!-- 소켓통신 라이브러리 불러오기 cdnjs 사이트에서 sockjs 와 stomp 검색 -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.6.1/sockjs.min.js"
		integrity="sha512-1QvjE7BtotQjkq8PxLeF6P46gEpBRXuskzIVgjFpekzFVF4yjRgrQvTG1MTOJ3yQgvTteKAcO7DSZI92+u/yZw=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"
		integrity="sha512-iKDtgDyTHjAitUDdLljGhenhPwrbBfqTKWO1mkhSFH3A7blITC9MhYon6SjnMhp4o0rADGw9yAC6EW4t5a4K3g=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>

	<script type="text/javascript">
		// 소켓 연결에 사용될 stomp 객체
		var client;

		// 페이지 로드 완료시 실행
		$(document)
				.ready(
						function() {
							// 채팅창 스크롤 내리기
							$(".chatcontent").scrollTop(
									$(".chatcontent")[0].scrollHeight);

							var isEnd = false;
							var isScrolled = false;

							// 채팅으로 전달받은 데이터를 화면에 그려주기 위한 html 태그 문자열 생성 후 리턴 
							function renderList(vo) {
								// 날짜 포맷
								var date = vo.sendDate;
								var html = "";
								var content = "";

								//내가 보낸 채팅일 경우
								if (vo.memId == "${sessionScope.memInfo.memId }") {
									content = "<p class='myChat chat-box text-left p-3'>"
											+ vo.chatMsg + "</p>";

									html = "<li class='me pr-2'>"
											+ "<strong>"
											+ vo.memNick
											+ "</strong>"
											+ "<div class='me'>"
											+ "<strong style='display : inline;' class='align-self-end'>"
											+ date + "</strong>" + content
											+ "</div>" + "</li>";
								} else {
									// 다른 사람의 채팅
									content = "<p class='chat-box bg-light p-3'>"
											+ vo.chatMsg + "</p>";

									html = "<li class='pl-2'>"
											+ "<strong>"
											+ vo.memNick
											+ "</strong>"
											+ "<div>"
											+ content
											+ "<strong style='display : inline;' class='align-self-center'>"
											+ date + "</strong>" + "</div>"
											+ "</li>";
								}
								return html;
							}

							// socket 관련
							var chatBox = $('.box');
							var messageInput = $('#msgi');
							var roomNo = "${room.roomNo}";
							var member = $('.content').data('member');

							// 소켓 통신 객체 생성 (sockjs 객체에 WebSocketConfig에서 설정한 /endpoint 주소 입력)
							var sock = new SockJS(
									"${pageContext.request.contextPath}/endpoint");
							// sockjs 객체로부터 stomp 객체 생성
							client = Stomp.over(sock);

							// 메시지 전송
							function sendmsg() {
								var message = messageInput.val();

								if (message == "") {
									alert("메세지를 입력해 주세요")
									return false;
								}

								console.log("보낸 메세지:",
												{
													chatMsg : message,
													memId : "${sessionScope.memInfo.memId}",
													memNick : "${sessionScope.memInfo.memNick}",
													roomNo : "${room.roomNo}"
												});

								// 실질적으로 메시지 전달하는 시점과 그 데이터
								// WebSocketConfig에 의해 /app 을 인식하여 ChatLogController의 /hello/{roomNo} 로 요청을 보낸다.
								// 이후 ChatLogController 에서 아래의 /subscribe/chat/{roomNo} 주소로 응답을 보낸다.
								client.send('/app/hello/' + roomNo,	{}, JSON.stringify({
															chatMsg : message,
															memId : "${sessionScope.memInfo.memId }",
															memNick : "${sessionScope.memInfo.memNick }",
															roomNo : "${room.roomNo}"
														}));

								messageInput.val('');
							}

							// 연결이 맺어지면 실행
							client.connect(
											{},
											function() {
												// 상대방이 보낸 메세지 전달 받을 때마다 실행         
												client
														.subscribe(
																'/subscribe/chat/'
																		+ roomNo,
																function(chat) {
																	// 받은 데이터
																	let content = JSON
																			.parse(chat.body);

																	// 받은 데이터를 그려줄 html 코드
																	let v_tag = renderList(content);
																	$(
																			"#chatList")
																			.append(
																					v_tag);

																	// 채팅이 추가되면 스크롤을 맨 아래로 내림
																	$(
																			".chatcontent")
																			.scrollTop(
																					$(".chatcontent")[0].scrollHeight);
																});

											});

							// 메시지 전송 버튼 클릭시
							$('#btnSend').click(function() {
								sendmsg();
							});

							// 채팅 입력하다 엔터 쳤을 때
							$('#msgi').keydown(function(e) {
								// 엔터키 keyCode = 13
								if (e.keyCode == 13) {
									sendmsg();
								}
							});

							// 채팅창 떠날시 소켓 통신 종료 함수
							function disconnect() {
								if (client != null) {
									// stomp 객체의 연결 종료
									client.disconnect();
									// sockjs 객체 닫기
									sock.close();
								}
							}

							// 현재 창을 벗어나기 직전에 실행됨
							window.onbeforeunload = function(e) {
								disconnect();
							}

						});
		// 다운로드 버튼 클릭 이벤트
		$('#downloadBtn').click(function () {
		    var roomNo = "${room.roomNo}";
		    // 다운로드 요청
		    window.location.href = "${pageContext.request.contextPath}/downloadChatLog?no=" + roomNo;
		});

	</script>
</body>
</html>

