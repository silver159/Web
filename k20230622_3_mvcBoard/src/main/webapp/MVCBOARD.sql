-- '--' �ּ�
-- ������ �ʱ�ȭ ���
-- ��� �����͸� �����ϰ� �������� �ٽ� �����.
delete from MVCBOARD;
drop sequence MVCBOARD_idx_seq;
-- �ڵ����� 1�� �����ϴ� ������ ����� (���̺��̸�_�ʵ��̸�_seq)
create sequence MVCBOARD_idx_seq;

insert into MVCBOARD (idx, name, subject, content, gup, lev, seq ) 
		values (MVCBOARD_idx_seq.nextval, 'ȫ�浿', '1��', '1�� �Դϴ�.', MVCBOARD_idx_seq.currval, 0 ,0 );
insert into MVCBOARD (idx, name, subject, content, gup, lev, seq ) 
		values (MVCBOARD_idx_seq.nextval, '�Ӳ���', '2��', '2�� �Դϴ�.', MVCBOARD_idx_seq.currval, 0 ,0 );
insert into MVCBOARD (idx, name, subject, content, gup, lev, seq ) 
		values (MVCBOARD_idx_seq.nextval, '����', '3��', '3�� �Դϴ�.', MVCBOARD_idx_seq.currval, 0 ,0 );
insert into MVCBOARD (idx, name, subject, content, gup, lev, seq ) 
		values (MVCBOARD_idx_seq.nextval, '������', '4��', '4�� �Դϴ�.', MVCBOARD_idx_seq.currval, 0 ,0 );


SELECT count(*) FROM MVCBOARD;
SELECT * FROM MVCBOARD order by gup desc, seq;

commit;







