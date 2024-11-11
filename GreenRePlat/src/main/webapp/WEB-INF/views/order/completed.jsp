<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript">
        window.opener.onPaymentComplete()  // 부모 창 함수 실행
        window.close();  // 현재 창을 닫기
    </script>
</head>
<body>
    <!-- 페이지는 사실 보이지 않게 될 것입니다. 자바스크립트 코드로 창을 닫기 때문에 -->
</body>
</html>