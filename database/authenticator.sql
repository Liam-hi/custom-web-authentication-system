CREATE DEFINER=`root`@`localhost` PROCEDURE `authenticator`(in email varchar(25), in userpassword varchar(300), out succeed int)
BEGIN

declare correct_username varchar(20) default (select salt from login where username = email);

if correct_username is null then

SET succeed = 0;

end if;

SET @salt = (select salt from login where username = email);

SET @pValue2 = concat(sha2(userpassword, 224), @salt);

SET @pValue = (SELECT COUNT("UserName") FROM login WHERE username = email AND password = @pValue2);

if @pValue = 1 then SET succeed = 1;

ELSE
SET succeed = 0;
END IF;
   
END