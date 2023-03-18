CREATE DEFINER=`root`@`localhost` PROCEDURE `authenticatorX`(in username varchar(70), in userpassword varchar(300), out succeed int)
BEGIN

DECLARE customer_exists VARCHAR(20) DEFAULT (SELECT salt FROM customersX WHERE email = username);

IF customer_exists IS NULL THEN

SET succeed = 0;

END IF;

SET @salt = (SELECT salt FROM customersX WHERE email = username);
SET @pass_the_hash = concat(sha2(userpassword, 224), @salt);
SET @pValue = (SELECT COUNT("UserName") FROM customersX WHERE email = username AND password = @pass_the_hash);

IF @pValue = 1 THEN SET succeed = 1;

ELSE
SET succeed = 0;
END IF;
   
END