-- '--' 주석
-- 시퀀스 초기화 방법
-- 모든 데이터를 제거하고 시퀀스를 다시 만든다.
delete from FILEUPLOAD;
drop sequence FILEUPLOAD_idx_seq;
-- 자동으로 1씩 증가하는 시퀀스 만들기 (테이블이름_필드이름_seq)
create sequence FILEUPLOAD_idx_seq;

