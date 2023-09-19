-- '--' 주석
-- 시퀀스 초기화 방법
-- 모든 데이터를 제거하고 시퀀스를 다시 만든다.
delete from ajax;
drop sequence ajax_idx_seq;
-- 자동으로 1씩 증가하는 시퀀스 만들기 (테이블이름_필드이름_seq)
create sequence ajax_idx_seq;

insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '홍길동', 20, '남자', 'a@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '임꺽정', 21, '남자', 'b@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '장길산', 22, '남자', 'c@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '일지매', 23, '남자', 'd@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '홍길일', 20, '여자', 'a@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '임꺽이', 21, '여자', 'b@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '장길삼', 22, '여자', 'c@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '일지사', 23, '여자', 'd@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '홍길동1', 20, '남자', 'a@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '임꺽정2', 21, '남자', 'b@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '장길산3', 22, '남자', 'c@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '일지매4', 23, '남자', 'd@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '홍길일5', 20, '여자', 'a@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '임꺽이6', 21, '여자', 'b@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '장길삼7', 22, '여자', 'c@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '일지사8', 23, '여자', 'd@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '홍길일9', 20, '여자', 'a@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '임꺽이10', 21, '여자', 'b@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '장길삼11', 22, '여자', 'c@a.com');
insert into ajax (idx, name, age, gender, email) VALUES ( ajax_idx_seq.nextval, '일지사12', 23, '여자', 'd@a.com');

select count(*) from ajax;
select * from ajax order by idx desc;
commit;