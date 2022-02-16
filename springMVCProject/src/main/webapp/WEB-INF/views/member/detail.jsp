<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원상세페이지</title>
<link rel = "stylesheet" href="${ pageContext.request.contextPath }/resources/css/layout.css" >
<link rel = "stylesheet" href="${ pageContext.request.contextPath }/resources/css/board.css" >

<style>
hr, table {
	width: 80%
}

.td_center {
	text-align: center;
}
</style>
<script>
	function updateMemberForm() {
		location.href = "update?mid=${member.id }"
	}

	function deleteMember() {
		location.href = "delete?mid=${member.id }";
	}

	function listMember() {
		location.href = "list";
	}
</script>
</head>
<body>
	<div align="center">
		<hr>
		<h2>회원 상세 페이지</h2>
		<hr>
		<br>
		<table border="1">
			<tr>
				<th>아이디</th>
				<td class="td_center">${ member.id }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td class="td_center">${ member.name }</td>
			</tr>
			<tr>
				<th width="100px">패스워드</th>
				<td class="td_center">${ member.password}</td>

			</tr>
			<tr>
				<th>이메일</th>
				<td class="td_center">${ member.email_id }${ member.email_domain }</td>
			</tr>
			<tr>
				<th>연락처</th>
				<td class="td_center">${ member.tel1 }${ member.tel2 }${ member.tel3 }</td>
			</tr>
			<tr>
				<th>우편번호</th>
				<td class="td_center">${ member.post }</td>
			</tr>
			<tr>
				<th>주소</th>
				<td class="td_center">${member.basic_addr}${member.detail_addr}</td>
			</tr>
			<tr>
				<th>등록일</th>
				<td class="td_center">${ member.reg_date }</td>
			</tr>
		</table>

		<br>
		<button onclick="updateMemberForm()">회원정보수정</button>
		<button onclick="deleteMember()">회원삭제</button>
		<button onclick="listMember()">목록으로</button>

	</div>
</body>
</html>