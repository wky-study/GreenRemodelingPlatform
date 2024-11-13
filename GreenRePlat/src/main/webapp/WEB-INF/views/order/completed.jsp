<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript">
        window.close();  // 현재 창을 닫기
        
        // 부모 창에서 처리할 작업 (부모 창으로 페이지 변경)
        if (window.opener) {
            window.opener.location.href = '${pageContext.request.contextPath}/paymentDone';  // 부모 창에서 리디렉션
        }
    </script>
</head>
<body>
    <!-- 페이지는 사실 보이지 않게 될 것입니다. 자바스크립트 코드로 창을 닫기 때문에 -->
</body>
</html>