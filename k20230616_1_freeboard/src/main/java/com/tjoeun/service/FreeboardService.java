package com.tjoeun.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.tjoeun.dao.FreeboardDAO;
import com.tjoeun.mybatis.MySession;
import com.tjoeun.vo.FreeboardList;
import com.tjoeun.vo.FreeboardVO;

public class FreeboardService {
	// singleton 패턴
	private static FreeboardService instance = new FreeboardService();
	private FreeboardService() {}
	public static FreeboardService getInstance() {
		return instance;
	}
	
// insertOK.jsp에서 호출되는 메인글이 저장된 객체를 넘겨받고 mapper를 얻어온 후 메인글을 
// 저장하는 FreeboardDAO 클래스의 insert sql 명령을 실행하는 메소드를 호출하는 메소드
	public void insert(FreeboardVO vo) {
		System.out.println("FreeboardService 클래스의 insert()메소드 실행");
		SqlSession mapper = MySession.getSession();
		FreeboardDAO.getInstance().insert(mapper, vo);
		// System.out.println(mapper);
		mapper.commit();
		mapper.close();
	}
	
// list.jsp에서 호출되는 브라우저에 출력할 페이지 번호를 넘겨받고 mapper를 얻어온 후 1페이지 
// 분량의 메인글 목록을 얻어오는 FreeboardDAO 클래스의 select sql 명령을 실행하는 메소드를  
// 호출하는 메소드
	public FreeboardList selectList (int currentPage) {
		System.out.println("FreeboardService 클래스의 selectList()메소드 실행");
		SqlSession mapper = MySession.getSession();
		FreeboardDAO dao = FreeboardDAO.getInstance();
	
		// 1페이지당 표시할 글의 개수를 정한다.
		int pageSize = 10;
		// 테이블에 저장된 전체 글의 개수를 얻어온다.
		int totalCount = dao.selectCount(mapper);
		//System.out.println(totalCount);

		// pageSize, totalCount, currentPage를 GuestbookList 클래스의 생성자로 넘겨서
		// 1페이지 분량의 글 목록을 저장하고 페이징 작업에 사용할 8개의 변수를 초기화하는
		// GuestbookList 클래스 객체를 생성한다.
		FreeboardList freeboardList =  new FreeboardList(pageSize, totalCount, currentPage);
		// parameterType, resultType은 데이터 타입을 반드시 1개만 적어야 한다.
		// xml 파일의 sql 명령으로 전달할 데이터가 2개 이상일 경우 데이터 타입이 같다면
		// HashMap 객체에 저장해서 전달하면 되고 데이터 타입이 다르다면 클래스 객체에 
		// 저장해서 전달하면 된다.
		HashMap<String, Integer> hmap = new HashMap<>();
		hmap.put("startNo", freeboardList.getStartNo());
		hmap.put("endNo", freeboardList.getEndNo());
		
		// 1페이지 분량의 글 목록을 얻어와서 FreeboardList 클래스 객체의 ArrayList(list)에
		// 저장한다.
		freeboardList.setList(dao.selectList(mapper, hmap));
		System.out.println(freeboardList);
		mapper.close();
		return freeboardList;
	}
	
// increment.jsp에서 호출되는 조회수를 증가시킬 페이지 번호를 넘겨받고 mapper를 얻어온 후 메인글의
// 조회수를 증가시키는 FreeboardDAO 클래스의 update sql 명령을 실행하는 메소드를 호출하는 메소드 
	public void increment (int idx) {
		System.out.println("FreeboardService 클래스의 increment()메소드 실행");
		SqlSession mapper = MySession.getSession();
		FreeboardDAO.getInstance().increment(mapper, idx);
		mapper.commit();
		mapper.close();
	}
	
// selectByIdx.jsp에서 호출되는 조회수를 증가시킨 글번호를 넘겨받고 mapper를 얻어온 후 메인글
// 1건을 얻어오는 FreeboardDAO 클래스의 select sql 명령을 실행하는 메소드를 호출하는 메소드
	public FreeboardVO selectByIdx (int idx) {
		System.out.println("FreeboardService 클래스의 selectByIdx()메소드 실행");
		SqlSession mapper = MySession.getSession();
		FreeboardVO vo = FreeboardDAO.getInstance().selectByIdx(mapper, idx);
		mapper.close();
		return vo;
	}

// deleteOK.jsp에서 호출되는 삭제할 글번호를 넘겨받고 mapper를 얻어온 후 메인글 1건을
// 삭제하는 FreeboardDAO 클래스의 delete sql 명령을 실행하는 메소드를 호출하는 메소드 	
	public void delete (int idx) {
		System.out.println("FreeboardService 클래스의 delete()메소드 실행");
		SqlSession mapper = MySession.getSession();
		FreeboardDAO.getInstance().delete(mapper, idx);
		mapper.commit();
		mapper.close();
	}

// updateOK.jsp에서 호출되는 수정할 정보가 저장된 객체를 넘겨받고 mapper를 얻어온 후 메인글 
// 1건을 수정하는 FreeboardDAO 클래스의 update sql 명령을 실행하는 메소드를 호출하는 메소드 
	public void update (FreeboardVO vo) {
		System.out.println("FreeboardService 클래스의 update()메소드 실행");
		SqlSession mapper = MySession.getSession();
		FreeboardDAO.getInstance().update(mapper, vo);
		mapper.commit();
		mapper.close();
	}

// list.jsp에서 호출되는 mapper를 얻어온 후 모든 공지글 목록을 얻어오는 FreeboardDAO 클래스의
// select sql 명령을 실행하는 메소드를 호출하는 메소드 
	public ArrayList<FreeboardVO> selectNotice() {
		System.out.println("FreeboardService 클래스의 selectNotice()메소드 실행");
		SqlSession mapper = MySession.getSession();
		ArrayList<FreeboardVO> notice = FreeboardDAO.getInstance().selectNotice(mapper);
//		System.out.println(notice);
		mapper.close();
		return notice;
	}
	
}
