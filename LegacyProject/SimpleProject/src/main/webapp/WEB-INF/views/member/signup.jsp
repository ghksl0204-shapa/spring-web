<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    
    <style> 
        .content { 
            background-color:rgb(247, 245, 245);
            width:80%; 
            margin:auto;
        }
        .innerOuter {
            border:1px solid lightgray;
            width:80%;
            margin:auto;
            padding:5% 10%;
            background-color:white;
        }
    </style>
</head>
<body>
    
    <!-- 메뉴바 -->
    <jsp:include page="../include/header.jsp" />
   	<script>
		function idCheck(){
			//console.log(123);	
			
			// 아이디 중복체크 구현하기 
			// 사용자가 입력한 아이디값
			
			const id = document.querySelector("#signup-form>#userId").value;
			//console.log(id);
			
			if(id.length > 4){
				fetch(`/spring/checkId?id=\${id}`)
					.then(response => response.json())
					.then(data =>{
						console.log(data)
						if(data.result === 'N'){
							$('#msg').css('font-size', '12px').css('color', 'red').text('이미 존재하는 아이디입니다.');
						}else{
							$('#msg').css('font-size', '12px').css('color', 'green').text('사용 가능한 아이디입니다.');
						}
					});
				
			}
		}
	</script>

    <div class="content">
        <br><br>
        <div class="innerOuter">
            <h2>회원가입</h2>
            <br>

            <form action="members" method="post">
                <div class="form-group" id="signup-form">
                    <label for="userId">* ID : </label>
                    <input type="text" class="form-control" id="userId" placeholder="Please Enter ID" name="userId" required
                    	   onkeyup="idCheck();"> 
                    	   <!-- onkeyup 키보드 입력 할때 마다 -->
                   	<label id="msg"></label><br>
					
                    <label for="userPwd">* Password : </label>
                    <input type="password" class="form-control" id="userPwd" placeholder="Please Enter Password" name="userPwd" required> <br>

                    <label for="checkPwd">* Password Check : </label>
                    <input type="password" class="form-control" id="checkPwd" placeholder="Please Enter Password" required> <br>

                    <label for="userName">* Name : </label>
                    <input type="text" class="form-control" id="userName" placeholder="Please Enter Name" name="userName" required> <br>

                    <label for="email"> &nbsp; Email : </label>
                    <input type="text" class="form-control" id="email" placeholder="Please Enter Email" name="email"> <br>

                </div> 
                <br>
                <div class="btns" align="center">
                    <button type="submit" class="btn btn-primary">회원가입</button>
                    <button type="reset" class="btn btn-danger">초기화</button>
                </div>
            </form>
        </div>
        <br><br>

    </div>

    <!-- 푸터바 -->
    <jsp:include page="../include/footer.jsp" />

</body>
</html>