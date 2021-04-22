CREATE TABLE `b_user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `UserCode` varchar(50) NOT NULL COMMENT '用户代码',
  `UserName` varchar(50) NOT NULL COMMENT '用户名',
  `PassWord` varchar(50) NOT NULL COMMENT '密码',
  `Mobile` varchar(50) NOT NULL COMMENT '手机号',
  `NickName` varchar(50) DEFAULT NULL COMMENT '昵称',
  `Avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `Notes` varchar(255) DEFAULT NULL COMMENT '个性签名',
  `Status` int(10) NOT NULL COMMENT '用户类型：0-试用 1-正式 -金牌',
  `IsUsed` int(10) NOT NULL COMMENT '是否可用，0-不可用 1-可用',
  `UseTime` datetime NOT NULL COMMENT '使用时间',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO `b_user` VALUES ('1', 'admin', '超级管理员', '21232F297A57A5A743894A0E4A801FC3', '13845678928', null, 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png', null, '1', '0', '2021-03-01 14:47:03');
INSERT INTO `b_user` VALUES ('2', 'yxm', '正式用户', 'E10ADC3949BA59ABBE56E057F20F883E', '21324324244', null, 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png', null, '1', '0', '2021-03-02 13:15:03');
INSERT INTO `b_user` VALUES ('3', 'ceshi', '测试用户', 'E10ADC3949BA59ABBE56E057F20F883E', '123456789', null, 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png', null, '1', '0', '2021-03-02 16:04:26');
