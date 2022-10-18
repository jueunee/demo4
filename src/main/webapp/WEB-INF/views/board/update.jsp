<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UPDATE</title>
</head>

<body>
<script>
    function _onSubmit() {

        if (!confirm("수정하시겠습니까?")) {
            return false;
        }
    }
</script>

<div style="margin-bottom:20px; margin-left:1px;">
    <div>
        <h1>수정 페이지</h1>
    </div>
</div>

<div style="margin-left:1px;">
    <form role="form" action="/board/update_action" method="post" onsubmit="return _onSubmit()">
        <input type="hidden" id="idx" name="idx" value="${boardContents.idx }"/>
        <input type="hidden" id="qustr" name="qustr" value="${ searchVO.qustr }"/>
        <div style="text-align:center;">
            <table id="datatable-scroller">
                <tbody>
                <tr>
                    <th>제목</th>
                    <td>
                        <input type="text" id="title" name="title" value="${boardContents.title}" style="width: 640px" />

                    </td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td>
                        <textarea id="content" name="content" value="${boardContents.content}" cols="100" rows="10"></textarea>
                    </td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td>
                        <input type="text" id="writer" name="writer" value="${boardContents.writer}" style="width: 200px" />
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <div style="margin-left:1px;">
            <button type="submit">수정</button>
            <a href="/board/read?idx=${boardContents.idx} & ${searchVO.qustr}">취소</a>
        </div>
    </form>
</div>

</body>
</html>
