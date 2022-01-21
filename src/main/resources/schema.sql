
CREATE TABLE `nl_banner_new` (
  `bannerid` int NOT NULL AUTO_INCREMENT,
  `imageurl` varchar(255) NOT NULL,
  `culture` varchar(50) NOT NULL,
  `storeid` int DEFAULT NULL,
  `voucherid` int NOT NULL DEFAULT '0',
  `linkurl` longtext,
  `size` enum('Normal','Skyscraper','Rectangle','SkyScraperWrapper','Slider','Mobile','Slider720x200','Slider610x400','ExitPage468x60','Popupbanner','Categorybanner','AppPopupbanner','SBShomeslider850x300','MegaBanner1000x500','SBSSkyscraper','CashoutAuction','SBSSkyscraper160x600','SkyScraperWrapper120x600') NOT NULL DEFAULT 'Normal',
  `banner_position` varchar(20) NOT NULL,
  `status` int DEFAULT NULL,
  `platform` varchar(10) NOT NULL DEFAULT 'web',
  `fromdate` date NOT NULL,
  `todate` date NOT NULL,
  `date_created` datetime DEFAULT NULL,
  `date_updated` datetime DEFAULT NULL,
  PRIMARY KEY (`bannerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `nl_banner_new` (`bannerid`, `imageurl`, `culture`, `storeid`, `voucherid`, `linkurl`, `size`, `banner_position`, `status`, `platform`, `fromdate`, `todate`, `date_created`, `date_updated`) VALUES
(1, 'https://static.orangebuddies.com/image/banners/61779-SBShomeslider850x300.jpg', 'en-GB', 1, 1, 'https://google.com/a.png', 'SkyScraperWrapper', '', 1, 'web', '2022-01-21', '2022-01-21', '2022-01-21 09:51:04', '2022-01-21 09:51:04'),
(2, 'https://static.orangebuddies.com/image/banners/61779-SBShomeslider850x300.jpg', 'en-GB', 2, 5, 'https://google.com/a.png', 'SkyScraperWrapper', '', 1, 'web', '2022-01-21', '2022-01-21', '2022-01-21 09:51:04', '2022-01-21 09:51:04'),
(3, 'https://static.orangebuddies.com/image/banners/61779-SBShomeslider850x300.jpg', 'en-GB', 2, 6, 'https://google.com/a.png', 'SkyScraperWrapper', '', 1, '', '2022-01-21', '2022-01-21', '2022-01-21 09:51:04', '2022-01-21 09:51:04'),
(4, 'https://static.orangebuddies.com/image/banners/61779-SBShomeslider850x300.jpg', 'en-GB', 13, 30, 'https://google.com/a.png', 'SkyScraperWrapper', '', 1, 'web', '2022-01-21', '2022-01-21', '2022-01-21 09:51:04', '2022-01-21 09:51:04');