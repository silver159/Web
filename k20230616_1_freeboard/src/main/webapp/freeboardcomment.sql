-- ������ �ʱ�ȭ ���
-- ��� �����͸� �����ϰ� �������� �ٽ� �����.
delete from freeboardcomment;
drop sequence freeboardcomment_idx_seq;
-- �ڵ����� 1�� �����ϴ� ������ ����� (���̺��̸�_�ʵ��̸�_seq)
create sequence freeboardcomment_idx_seq;

select * from freeboardcomment order by idx desc;
select count(*) from freeboardcomment;
