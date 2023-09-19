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


-- ������ �ʱ�ȭ ���
-- ��� �����͸� �����ϰ� �������� �ٽ� �����.
delete from category;
drop sequence category_idx_seq;
-- �ڵ����� 1�� �����ϴ� ������ ����� (���̺��̸�_�ʵ��̸�_seq)
create sequence category_idx_seq;

select * from CATEGORY order by gup desc, seq;
select * from CATEGORY order by idx desc;
select count(*) from CATEGORY;

insert into category (idx, category, gup, lev, seq) 
values (category_idx_seq.nextval, '��Ʈ��', category_idx_seq.currval, 0,0);

commit;
rollback;





















