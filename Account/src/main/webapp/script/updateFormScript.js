/**
 * 
 */
function updateCheck(){
/*  비밀번호와 비밀번호 확인이 일치하지않을때  */
	if(document.update_frm.pw.value != document.update_frm.pwCon.value){
		alert("비밀번호가 일치하지 않습니다");
		update_frm.pw.focus();
		return false;
	}
/*  비밀번호가 빈칸일때  */
	if(document.update_frm.pw.value == ""){
		alert("비밀번호를 입력해주세요");
		update_frm.pw.focus();
		return false;
	}
	alert("수정완료");
	return true;	
	/*	
	if(document.update_frm.pw.value == * + "@" + *){
		alert("이메일을 다시 입력해주세요");
		update_frm.email.focus();
	} */
}
