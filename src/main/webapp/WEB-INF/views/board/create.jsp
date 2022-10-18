
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Board Register</title>
</head>

<body>
<div class="row" style="margin-bottom:20px; margin-left:1px;">
    <div class="col-lg-12">
        <h1 class="page-header">등록 페이지</h1>
    </div>
</div>

<div class="panel" style="margin-left:1px;">

    <form role="form" action="/board/create_action" method="post">
        <div class="table-responsive" style="text-align:center;">
            <table id="datatable-scroller"
                   class="table table-bordered tbl_Form">
                <tbody>
                <tr>
                    <th>작성자</th>
                    <td>
                        <input type="text" id="writer" name="writer" class="form-control" style="width: 200px" />
                    </td>
                </tr>
                <tr>
                    <th>제목</th>
                    <td>
                        <input type="text" id="title" name="title" class="form-control" style="width: 640px" />

                    </td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td><textarea
                            id="content" name="content" cols="100" rows="10"
                            class="form-control"></textarea></td>
                </tr>
                </tbody>
            </table>
        </div>
        <div style="margin-left:1px;">
            <button type="submit" class="btn btn-primary">등록</button>
            <a href="/board/list" class="btn btn-danger">취소</a>
        </div>
    </form>
</div>

</body>
</html>
