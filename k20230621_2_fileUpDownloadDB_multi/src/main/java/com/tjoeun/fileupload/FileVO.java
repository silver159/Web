package com.tjoeun.fileupload;

// VO(Value Object) 클래스 => 데이터 1건과 데이터를 처리하기 위한 메소드를 기억하는 클래스
// 데이터를 저장해서 전송한다고 해서 DTO(Data Transfer Object)라고 부르기도 한다.
// bean => 자바로 처리하는 최소한의 작업 단위로 데이터를 기억하는 필드 (멤버 변수)와 필드에
// 저장된 데이터를 입출력하는 getters & setters 메소드로만 구성된 클래스

// 메인글 1건을 기억하는 클래스
public class FileVO {
	
	// 필드 선언
	// 필드 이름은 데이터베이스 테이블의 필드 이름, html form을 구성하는 요소들의 name 속성값과
	// 반드시 같은 이름으로 만들어야 한다.
	
	private int idx;
	private String filename;
	private String filerealname;
	private int downloadcount;
	
	// getters & setters
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilerealname() {
		return filerealname;
	}
	public void setFilerealname(String filerealname) {
		this.filerealname = filerealname;
	}
	public int getDownloadcount() {
		return downloadcount;
	}
	public void setDownloadcount(int downloadcount) {
		this.downloadcount = downloadcount;
	}
	
	// toString() 메소드 Override
	@Override
	public String toString() {
		return "FileuploadVO [idx=" + idx + ", filename=" + filename + ", filerealname=" + filerealname
				+ ", downloadcount=" + downloadcount + "]";
	}
}
