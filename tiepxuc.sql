-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 19, 2021 at 04:31 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.3.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tiepxuc`
--

-- --------------------------------------------------------

--
-- Table structure for table `diadiem`
--

CREATE TABLE `diadiem` (
  `iddiadiem` int(11) NOT NULL,
  `tendiadiem` varchar(255) DEFAULT NULL,
  `idkhuvuc` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `diadiem`
--

INSERT INTO `diadiem` (`iddiadiem`, `tendiadiem`, `idkhuvuc`) VALUES
(1, 'dia diem 2', 5),
(6, 'Dia diem 1 ', 5),
(26, 'Dia diem 3', 5);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(28);

-- --------------------------------------------------------

--
-- Table structure for table `khuvuc`
--

CREATE TABLE `khuvuc` (
  `idkhuvuc` int(11) NOT NULL,
  `tenkhuvuc` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `khuvuc`
--

INSERT INTO `khuvuc` (`idkhuvuc`, `tenkhuvuc`) VALUES
(5, 'Phường Trung Đô');

-- --------------------------------------------------------

--
-- Table structure for table `tiepxuc`
--

CREATE TABLE `tiepxuc` (
  `id` int(11) NOT NULL,
  `thoigian` datetime DEFAULT NULL,
  `iddiadiem` int(11) DEFAULT NULL,
  `iduser` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tiepxuc`
--

INSERT INTO `tiepxuc` (`id`, `thoigian`, `iddiadiem`, `iduser`) VALUES
(1, '2021-11-10 04:55:29', 6, 2),
(2, NULL, NULL, NULL),
(3, '2021-11-12 14:56:05', 1, 2),
(8, '2021-11-12 14:57:29', 1, 2),
(9, '2021-11-12 14:57:54', 1, 22),
(19, '2021-11-16 08:07:27', 1, 22),
(25, '2021-11-19 09:38:01', 1, 23);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `iduser` int(11) NOT NULL,
  `avt` longblob DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`iduser`, `avt`, `email`, `name`, `password`, `phone`, `role`) VALUES
(2, NULL, NULL, 'Tuan', NULL, '0396118696', NULL),
(3, 0x89504e470d0a1a0a0000000d49484452000001b8000001a608020000008174060f000000017352474200aece1ce90000000467414d410000b18f0bfc6105000000097048597300000ec300000ec301c76fa8640000023349444154785eedc1010d000000c2a0f74f6d0e37200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000804335820e0001c486ab900000000049454e44ae426082, 'b', 'tuan', '$2a$10$lb31VKd4U1lT.3YIe0xr.uuRS.YohWH2chEUCaax.POXXDT9okTSe', '0396118696', 'ADMIN'),
(10, NULL, 'd', 'quynh', '$2a$10$tN9eq4Z5yM.C5CDmSN.v1uCB3FqxJ5f19WJTL7j6nuhLZAQMlUwAq', NULL, 'ADMIN'),
(20, NULL, 'user', 'Tuan', '$2a$10$aOqmaNvRYYhllom/cXm6neBHB5TVsGfWKWzcbchjq71r3IYxx2C26', '0396118696', 'user'),
(21, NULL, NULL, 'Tuan', '$2a$10$PrPgWufS5dkpRMy5laReWeEeKSiS7xuOa1qdN/vyZQJH4sW34Elee', '0396118696', 'user'),
(22, NULL, 'user1', 'Tuan1', '$2a$10$3tG56yvLSH5YHkqYhONKQuKlqE1razN9M7dcpu6CvY8fSb3aQhkba', '0396118696', 'USER'),
(23, NULL, 'admin1', 'Tuan', '$2a$10$gub8C6EsioBszzxdL9ClROKQfTfwJBdpRaA4Pq5Cpsuk9U6EE1HMS', '0396118696', 'ADMIN'),
(24, NULL, 'admin2', 'Tuan', '$2a$10$GfNcQgCVvXjLZNKt1sWzAuTdqDN3fwkil3WxS38Yj2QWW66jExFdi', '0396118696', 'ADMIN');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `diadiem`
--
ALTER TABLE `diadiem`
  ADD PRIMARY KEY (`iddiadiem`),
  ADD KEY `FK88dx9mdo2bm0eu2bjait39wtk` (`idkhuvuc`);

--
-- Indexes for table `khuvuc`
--
ALTER TABLE `khuvuc`
  ADD PRIMARY KEY (`idkhuvuc`);

--
-- Indexes for table `tiepxuc`
--
ALTER TABLE `tiepxuc`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK95ep4w8yef87t7o1tgy1jkcyp` (`iddiadiem`),
  ADD KEY `FKjs36chni0yphdqndf0wko7r39` (`iduser`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`iduser`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tiepxuc`
--
ALTER TABLE `tiepxuc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `diadiem`
--
ALTER TABLE `diadiem`
  ADD CONSTRAINT `FK88dx9mdo2bm0eu2bjait39wtk` FOREIGN KEY (`idkhuvuc`) REFERENCES `khuvuc` (`idkhuvuc`);

--
-- Constraints for table `tiepxuc`
--
ALTER TABLE `tiepxuc`
  ADD CONSTRAINT `FK95ep4w8yef87t7o1tgy1jkcyp` FOREIGN KEY (`iddiadiem`) REFERENCES `diadiem` (`iddiadiem`),
  ADD CONSTRAINT `FKjs36chni0yphdqndf0wko7r39` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
