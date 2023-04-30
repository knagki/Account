<%@page import="java.util.ArrayList"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.net.URLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String line = "";
ArrayList<String> deal_bas_r = new ArrayList<String>();
String authKey = "mFDSapp0UtFDVNrefJGWAkVi4pHIe8Vg";
String searchDate = "20230425";
String address = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON?authkey=" + authKey + "&searchdate="
		+ searchDate + "&data=AP01";
try {

	URL url = new URL(address);
	URLConnection urlConn = url.openConnection();

	InputStreamReader ir = new InputStreamReader(urlConn.getInputStream());
	BufferedReader br = new BufferedReader(ir);

	line = br.readLine();

	JSONParser parser = new JSONParser();
	JSONArray array = (JSONArray) parser.parse(line);
	for (int i = 0; i < array.size(); i++) {
		JSONObject arr = (JSONObject) array.get(i);

		if (arr.get("cur_unit").equals("USD") || arr.get("cur_unit").equals("JPY(100)")
		|| arr.get("cur_unit").equals("NZD")) {
	deal_bas_r.add((String) arr.get("deal_bas_r")); // 매매 기준율
		}
	}
	br.close();
	ir.close();
} catch (Exception e) {
	e.printStackTrace();
}
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/exchange.css" />
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#won').change(function() {
			var en = '<%=deal_bas_r.get(0)%>';
			var newDol = '<%=deal_bas_r.get(1)%>';
			var dol = '<%=deal_bas_r.get(2).replace(",", "")%>';
			var exchange = $('#won').val();
			
			if ($.isNumeric(exchange)) {
				$('#en').text('¥ ' + (exchange / (en / 100)).toFixed(2));
				$('#newDol').text('$ ' + (exchange / newDol).toFixed(2));
				$('#dol').text('$ ' + (exchange / dol).toFixed(2));
			} else {
				$('#en').text('');
				$('#newDol').text('');
				$('#dol').text('');
			}

		});
	});
</script>
<meta charset="UTF-8">
<title>환율 계산</title>
</head>
<body>
	<div class="container">
		<div>
			<ul>
				<li><button>메인페이지</button></li>
				<li><button>금액 이체</button></li>
				<li><button>상품 안내</button></li>
				<li><button onclick="location.href='AccountServlet?command=customerBoardFormAction'">1:1 문의하기</button></li>
			</ul>
			<ul>
				<li class="logout"><button>로그아웃</button></li>
			</ul>
		</div>
		<img src="images/bankBack.jpg" width="100%" height="90%">
		<table>
			<tr>
				<th><label for="won">한국 원화(KRW)</label></th>
				<th><label for="en">일본 엔화(JPY(100))</label></th>
				<th><label for="dol">미국 달러(USD)</label></th>
				<th><label for="newDol">뉴질랜드 달러(NZD)</label></th>
			</tr>
			<tr>
				<td><input type="text" name="won" id="won"
					style="width: 100px;" placeholder="원화 입력"></td>
				<td><div id="en"></div></td>
				<td><div id="dol"></div></td>
				<td><div id="newDol"></div></td>
			</tr>
		</table>
	</div>
</body>
</html>