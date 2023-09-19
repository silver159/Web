-- 시퀀스 초기화 방법
-- 모든 데이터를 제거하고 시퀀스를 다시 만든다.
delete from freeboard;
drop sequence freeboard_idx_seq;
-- 자동으로 1씩 증가하는 시퀀스 만들기 (테이블이름_필드이름_seq)
create sequence freeboard_idx_seq;


select * from freeboard order by idx desc;
select count(*) from freeboard;
select * from freeboard where notice = 'YES' order by idx desc;

insert into freeboard (idx, name, password, subject, content, notice, ip) 
		values (freeboard_idx_seq.nextval, '홍길동', '1111', '1등', '1등 입니다.', 'NO', '192.168.000.175');
insert into freeboard (idx, name, password, subject, content, notice, ip) 
		values (freeboard_idx_seq.nextval, '임꺽정', '2222', '2등', '2등 입니다.', 'NO', '192.168.000.176');
insert into freeboard (idx, name, password, subject, content, notice, ip) 
		values (freeboard_idx_seq.nextval, '장길산', '3333', '3등', '3등 입니다.', 'NO', '192.168.000.177');
insert into freeboard (idx, name, password, subject, content, notice, ip) 
		values (freeboard_idx_seq.nextval, '일지매', '4444', '4등', '4등 입니다.', 'NO', '192.168.000.178');

delete from freeboard where idx = '906';

update freeboard set notice = 'YES' where idx = '121';

commit;
rollback;

















