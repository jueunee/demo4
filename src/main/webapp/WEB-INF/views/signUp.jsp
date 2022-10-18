<%--
  Created by IntelliJ IDEA.
  User: jekim
  Date: 2022-10-11
  Time: 오후 5:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up Page</title>
    <meta charset="UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<style>
    body {
        color: #fff;
        background: #3598dc;
        font-family: 'Roboto', sans-serif;
    }
    .modal-header, .close {
        background-color: #00C3FF;
        color:white !important;
        text-align: center;
        font-size: 30px;
    }

    .modal-body {
        background-color: #f9f9f9;
    }
    .modal-footer {
        background-color: #f9f9f9;
    }
    .form-control {
        height: 20px;
        background: #f2f2f2;
        box-shadow: none !important;
        border: none;
    }
    .form-control:focus {
        background: #e2e2e2;
    }
    .form-control, .btn {
        border-radius: 3px;
    }
    .signup-form {
        width: 400px;
        margin: 30px auto;
    }
    .signup-form form {
        color: #999;
        border-radius: 3px;
        margin-bottom: 15px;
        background: #fff;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
    }
    .signup-form h2  {
        color: #333;
        font-weight: bold;
        margin-top: 0;
    }
    .signup-form hr  {
        margin: 0 -30px 20px;
    }
    .signup-form .form-group {
        margin-bottom: 20px;
    }
    .signup-form input[type="checkbox"] {
        margin-top: 3px;
    }
    .signup-form .row div:first-child {
        padding-right: 10px;
    }
    .signup-form .row div:last-child {
        padding-left: 10px;
    }
    .signup-form .btn {
        font-size: 16px;
        font-weight: bold;
        background: #3598dc;
        border: none;
        min-width: 140px;
    }
    .signup-form .btn:hover, .signup-form .btn:focus {
        background: #2389cd !important;
        outline: none;
    }
    .signup-form a {
        color: #fff;
        text-decoration: underline;
    }
    .signup-form a:hover {
        text-decoration: none;
    }
    .signup-form form a {
        color: #3598dc;
        text-decoration: none;
    }
    .signup-form form a:hover {
        text-decoration: underline;
    }
    .signup-form .hint-text  {
        padding-bottom: 15px;
        text-align: center;
    }

</style>
<body>
<div class="signup-form">
    <form action="/signup" autocomplete="off" method="post">
        <h2>회원가입</h2>
        <p>Please fill in this form to create an account!</p>
        <hr>
        <div class="form-group">
            <input type="text" class="form-control" id="user_id" name="user_id" placeholder="4-15자리 입력하시오"
                   minlength="4" maxlength="15" required autofocus>
            <button id="overlappedID" type="button">중복확인</button>
            <span id="olmessage"></span><br>
        </div>
        <div class="form-group">
            <input type="password" id="password" name="password" placeholder="Password" required><br>
        </div>
        <div class="form-group">
            <button type="submit" id="join" class="btn btn-primary btn-lg" >회원가입</button>
        </div>
    </form>
</div>


<script>
    $("#overlappedID").click(function() {
        const id =$("#user_id").val();
        console.log(id)

            if (id.trim().length!=0) {
                $.ajax({
                    url : "/idCheck",
                    type : "get",
                    async: false,
                    data: {"id": id},
                    success : function(data){
                        if(data == 1) {
                            $("#olmessage").text("사용중인 아이디입니다.");
                            $("#olmessage").css("color","red");
                            $("#join").attr("disabled", "disabled");

                        } else {
                            $("#olmessage").text("사용 가능한 ID 입니다.");
                            $("#olmessage").css("color","blue");
                            $("#join").removeAttr("disabled");
                        }
                    }
                });
            }
        }
    );
</script>
</body>
</html>
