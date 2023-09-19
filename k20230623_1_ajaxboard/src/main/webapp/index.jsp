<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>javascript ajax</title>
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
	<table class="table">
		<thead>
			<tr class="success">
				<th colspan="2" style="text-align: center; font-size: 25px;">회원가입</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th style="background-color: pink; vertical-align: middle;">이름</th>
				<td>
					<input 
						id="name" 
						class="form-control"
						type="text"
						autocomplete="off"
						placeholder="이름을 입력하세요."
					/>
				</td>
			</tr>
			<tr>
				<th style="background-color: tomato; vertical-align: middle;">나이</th>
				<td>
					<input 
						id="age" 
						class="form-control"
						type="text"
						autocomplete="off"
						placeholder="나이를 입력하세요."
					/>
				</td>
			</tr>
			
			<tr>
				<th style="background-color: dodgerblue; vertical-align: middle;">성별</th>
				<td>
					<div class="form-group" style="text-align: center; margin: 0px auto">
						<div class="btn-group" data-toggle="buttons">
							<label class="btn btn-primary">
								<input 
									type="radio" 
									name="gender" 
									value="남자"
								/>남자
							</label>
							<label class="btn btn-primary active">
								<input 
									type="radio" 
									name="gender" 
									value="여자"
									checked="checked"
								/>여자
							</label>
						</div>
					</div>
				</td>
			</tr>
			
			<tr>
				<th style="background-color: yellowgreen; vertical-align: middle;">이메일</th>
				<td>
					<input 
						id="email" 
						class="form-control"
						type="text"
						autocomplete="off"
						placeholder="이메일을 입력하세요."
					/>
				</td>
			</tr>
			<tr class="warning">
				<td colspan="2">
					<input 
						class="btn btn-danger pull-right" 
						type="button" 
						value="입력하기"
						onclick="insertFunction()"
					/>
				</td>
			</tr>
		</tbody>
	</table>
</div>
<!-- 회원 출력 양식 -->
<!-- 검색어 입력 -->
<div class="container" style="margin-top: 20px;">
	<div class="form-group row pull-right"> <!-- row 12 -->
		<div class="col-xs-8">
			<input 
				id="username" 
				class="form-control" 
				type="text" 
				size="20" 
				onkeyup="searchFunction()"
				autocomplete="off" 
			/> <!-- 자동완성 기능 지원x -->
		</div>
		<div class="col-xs-2">
			<input 
				class="btn btn-primary" 
				type="button" 
				value="검색" 
				onclick="searchFunction()"
			/>
		</div>
	</div>
</div>
<!-- 검색 결과 출력 -->
<div class="container">
	<table class="table table-hover"><!-- table-hover 마우스 커서 올라갈 때 색 변경 -->
		<thead>
			<tr class="info">
				<th style="text-align: center;">번호</th>
				<th style="text-align: center;">이름</th>
				<th style="text-align: center;">나이</th>
				<th style="text-align: center;">성별</th>
				<th style="text-align: center;">이메일</th>
			</tr>
		</thead>
		<tbody id="ajaxTable">
			<tr></tr>
		</tbody>
	</table>
</div>

</body>
</html>