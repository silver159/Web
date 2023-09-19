  CREATE TABLE "CATEGORY" (	
    "IDX" NUMBER(*,0) NOT NULL, 
	"CATEGORY" VARCHAR2(100 BYTE) NOT NULL, 
	"GUP" NUMBER(*,0), 
	"LEV" NUMBER(*,0), 
	"SEQ" NUMBER(*,0),
    "DELETECHECK" CHAR(3 BYTE) DEFAULT 'NO',
    "DELETEREPORT" NUMBER(*,0) DEFAULT 0,
	 CONSTRAINT "CATEGORY_PK" PRIMARY KEY ("IDX")
  );


-- 시퀀스 초기화 방법
-- 모든 데이터를 제거하고 시퀀스를 다시 만든다.
delete from category;
drop sequence category_idx_seq;
-- 자동으로 1씩 증가하는 시퀀스 만들기 (테이블이름_필드이름_seq)
create sequence category_idx_seq;

select * from CATEGORY order by gup desc, seq;
select * from CATEGORY order by idx desc;
select count(*) from CATEGORY;

insert into category (idx, category, gup, lev, seq) 
values (category_idx_seq.nextval, '노트북', category_idx_seq.currval, 0,0);

commit;
rollback;





















