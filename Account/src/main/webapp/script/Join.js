function checkInput() {
	const name = document.getElementById('name');
	const id = document.getElementById('id');
	const pswd1 = document.getElementById('pswd1');
	const pswd2 = document.getElementById('pswd2');
	const mobile = document.getElementById('mobile');

	if (name.value.trim() === '') {
		alert('이름을 입력하세요.');
		name.focus();
		return false;
	}

	if (id.value.trim() === '') {
		alert('아이디를 입력하세요.');
		id.focus();
		return false;
	} else if (id.value.length <= 8) {
		alert('8자리 이상 입력해주세요');
		id.value = '';
		id.focus();
		return false;
	}

	if (pswd1.value.trim() === '') {
		alert('비밀번호를 입력하세요.');
		pswd1.focus();
		return false;
	}

	if (pswd2.value.trim() === '') {
		alert('비밀번호를 재확인해주세요.');
		pswd2.focus();
		return false;
	}

	if (pswd1.value !== pswd2.value) {
		alert('비밀번호가 일치하지 않습니다.');
		pswd1.value = "";
		pswd2.value = "";
		pswd1.focus();
		return false;
	}

	if (mobile.value.trim() === '') {
		alert('휴대전화 번호를 입력하세요.');
		mobile.focus();
		return false;
	}

	alert('가입되었습니다!');
	return true;
}