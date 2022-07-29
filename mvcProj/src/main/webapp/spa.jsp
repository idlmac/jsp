<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동기, 비동기(Ajax) 방식</title>
</head>
<body>
	<h3>회원등록</h3>
	<form name="addFrm" action="addMemberAjax.do" method="post">
		아이디 : <input type="text" name="id"><br> 비밀번호 : <input
			type="password" name="passwd"><br> 이름 : <input
			type="text" name="name"><br> 이메일 : <input type="text"
			name="mail"><br> <input type="submit" value="저장">
	</form>
	<hr>
	<table border="1">
		<thead>
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody id="list"></tbody>
	</table>
	<!-- Ajax(비동기방식처리) -->
	<script>
		let i = 0;
		let xhtp = new XMLHttpRequest();
		xhtp.open('get', 'memberJson.do');
		xhtp.send();
		xhtp.onreadystatechange = callBackThree;

		let fields = ['id', 'passwd', 'name', 'mail'];
		
		function callBackThree() {
			if (this.readyState == 4 && this.status == 200) {
				let data = JSON.parse(this.responseText); // json타입에서 -> object타입으로 
				console.log(data);
				let tbody = document.getElementById('list');
				for(let obj of data) {
						tr = makeTr(obj);
						tbody.append(tr);
				}
			}
		}
		 // end of callBackThree
		
		// 데이터 받아서 tr 생성
		function makeTr(obj) {
			//tr, td, td, td, 
			let tr = document.createElement('tr');
			
			//필드 갯수 반복
			for(let field of fields) {
				let td1 = document.createElement('td');
				td1.innerText = obj[field];
				tr.append(td1);
			}
			
			//삭제 버튼
			let td1 = document.createElement('td');
			let btn = document.createElement('button');
			btn.innerText='삭제';
			// 클릭이벤트
			btn.addEventListener('click', deleteCallBack)
			td1.append(btn);
			tr.append(td1);
			
		return tr;
		}
		 
		 function deleteCallBack(e) {
			 console.log(this);	// Event의 Call함수(이벤트 받는 대상)
			 console.log(this.parentElement.parentElement.firstElementChild.innerText)
			 let delId = this.parentElement.parentElement.firstElementChild.innerText;
			 
			 let delAjx = new XMLHttpRequest();
			 delAjx.open('post', 'removeMemeberAjax.do');
			 delAjx.setRequestHeader('Content-type', 'application/x-www-form-urlencoded')
			 delAjx.send('id='+delId);
			 delAjx.onload = function() {
				 console.log(delAjx.responseText)
				let result = JSON.parse(delAjx.responseText);
				if(result.returnCode == 'Success')
			 		e.target.parentElement.parentElement.remove();
				else 
					alret('Error in processing')
			}
		 }
		
		function callBackTwo() {
			if (this.readyState == 4 && this.status == 200) {
				let data = JSON.parse(this.responseText); // json타입에서 -> object타입으로 
				console.log(data);
				
				let ul = document.createElement('ul'); // ul태그 만들기
				for(let obj of data) {
					let li = document.createElement('li');
					li.innerHTML = obj.name + ',' + obj.age;
					ul.append(li);
				}
				console.log(ul);
				document.querySelector('body').append(ul);
			}
		}

		function callBackOne() {
			if (this.readyState == 4 && this.status == 200) {
				let data = JSON.parse(this.responseText); // json타입에서 -> object타입으로 
				console.log(data);
				let name = document.createElement('p');
				name.innerText = data.name;
				let age = document.createElement('p');
				age.innerText = data.age;

				document.querySelector('body').append(name, age);
			}
		}
		
		// form 전송이벤트 실행
		document.forms.addFrm.onsubmit = function(e) {
			// 기본기능차단
			e.preventDefault();
			
			let url = document.forms.addFrm.getAttribute('action');
			let id = document.forms.addFrm.id.value;
			let passwd = document.forms.addFrm.passwd.value;
			let name = document.forms.addFrm.name.value;
			let mail = document.forms.addFrm.mail.value;
			let param = 'id='+id+'&passwd='+passwd+'&name='+name+'&mail='+mail;
			
			let addAjax = new XMLHttpRequest();
			addAjax.open('post', url);
			addAjax.setRequestHeader('Content-type', 'application/x-www-form-urlencoded')
			addAjax.send(param); // ex) id = user1&passwd=1234&name = Hong&mail=mail
			addAjax.onload = function() {
				console.log(addAjax.responseText);
				let data = JSON.parse(addAjax.responseText); // json => object
				// tbody태그의 id(list)
				document.getElementById('list').append(makeTr(data));
			}
		}
	</script>
</body>
</html>