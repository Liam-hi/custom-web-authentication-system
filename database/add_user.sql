CREATE DEFINER=`root`@`localhost` PROCEDURE `add_user`(in email VARCHAR(50), in password VARCHAR(300), out succeed int)
BEGIN

declare correct_username varchar(20) default (select username from login where username = email);

SET @salt=SUBSTRING(MD5(RAND()), -10);

if correct_username is null then

INSERT INTO login(`username`, `password`, `salt`) VALUES (email, concat(sha2(password, 224), @salt), @salt);

SET succeed = 1;

ELSE
SET succeed = 0;
END IF;


END