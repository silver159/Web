package com.tjoeun.vo;

// VO(Value Object) 클래스 => 데이터 1건과 데이터를 처리하기 위한 메소드를 기억하는 클래스
// 데이터를 저장해서 전송한다고 해서 DTO(Data Transfer Object)라고 부르기도 한다.
// 게시글 1건을 기억하는 클래스
// bean => 자바로 처리하는 최소한의 작업 단위로 데이터를 기억하는 필드 (멤버 변수)와 필드에
// 저장된 데이터를 입출력하는 getters & setters 메소드로만 구성된 클래스

// 카테고리 1건을 기억하는 클래스
public class CategoryVO {
	
	// 필드 선언
	// 필드 이름은 데이터베이스 테이블의 필드 이름, html form을 구성하는 요소들의 name 속성값과
	// 반드시 같은 이름으로 만들어야 한다.
	private int idx; // 카테고리 일련번호
	private String category; // 카테고리 이름
	private int gup; // 카테고리 그룹
	private int lev; // 카테고리 레벨
	private int seq; // 같은 가테고리 그룹에서 카테고리 출력 순서 
	private String deleteCheck = "NO"; // 카테고리 삭제여부(NO => 일발 카테고리, YES => 삭제한
	// 카테고리)
	private int deleteReport; // 신고 횟수
	
	// getters & setters
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getGup() {
		return gup;
	}
	public void setGup(int gup) {
		this.gup = gup;
	}
	public int getLev() {
		return lev;
	}
	public void setLev(int lev) {
		this.lev = lev;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getDeleteCheck() {
		return deleteCheck;
	}
	public void setDeleteCheck(String deleteCheck) {
		this.deleteCheck = deleteCheck;
	}
	public int getDeleteReport() {
		return deleteReport;
	}
	public void setDeleteReport(int deleteReport) {
		this.deleteReport = deleteReport;
	}
	
	// toString() 메소드 Override
	@Override
	public String toString() {
		return "CategoryVO [idx=" + idx + ", category=" + category + ", gup=" + gup + ", lev=" + lev + ", seq=" + seq
				+ ", deleteCheck=" + deleteCheck + ", deleteReport=" + deleteReport + "]";
	}
}
