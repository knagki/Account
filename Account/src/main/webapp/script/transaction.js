/**
 * 
 */
function AccountCheck() {
	return true;
}

function open_win(url) {
	window.open(url, '이체', "width=600, height=600");
}

function goAction() {
	window.opener.location.href = 'AccountServlet?command=transaction';

	window.opener.location.reload();

}

function transfer() {
	// 부모창 새로고침
	window.opener.location.reload();

	// 1초 후에 창을 닫습니다.
	setTimeout(function() {
		window.close();
	}, 1000);
}
// 출금 선택시 자동으로 내 계좌 번호로 설정
function setSenderAccount() {
	var senderAccount = document.getElementById("senderAccount");
	var receiverAccount = document.getElementsByName("receiver_account")[0];
	var transactionType = document.getElementById("transaction_type");
	if (senderAccount && receiverAccount && transactionType) {
		if (transactionType.value === "out") {
			receiverAccount.value = senderAccount.value;
			receiverAccount.readOnly = true;
		} else {
			receiverAccount.value = "";
			receiverAccount.readOnly = false;
		}
	}
}