-- ������ �ʱ�ȭ ���
-- ��� �����͸� �����ϰ� �������� �ٽ� �����.
delete from freeboard;
drop sequence freeboard_idx_seq;
-- �ڵ����� 1�� �����ϴ� ������ ����� (���̺��̸�_�ʵ��̸�_seq)
create sequence freeboard_idx_seq;


select * from freeboard order by idx desc;
select count(*) from freeboard;
select * from freeboard where notice = 'YES' order by idx desc;

insert into freeboard (idx, name, password, subject, content, notice, ip) 
		values (freeboard_idx_seq.nextval, 'ȫ�浿', '1111', '1��', '1�� �Դϴ�.', 'NO', '192.168.000.175');
insert into freeboard (idx, name, password, subject, content, notice, ip) 
		values (freeboard_idx_seq.nextval, '�Ӳ���', '2222', '2��', '2�� �Դϴ�.', 'NO', '192.168.000.176');
insert into freeboard (idx, name, password, subject, content, notice, ip) 
		values (freeboard_idx_seq.nextval, '����', '3333', '3��', '3�� �Դϴ�.', 'NO', '192.168.000.177');
insert into freeboard (idx, name, password, subject, content, notice, ip) 
		values (freeboard_idx_seq.nextval, '������', '4444', '4��', '4�� �Դϴ�.', 'NO', '192.168.000.178');

delete from freeboard where idx = '906';

update freeboard set notice = 'YES' where idx = '121';

commit;
rollback;

















