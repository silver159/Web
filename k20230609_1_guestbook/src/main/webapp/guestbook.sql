  CREATE TABLE "GUESTBOOK" (	
	"IDX" NUMBER(*,0) NOT NULL, 
	"NAME" CHAR(20 BYTE) NOT NULL, 
	"PASSWORD" CHAR(20 BYTE) NOT NULL, 
	"MEMO" VARCHAR2(3000 BYTE) NOT NULL, 
	"WRITEDATE" TIMESTAMP(6) DEFAULT sysdate, 
	"IP" CHAR(15 BYTE), 
	 CONSTRAINT "GUESTBOOK_PK" PRIMARY KEY ("IDX")
  );

-- '--' �ּ�
-- ������ �ʱ�ȭ ���
-- ��� �����͸� �����ϰ� �������� �ٽ� �����.
delete from guestbook;
drop sequence guestbook_idx_seq;
-- �ڵ����� 1�� �����ϴ� ������ ����� (���̺��̸�_�ʵ��̸�_seq)
create sequence guestbook_idx_seq;

-- �������̸�.nextval: ������ ���� 1 ���� ��Ų��.
insert into guestbook(idx, name, password, memo, ip) 
values (guestbook_idx_seq.nextval, 'ȫ�浿', '1111', '1���Դϴ�.','192.168.0.075');
insert into guestbook(idx, name, password, memo, ip) 
values (guestbook_idx_seq.nextval, '�Ӳ���', '2222', '2���Դϴ�.','192.168.0.076');
insert into guestbook(idx, name, password, memo, ip) 
values (guestbook_idx_seq.nextval, '����', '3333', '3���Դϴ�.','192.168.0.077');
insert into guestbook(idx, name, password, memo, ip) 
values (guestbook_idx_seq.nextval, '������', '4444', '4���Դϴ�.','192.168.0.078');
rollback;
select * from guestbook;
select * from guestbook order by idx desc;
select count(*) from guestbook;

-- Ʈ������� �� ���� ��� ����Ǿ�� �� ����� ������ ���Ѵ�.
-- commit: Ʈ������� ��� ���������� ó���Ǽ� ����� �����ͺ��̽��� �ݿ��Ѵ�.
-- rollback: Ʈ������� ��� ���������� ó������ �ʾ��� ��� ���� ���� ���� �������� �ǵ�����.
-- ����Ŭ �𺧷��۴� auto commit�� �������� �ʱ� ������ �𺧷��ۿ��� ������ �۾��� jsp�� ����ǰ�
-- �Ϸ��� �ݵ�� commit ����� �����ؾ� �Ѵ�.
commit;

SELECT * from (
    SELECT ROWNUM rnum, TT.* from(
        select * from guestbook order by idx desc
    ) TT where rownum <= 20
) where rnum >= 11;









