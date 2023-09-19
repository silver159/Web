INSERT INTO memolist(NAME, PASSWORD, memo, ip) VALUES ('홍길동','1111','1등입니다.','162.168.100.001');
INSERT INTO memolist(NAME, PASSWORD, memo, ip) VALUES ('임꺽정','2222','2등입니다.','162.168.100.002');
INSERT INTO memolist(NAME, PASSWORD, memo, ip) VALUES ('장길산','3333','3등입니다.','162.168.100.003');
INSERT INTO memolist(NAME, PASSWORD, memo, ip) VALUES ('일지매','4444','4등입니다.','162.168.100.004');

SELECT * FROM memolist ORDER BY idx DESC;
SELECT * FROM memolist ORDER BY idx DESC LIMIT 0, 10;

DELETE FROM memolist;
ALTER TABLE memolist AUTO_INCREMENT = 1;

SELECT COUNT(*) FROM memolist;
SELECT COUNT(*) AS 'cnt' FROM memolist;


SELECT * FROM memolist ORDER BY idx DESC LIMIT 0, 10;










