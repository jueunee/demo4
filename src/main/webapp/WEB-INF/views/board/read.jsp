<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>상세 페이지</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<style>
  table {
    width: 40%;
    border: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border: 1px solid #444444;
    padding: 10px;
  }
</style>

<body>
<div style="margin-bottom:20px; margin-left:1px;">
  <div>
    <h1>상세 페이지</h1>
  </div>
</div>
<div class="panel" style="margin-left:1px;">
  <form role="form" action="/board/create_action" method="post">
    <div style="text-align:center;">
      <table>
        <tbody>
        <tr>
          <th>작성자</th>
          <td>
            ${boardContents.writer}
          </td>
        </tr>
        <tr>
          <th>제목</th>
          <td>
            ${boardContents.title}
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
            ${boardContents.content}
          </td>
        </tr>
        </tbody>
      </table>
    </div>
    <div style="margin-left:1px;">
      <a href="/board/list? & ${searchVO.qustr}">목록</a>
      <a href="/board/update?idx=${boardContents.idx} & ${searchVO.qustr}">수정</a>
      <a href="javascript:void(0);" onclick="deleteConfirm();">삭제</a>
      <%--      링크가 작동하지 않게 하기위함--%>
    </div>
  </form>
<%--    댓글 시작--%>
    <ul>
      <c:forEach var="reply" items="${reply}">
        <li>
          <div>
            <p>${reply.writer}/${reply.regDate}</p>
            <p>${reply.content}</p>
          </div>
        </li>
      </c:forEach>
    </ul>

    <div>
      <form method="post" action="/reply/write" >
        <p>
          <label>댓글 작성자</label> <input type="text" name="writer">
        </p>
        <p>
          <textarea rows="5" cols="50" name="content"></textarea>
        </p>
        <p>
          <input type="hidden" name="idx" value="${boardContents.idx}">
          <button type="submit" >댓글 작성</button>
        </p>
      </form>
    </div>

</div>
<script>
  $(document).ready(function() {

    var msg = "${msg}";

    if (msg != "") {
      alert(msg);
    }

  });
  function deleteConfirm(){

    if (!confirm("삭제 하시겠습니까?")) {
      return false;
    } else {
      location.href="${pageContext.request.contextPath }/board/delete?idx=${boardContents.idx} & ${searchVO.qustr}";
    }
  }


</script>
</body>
</html>
