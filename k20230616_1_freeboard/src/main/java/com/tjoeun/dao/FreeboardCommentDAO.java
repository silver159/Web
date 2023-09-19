package com.tjoeun.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.tjoeun.vo.FreeboardCommentVO;

public class FreeboardCommentDAO {
	// singleton 패턴
	private static FreeboardCommentDAO instance = new FreeboardCommentDAO();
	private FreeboardCommentDAO() {}
	public static FreeboardCommentDAO getInstance() {
		return instance;
	}
	
// FreeboardCommentService 클래스에서 호출되는 mapper와 댓글 데이터가 저장된 객체를 넘겨받고 
// 댓글을 저장하는 freeboardcomment.xml 파일의 insert sql 명령을 실행하는 메소드
	public int insertComment(SqlSession mapper, FreeboardCommentVO co) {
		System.out.println("FreeboardCommentDAO 클래스의 insertComment()메소드 실행");
		// insert, delete, update sql 명령의 실행 결과를 리턴시키면 sql 명령이 성공적으로 
		// 실행된 횟수가 리턴된다. 
		return mapper.insert("insertComment", co);
	}
	
// FreeboardCommentService 클래스에서 호출되는 mapper와 메인글의 글번호를 넘겨받고 메인글의 
// 댓글의 갯수를 얻어오는 freeboardcomment.xml 파일의 select sql 명령을 실행하는 메소드
	public int commentCount(SqlSession mapper, int idx) {
		System.out.println("FreeboardCommentDAO 클래스의 insertComment()메소드 실행");
		return (int) mapper.selectOne("commentCount", idx);
	}
	
// FreeboardCommentService 클래스에서 호출되는 mapper와 메인글의 글번호를 넘겨받고 메인글의
// 댓글 목록을 얻어오는 freeboardcomment.xml 파일의 select sql 명령을 실행하는 메소드
	public ArrayList<FreeboardCommentVO> selectCommentList(SqlSession mapper, int idx) {
		System.out.println("FreeboardCommentDAO 클래스의 selectCommentList()메소드 실행");
		return (ArrayList<FreeboardCommentVO>) mapper.selectList("selectCommentList", idx);
	}
	
// FreeboardCommentService 클래스에서 호출되는 mapper와 댓글의 글 번호를 넘겨받고 댓글 1건을
// 얻어오는 freeboardcomment.xml 파일의 select sql 명령을 실행하는 메소드	
	public FreeboardCommentVO selectCommentByIdx(SqlSession mapper, int idx) {
		System.out.println("FreeboardCommentDAO 클래스의 selectCommentByIdx()메소드 실행");
		return (FreeboardCommentVO) mapper.selectOne("selectCommentByIdx", idx);
	}
	
// FreeboardCommentService 클래스에서 호출되는 mapper와 댓글을 수정할 정보가 저장된 객체를 
// 넘겨받고 댓글 1건을 수정하는 freeboardcomment.xml 파일의 update sql 명령을 실행하는 메소드	
	public void updateComment(SqlSession mapper, FreeboardCommentVO co) {
		System.out.println("FreeboardCommentDAO 클래스의 updateComment()메소드 실행");
		mapper.update("updateComment", co);
	}
	
// FreeboardCommentService 클래스에서 호출되는 mapper와 댓글을 삭제할 정보가 저장된 객체를 
// 넘겨받고 댓글 1건을 삭제하는 freeboardcomment.xml 파일의 delete sql 명령을 실행하는 메소드	
	public void deleteComment(SqlSession mapper, FreeboardCommentVO co) {
		System.out.println("FreeboardCommentDAO 클래스의 deleteComment()메소드 실행");
		mapper.delete("deleteComment", co);
	}
	
	
}
