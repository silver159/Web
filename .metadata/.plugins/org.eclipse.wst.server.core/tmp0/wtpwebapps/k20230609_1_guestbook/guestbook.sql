  CREATE TABLE "GUESTBOOK" (	
	"IDX" NUMBER(*,0) NOT NULL, 
	"NAME" CHAR(20 BYTE) NOT NULL, 
	"PASSWORD" CHAR(20 BYTE) NOT NULL, 
	"MEMO" VARCHAR2(3000 BYTE) NOT NULL, 
	"WRITEDATE" TIMESTAMP(6) DEFAULT sysdate, 
	"IP" CHAR(15 BYTE), 
	 CONSTRAINT "GUESTBOOK_PK" PRIMARY KEY ("IDX")
  );

-- '--' 주석
-- 시퀀스 초기화 방법
-- 모든 데이터를 제거하고 시퀀스를 다시 만든다.
delete from guestbook;
drop sequence guestbook_idx_seq;
-- 자동으로 1씩 증가하는 시퀀스 만들기 (테이블이름_필드이름_seq)
create sequence guestbook_idx_seq;

-- 시퀀스이름.nextval: 시퀀스 값을 1 증가 시킨다.
insert into guestbook(idx, name, password, memo, ip) 
values (guestbook_idx_seq.nextval, '홍길동', '1111', '1등입니다.','192.168.0.075');
insert into guestbook(idx, name, password, memo, ip) 
values (guestbook_idx_seq.nextval, '임꺽정', '2222', '2등입니다.','192.168.0.076');
insert into guestbook(idx, name, password, memo, ip) 
values (guestbook_idx_seq.nextval, '장길산', '3333', '3등입니다.','192.168.0.077');
insert into guestbook(idx, name, password, memo, ip) 
values (guestbook_idx_seq.nextval, '일지매', '4444', '4등입니다.','192.168.0.078');
rollback;
select * from guestbook;
select * from guestbook order by idx desc;
select count(*) from guestbook;

-- 트랙잭션은 한 번에 모두 실행되어야 할 명령의 집합을 말한다.
-- commit: 트랜잭션이 모두 정상적으로 처리되서 결과를 데이터베이스에 반영한다.
-- rollback: 트랜잭션이 모두 정상적으로 처리되지 않았을 경우 최초 실행 상태 이전으로 되돌린다.
-- 오라클 디벨로퍼는 auto commit이 지원되지 않기 때문에 디벨로퍼에서 실행한 작업이 jsp에 적용되게
-- 하려면 반드시 commit 명령을 실행해야 한다.
commit;

SELECT * from (
    SELECT ROWNUM rnum, TT.* from(
        select * from guestbook order by idx desc
    ) TT where rownum <= 20
) where rnum >= 11;









