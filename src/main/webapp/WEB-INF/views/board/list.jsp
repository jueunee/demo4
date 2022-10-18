<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Board List</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<%--    <script src="webjars/jquery/dist/jquery.min.js"></script>--%>

</head>
<style>
    table {
        width: 100%;
        border: 1px solid #444444;
        border-collapse: collapse;
    }
    tr, th, td {
        border: 1px solid #444444;
        padding: 10px;
    }
    ul {
        list-style:none;
        float:left;
        display:inline;
    }
    ul li {
        float:left;
    }
    ul li a {
        float:left;
        padding:4px;
        margin-right:3px;
        width:15px;
        color:#000;
        font:bold 12px tahoma;
        border:1px solid #eee;
        text-align:center;
        text-decoration:none;
    }
    ul li a:hover, ul li a:focus {
        color:#fff;
        border:1px solid #f40;
        background-color:#f40;
    }
</style>
<body>


<div>
    <!-- Page Heading -->
    <h1>Tables</h1>
    <p style="color : black; font-weight: bold"><a href="/logout">로그아웃</a></p>
    <!-- DataTales Example -->
    <div>
        <div>
            <h2>Board List</h2>
        </div>
        <p>${member.user_id}님 </p>
        <input type="hidden" id="session" value="${member.user_id}">
        <span>총게시물 ${totCnt} / 페이지 (${searchVO.pageIndex} / ${totalPageCnt})</span>
        <div>
            <div>
                <table id="dataTable">
                    <thead>
                    <tr>
                        <th>No</th>
                        <th>Title</th>
                        <th>Content</th>
                        <th>Writer</th>
                        <th>RegisteredDate</th>
                        <th>UpdatedDate</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="list" items="${boardList}">
                        <tr>
                            <td><c:out value="${list.idx}"/></td>
                            <td>
                                <a href="/board/read?idx=${list.idx} & ${ searchVO.qustr }" >
                                    <c:out value="${list.title}"/></a>
                            </td>
                            <td><c:out value="${list.content}"/></td>
                            <td><c:out value="${list.writer}"/></td>
                            <td><fmt:formatDate pattern="yyyy/MM/dd/hh:mm" value="${list.regdate}"/></td>
                            <td><fmt:formatDate pattern="yyyy/MM/dd" value="${list.updatedate}"/></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <a href="/board/create">등록</a>
                <%--paging--%>
                <form method="get" class="listform" action="/board/list">
                <%---id에서 class 바꿨더니 됐음--%>
                    <input type="hidden" id="pageIndex" name="pageIndex" val=""/>
                </form>
                <div style="text-align:right">
                    <div id="dataTable_paginate">
                        <ul class="pagination">
                            <c:if test="${searchVO.prev}">
                                <li id="dataTable_previous">
                                    <a href="javascript:void(0);" onclick="fn_go_page(${searchVO.startDate - 1}); return false;" aria-controls="dataTable" data-dt-idx="0" tabindex="0" class="page-link">Previous</a>
                                </li>
                            </c:if>

                            <c:forEach var="num" begin="${searchVO.startDate}" end="${searchVO.endDate}">
                                <li>
                                    <a href="javascript:void(0);" onclick="fn_go_page(${num}); return false;" aria-controls="dataTable" data-dt-idx="0" tabindex="0" class="page-link">${num}</a>
                                </li>
                            </c:forEach>

                            <c:if test="${searchVO.next}">
                                <li id="dataTable_next">
                                    <a href="javascript:void(0);" onclick="fn_go_page(${searchVO.endDate + 1}); return false;" aria-controls="dataTable" data-dt-idx="0" tabindex="0" class="page-link">Next</a>
                                </li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<script>
    $(document).ready(function() {
    console.log("test");

        let thisIndex = "${searchVO.pageIndex}"
        $(".pagination li a").each(function(){
            let idx = $(this).parent().index();
            let thistitle = $(this).attr("title");
            if(thistitle == thisIndex){
                $(".pagination").find("li").eq(idx);
            }
        });
    });

    function fn_go_page(pageNo) {
        console.log('page No : ' + pageNo)
        $("#pageIndex").val(pageNo);
        $(".listform").submit();
        console.log("?")
        return false;
    }
    function fn_search() {
        $("#pageIndex").val("1");
        $(".listForm").submit();
        return false;
    }
</script>


</body>
</html>
