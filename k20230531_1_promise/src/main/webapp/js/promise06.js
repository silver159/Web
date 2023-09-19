class UserStorage {
	
	// 로그인 함수
	
	/*
	// callback 지옥
	// loginUser(아이디, 비밀번호, 로그인 성공시 실행할 callback 함수, 로그인 실패시 실행할 callback 함수)
	loginUser(id, password, onSuccess, onError){
		setTimeout(() => {
			if (id == '홍길동' && password == '1111' || id == '임꺽정' && password == '2222'){
				onSuccess(id)
			}else{
				onError('로그인 실패')
			}
		}, 2000);
	}
	*/
	// promise
	// callback 지옥에 빠진 이유는 함수가 성공시 실행할 함수와 실패시 실행할 함수를 인수로
	// 받았기 때문이다.
	// promise를 사용하면 성공시 resolve()로 실패시 reject()로 처리하면 된다.
	loginUser(id, password){
		// 함수가 호출되면 promise를 만들어서 리턴시킨다.
		return new Promise((resolve,reject) => {
			// 기존에 있던 코드를 promise의 excutor 함수에서 실행한다.
			setTimeout(() => { // 비동기 처리
				if (id == '홍길동' && password == '1111' || id == '임꺽정' && password == '2222'){
					// onSuccess(id); 사용하지 않는다.
					resolve(id);
				}else{
					// onError('로그인 실패')
					reject('로그인 실패');
				}
			}, 2000);
		});
	}
	
	// 로그인 후 권한을 받아오는 함수
	/*
	// callback 지옥
	// getRoles(아이디, 권한을 받아오면 실행할 callback 함수, 권한을 받아오지 못하면 실행할 callback 함수)
	getRoles(user, onSuccess, onError){
		setTimeout(function () { // 비동기 처리
			if (user == '홍길동'){
				onSuccess({
					name: '홍길동',
					role: '관리자',
				})
			}else{
				onError('권한이 없습니다.');
			}
		}, 1000);
	}	
	*/
	// promise
	getRoles(user){
		// 함수가 호출되면 promise를 만들어서 리턴시킨다.
		return new Promise((resolve, reject) => {
			// 기존에 있던 코드를 promise의 excutor 함수에서 실행한다.
			setTimeout(() => { // 비동기 처리
				if (user == '홍길동'){
					// onSuccess({
					resolve({
						name: '홍길동',
						role: '관리자',
					});
				}else{
					// onError('권한이 없습니다.');
					reject('권한이 없습니다.');
				}
			}, 1000);
		});
	}	
}

// id와 password를 입력 받는다.
const id = prompt('아이디를 입력하세요');
const password = prompt('비밀번호를 입력하세요');

// 로그인 처리를 하기 위해서 loginUser() 함수가 작성된 클래스 객체를 생성한다.
const userStorage = new UserStorage();

/*
// callback 지옥
userStorage.loginUser(
	id, 
	password, 
	user => {
		console.log(user + ' 로그인 성공');
		userStorage.getRoles(
			user,
			userWithRole => {
				alert(`안녕하세요 ${userWithRole.name}님 당신의 권한은 ${userWithRole.role}입니다.`)
			}, 
			error => alert(error)
		);
	}, 
	console.log
);
*/

// promise
/*
userStorage.loginUser(id,password)
	.then(function (id){
		// console.log(id);
		return userStorage.getRoles(id);
	})
	.then(function (userWithRole){
		// console.log(userWithRole);
		alert(`안녕하세요 ${userWithRole.name}님 당신의 권한은 ${userWithRole.role}입니다.`)
	})
	.catch(function (e){
		console.log(e);
	})
*/
userStorage.loginUser(id,password)
	.then(id => userStorage.getRoles(id))
	.then(userWithRole => alert(`안녕하세요 ${userWithRole.name}님 당신의 권한은 ${userWithRole.role}입니다.`))
	.catch(console.log)











































