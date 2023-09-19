package com.tjoeun.vo;

import java.util.ArrayList;

// 댓글 목록을 기억하는 클래스
public class FreeboardCommentList {
	
	private ArrayList<FreeboardCommentVO> list = new ArrayList<>();
	
	// getters & setters
	public ArrayList<FreeboardCommentVO> getList() {
		return list;
	}

	public void setList(ArrayList<FreeboardCommentVO> list) {
		this.list = list;
	}
	
	// toString() 메소드 Override
	@Override
	public String toString() {
		return "FreeboardCommentList [list=" + list + "]";
	}
}
