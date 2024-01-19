CREATE TABLE article (
                         id int(11) not null AUTO_INCREMENT,
                         author VARCHAR(32) not null,
                         title VARCHAR(32)  not null,
                         content varchar(512) not null,
                         createTime DATETIME not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
                         PRIMARY key (`id`)
)
    comment='文章'
ENGINE=INNODB;


alter user 'root'@'localhost' identified by '123456' password expire never;

alter user 'root'@'localhost' identified with mysql_native_password by '123456';

flush privileges;