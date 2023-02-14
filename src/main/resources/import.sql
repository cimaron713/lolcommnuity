ALTER TABLE board CONVERT TO CHARSET UTF8;
ALTER TABLE category CONVERT TO CHARSET UTF8;
ALTER TABLE post CONVERT TO CHARSET UTF8;
ALTER TABLE user CONVERT TO CHARSET UTF8;
ALTER TABLE reply CONVERT TO CHARSET UTF8;
ALTER TABLE report CONVERT TO CHARSET UTF8;

INSERT INTO lolcommunity.user (email, nickname, password)
VALUES ('string', 'test', '{bcrypt}$2a$10$HVN2CMmzvdckJO5WRqrzGevDdc34YOmYEw1mE/lpNeC823gNxpWh2');
INSERT INTO lolcommunity.user_roles (user_uno, roles)
VALUES (1, 'ROLE_USER');

INSERT INTO lolcommunity.board (BOARD_NAME) VALUES ('자유');
INSERT INTO lolcommunity.category (category_name, board) VALUES ('자유', 1);

# INSERT INTO lolcommunity.board (BOARD_NAME) VALUES ('팁게시판');
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('가렌', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('갈리오', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('갱플랭크', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('그라가스', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('그레이브즈', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('그웬', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('나르', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('나미', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('나서스', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('노틸러스', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('녹턴', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('누누와윌럼프', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('니달리', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('니코', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('닐라', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('다리우스', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('다이애나', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('드레이븐', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('라이즈', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('라칸', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('람머스', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('럭스', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('럼블', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('레나타', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('레넥톤', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('레오나', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('렉사이', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('렐', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('렝가', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('루시안', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('룰루', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('르블랑', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('리신', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('리븐', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('리산드라', 2);
# INSERT INTO lolcommunity.category (category_name, board) VALUES ('릴리아', 2);
