<tbody class="table-group-divider">
    <c:forEach items="${keynotice}" var="notice">
        <tr>
            <th scope="row" class="ps-0 fw-medium">
                <span class="table-link1 text-truncate d-block">${notice.noticeNo}</span>
            </th>
            <td>
                <a href="/" class="link-primary text-dark fw-medium d-block">${notice.noticeTitle}</a>
            </td>
            <td class="text-center fw-medium">${notice.memId}(관리자)</td>
            <td class="text-center fw-medium">${notice.noticeCount}</td>

            <!-- 글 작성자와 로그인된 사용자 ID가 같으면 삭제 버튼 표시 -->
            <c:if test="${loggedInUserId == notice.memId}">
                <td>
                    <form action="${pageContext.request.contextPath}/deleteNotice" method="post">
                        <input type="hidden" name="noticeNo" value="${notice.noticeNo}" />
                        <button type="submit" class="btn btn-danger btn-sm">X</button>
                    </form>
                </td>
            </c:if>
        </tr>
    </c:forEach>
</tbody>
