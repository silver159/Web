package com.tjoeun.vo;

import java.util.Date;

// VO(Value Object) 클래스 => 데이터 1건과 데이터를 처리하기 위한 메소드를 기억하는 클래스
// 데이터를 저장해서 전송한다고 해서 DTO(Data Transfer Object)라고 부르기도 한다.
// 게시글 1건을 기억하는 클래스
// bean => 자바로 처리하는 최소한의 작업 단위로 데이터를 기억하는 필드 (멤버 변수)와 필드에
// 저장된 데이터를 입출력하는 getters & setters 메소드로만 구성된 클래스
public class GuestbookVO {
	
	// 필드 선언
	// 필드 이름은 데이터베이스 테이블의 필드 이름, html form을 구성하는 요소들의 name 속성값과
	// 반드시 같은 이름으로 만들어야 한다.
	
	private int idx; // 글번호
	private String name; // 작성자
	private String password; // 비밀번호
	private String memo; // 게시글
	private Date writeDate; // 작성일
	private String ip; // 작성자 ip 주소
	
	// getters & setters
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	// toString() 메소드 Override
	@Override
	public String toString() {
		return "GuestbookVO [idx=" + idx + ", name=" + name + ", password=" + password + ", memo=" + memo
				+ ", writeDate=" + writeDate + ", ip=" + ip + "]";
	}
	
}
