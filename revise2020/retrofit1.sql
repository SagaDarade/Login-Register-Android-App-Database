-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 11, 2020 at 04:47 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.3.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `retrofit1`
--

-- --------------------------------------------------------

--
-- Table structure for table `img_demo`
--

CREATE TABLE `img_demo` (
  `id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `img_demo`
--

INSERT INTO `img_demo` (`id`, `title`, `image`) VALUES
(1, 'abc', 'uploads/abc.jpg'),
(2, 'gang', 'uploads/gang.jpg'),
(3, 'sts', 'uploads/sts.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE `project` (
  `pid` int(11) NOT NULL,
  `pname` varchar(200) NOT NULL,
  `duration` varchar(10) NOT NULL,
  `submit` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`pid`, `pname`, `duration`, `submit`) VALUES
(1, 'AutoDoctor', '144', '2020-02-03'),
(2, 'Garnet Metals', '144', '2019-12-10'),
(3, 'Garnet Metal App', '120', '2020-01-31'),
(5, 'Room Rent', '160', '2020-01-31'),
(6, 'PayRoll System', '180', '2020-01-25'),
(7, 'PayRoll', '180', '2020-01-25'),
(8, '', '', '0000-00-00'),
(9, 'aaa', '85', '2020-02-01'),
(10, 'bbb', '57', '2019-12-03'),
(11, 'employee', '10', '2019-12-20'),
(12, 'fddd', '350', '2020-01-16'),
(13, 'GYM 2', '180', '2020-01-25'),
(14, 'aaa2', '25', '2020-01-25'),
(15, 'qwerty', '88', '2019-12-12');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `uid` int(11) NOT NULL,
  `uname` varchar(100) NOT NULL,
  `unumber` varchar(15) NOT NULL,
  `useremail` varchar(100) NOT NULL,
  `userpass` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`uid`, `uname`, `unumber`, `useremail`, `userpass`) VALUES
(1, 'Abhishek', '9975362272', 'abhi123', 'abhi2105'),
(2, 'Parnavi', '8745123609', 'pari0101', 'parna123'),
(3, 'Parnavi', '7458102396', 'pari0101@gmail.in', 'parna123'),
(5, 'bbb', '8888', 'bbb234', 'bbb123'),
(6, 'ccc', '3333', 'ccc234', 'ccc123'),
(7, 'nana', '151151', 'nnn777', 'nnn678'),
(8, 'aaaa', '987647', 'aaaanb.in', 'abh123'),
(9, 'xxx', '90875', 'xxx.in', 'xxx333'),
(10, 'aaa2', '9088', 'xxx.ino', 'ttt');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `img_demo`
--
ALTER TABLE `img_demo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`pid`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`uid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `img_demo`
--
ALTER TABLE `img_demo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `project`
--
ALTER TABLE `project`
  MODIFY `pid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
