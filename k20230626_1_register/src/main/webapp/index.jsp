<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jQuery ajax</title>
<!-- 반응형 웹 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<!-- 파비콘 -->
<link rel="icon" href="./images/ic_file.gif">
<!-- bootstrap -->
<link rel="stylesheet" href="./css/bootstrap.css">
<!-- jQury -->
<script type="text/javascript" src="./js/jquery-3.7.0.js"></script>
<!-- bootstrap -->
<script type="text/javascript" src="./js/bootstrap.js"></script>
<!-- ajax 구현 -->
<script type="text/javascript" src="./js/ajax.js"></script>
</head>
<body>

<!-- 회원 가입 양식 -->
<div class="container" style="margin-top: 20px;">
	<form action="./UserRegisger" method="post"><!-- ① -->
		<table class="table table-hover table-bordered" style="border: 1px solid #FF0000">
			<thead>
				<tr class="success">
					<th colspan="3" style="text-align: center;">
						<h2>회원 가입 양식</h2>
					</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th class="danger" style="vertical-align: middle; width: 120px;">아이디</th>
					<td>
						<input 
							id="userID" 
							class="form-control" 
							type="text" 
							name="userID"
							placeholder="아이디를 입력하세요."
							autocomplete="off"
						/>
					</td>
					<td class="info" 
						style="vertical-align: middle; width: 120px; text-align: center;">
						<button 
							class="btn btn-primary" 
							type="button" 
							onclick="">
							중복검사
						</button>
					</td>
				</tr>
				<tr>
					<th class="danger" style="vertical-align: middle;">비밀번호</th>
					<td colspan="2">
						<input 
							id="userPassword1" 
							class="form-control" 
							type="password" 
							name="userPassword1"
							placeholder="비밀번호를 입력하세요."
							autocomplete="off"
							onkeyup="passwordCheckFunction()"
						/>
					</td>
				</tr>
				<tr>
					<th class="danger" style="vertical-align: middle;">비밀번호 확인</th>
					<td colspan="2">
						<input 
							id="userPassword2" 
							class="form-control" 
							type="password" 
							name="userPassword2"
							placeholder="비밀번호를 입력하세요."
							autocomplete="off"
							onkeyup="passwordCheckFunction()"
						/>
					</td>
				</tr>
				<tr>
					<th class="danger" style="vertical-align: middle;">이름</th>
					<td colspan="2">
						<input 
							id="userName" 
							class="form-control" 
							type="text" 
							name="userName"
							placeholder="이름을 입력하세요."
							autocomplete="off"
						/>
					</td>
				</tr>
				<tr>
					<th class="danger" style="vertical-align: middle;">나이</th>
					<td colspan="2">
						<input 
							id="userAge" 
							class="form-control" 
							type="text" 
							name="userAge"
							placeholder="나이를 입력하세요."
							autocomplete="off"
						/>
					</td>
				</tr>
				<tr>
					<th class="danger" style="vertical-align: middle;">성별</th>
					<td colspan="2">
						<div class="form-group" style="text-align: center; margin: 0px auto">
							<div class="btn-group" data-toggle="buttons">
								<label class="btn btn-primary">
									<input 
										type="radio" 
										name="userGender" 
										value="남자"
									/>남자
								</label>
								<label class="btn btn-primary active">
									<input 
										type="radio" 
										name="userGender" 
										value="여자"
										checked="checked"
									/>여자
								</label>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<th class="danger" style="vertical-align: middle;">이메일</th>
					<td colspan="2">
						<input 
							id="userEmail" 
							class="form-control" 
							type="email" 
							name="userEmail"
							placeholder="이메일을 입력하세요."
							autocomplete="off"
						/>
					</td>
				</tr>
				<tr>
					<td colspan="3" style="text-align: center;">
						<!-- 비밀번호 일치 검사 결과 메시지가 출력될 영역 -->
						<h5 id="passwordCheckMessage" style="color: red; font-weight: bold;"></h5>
						<!-- 아이디 중복 검사 결과 메시지가 출력될 영역 -->
						<h5 id="idCheckMessage" style="color: red; font-weight: bold;"></h5>
						<!-- 오류 메시지가 출력될 영역 -->
						<h5 id="errorMessage" style="color: lime; font-weight: bold;">
							${messageType}: ${messageContent}
						</h5>
						<input class="btn btn-primary" type="submit" value="회원가입"> <!-- ① -->				
						<input class="btn btn-primary" type="reset" value="다시쓰기">					
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>

<% 
// session에 저장된 메시지를 얻어온다.
	String messageType = null;
	if(session.getAttribute("messageType") != null){
		messageType = (String) session.getAttribute("messageType"); // 영역변수는 object
		// out.println("messageType: "+messageType+"<br/>");
	}
	String messageContent = null;
	if(session.getAttribute("messageContent") != null){
		messageContent = (String) session.getAttribute("messageContent"); // 영역변수는 object
		// out.println("messageContent: "+messageContent+"<br/>");
	}
	
// session에 메시지가 있으면 메시지를 표시하는 모달 창을 띄운다.
	if(messageContent != null){
%>
<div id="messageModal" class="modal fade" role="dialog" aria-hidden="true">
	<div class="vertical-alignment-helper">
		<div class="modal-dialog vertical-align-center">
			<!-- 모달 창의 종류를 설정한다. -->
			<div class="modal-content <%=messageType.equals("성공 메시지")?"panel-success":"panel-warning"%>">
				<!-- 헤더 -->
				<div class="modal-header panel-heading">
					<!-- 헤더 오른쪽 상단에 "X" 버튼 표시 -->
					<button class="close" type="button" data-dismiss="modal">
						<span aria-hidden="ture">&times;</span>
						<span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">
						${messageType}
					</h4>
				</div>
				
				<!-- 바디 -->
				<div class="modal-body">
					${messageContent}
				</div>
				
				<!-- 풋터 -->
				<div class="modal-footer">
					<button class="btn btn-primary" type="button" data-dismiss="modal">닫기</button>
				</div>
				
			</div>
		</div>
	</div>
</div>

<!-- 이게 들어가야 모달창이 뜬다. 그리고 모달 밑에 있어야 한다. -->
<script type="text/javascript">
	$('#messageModal').modal('show');
</script>	
<% 
	}
%>


</body>
</html>





















