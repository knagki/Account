function loginCheck() {
	if(document.frm.userid.value.length == 0){
		alert("아이디를 입력해주세요.");
		document.frm.userid.focus();
		return false;
	}
	
	if(document.frm.pwd.value == ""){
		alert("비밀번호를 입력해주세요.");
		document.frm.pwd.focus();
		return false;
	}
	
	return true;
}

function alertLogin() {
	alert("로그인 후 이용해 주세요");
	return false;
}