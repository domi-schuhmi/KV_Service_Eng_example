CREATE database IF NOT EXISTS `testDB`;
Drop User if exists `test_user_example`;
create user 'test_user_example' identified by 'asdfg1234!!';
grant all on testDB.* to 'test_user_example';
