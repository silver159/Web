-- '--' �ּ�
-- ������ �ʱ�ȭ ���
-- ��� �����͸� �����ϰ� �������� �ٽ� �����.
delete from ajax;
drop sequence ajax_idx_seq;
-- �ڵ����� 1�� �����ϴ� ������ ����� (���̺��̸�_�ʵ��̸�_seq)
create sequence ajax_idx_seq;

insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, 'ȫ�浿', 20, '����', 'a@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '�Ӳ���', 21, '����', 'b@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '����', 22, '����', 'c@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '������', 23, '����', 'd@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, 'ȫ����', 20, '����', 'a@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '�Ӳ���', 21, '����', 'b@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '����', 22, '����', 'c@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '������', 23, '����', 'd@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, 'ȫ�浿1', 20, '����', 'a@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '�Ӳ���2', 21, '����', 'b@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '����3', 22, '����', 'c@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '������4', 23, '����', 'd@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, 'ȫ����5', 20, '����', 'a@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '�Ӳ���6', 21, '����', 'b@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '����7', 22, '����', 'c@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '������8', 23, '����', 'd@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, 'ȫ����9', 20, '����', 'a@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '�Ӳ���10', 21, '����', 'b@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '����11', 22, '����', 'c@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '������12', 23, '����', 'd@a.com');

select count(*) from ajax;
select * from ajax order by idx desc;
commit;