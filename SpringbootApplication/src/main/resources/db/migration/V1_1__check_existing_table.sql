CREATE TABLE IF NOT EXISTS `tbl_Inventory` (

    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `Artist` varchar(50),
    `Album` varchar(50),
    `Quantity` int,
    `Price` float

)ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;