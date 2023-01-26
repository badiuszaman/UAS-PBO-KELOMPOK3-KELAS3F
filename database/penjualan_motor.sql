-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 25, 2023 at 03:37 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `penjualan_motor`
--

-- --------------------------------------------------------

--
-- Table structure for table `motor`
--

CREATE TABLE `motor` (
  `kode_motor` varchar(20) NOT NULL,
  `merk_motor` varchar(25) NOT NULL,
  `warna` varchar(15) NOT NULL,
  `harga` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `motor`
--

INSERT INTO `motor` (`kode_motor`, `merk_motor`, `warna`, `harga`) VALUES
('MTR0008', 'beat', 'hitam', 200000),
('MTR0009', 'beat', 'hitam', 200000),
('MTR003', 'SUZUKI', 'UNGU', 3000000),
('MTR004', 'YAMAHA', 'HITAM', 3000000),
('MTR005', 'HONDA', 'merah', 1500000),
('MTR006', 'YAMAHA MIO', 'HITAM', 200000000);

-- --------------------------------------------------------

--
-- Table structure for table `pembeli`
--

CREATE TABLE `pembeli` (
  `kode_pembeli` varchar(20) NOT NULL,
  `nama_pembeli` varchar(100) NOT NULL,
  `no_hp` varchar(20) NOT NULL,
  `alamat` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pembeli`
--

INSERT INTO `pembeli` (`kode_pembeli`, `nama_pembeli`, `no_hp`, `alamat`) VALUES
('PMB001', 'ssgsg', '9083043', 'ewhwe'),
('PMB003', 'AZAM', '0847354', 'TEGAL'),
('PMB005', 'USZAMAN', '0845844', 'SLAWI'),
('PMB006', 'intang', '084745454t', 'slawi tegal'),
('PMB007', 'badiii ', '08798', 'trfal');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `kode_transaksi` varchar(20) NOT NULL,
  `kode_pembeli` varchar(20) NOT NULL,
  `kode_motor` varchar(20) NOT NULL,
  `tanggal` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`kode_transaksi`, `kode_pembeli`, `kode_motor`, `tanggal`) VALUES
('TR0003', 'PMB003', 'MTR004', '21082034'),
('TRA0005', 'PMB007', 'MTR004', 'Tuesday-24-Jan-2023'),
('TRA0006', 'PMB006', 'MTR003', 'Tuesday-24-Jan-2023'),
('TRA0007', '', 'MTR003', 'Tuesday-24-Jan-2023'),
('TRA0008', '', 'MTR004', 'Tuesday-24-Jan-2023'),
('TRA0009', 'PMB003', 'MTR003', 'Tuesday-24-Jan-2023'),
('TRA0010', 'PMB005', 'MTR004', 'Tuesday-24-Jan-2023'),
('TRA0011', 'PMB007', 'MTR005', 'Tuesday-24-Jan-2023');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` varchar(20) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`) VALUES
('US0004', 'admin', 'admin'),
('US001', 'badi', '123'),
('US003', 'badi', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `motor`
--
ALTER TABLE `motor`
  ADD PRIMARY KEY (`kode_motor`);

--
-- Indexes for table `pembeli`
--
ALTER TABLE `pembeli`
  ADD PRIMARY KEY (`kode_pembeli`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`kode_transaksi`),
  ADD KEY `id_pembeli` (`kode_pembeli`,`kode_motor`),
  ADD KEY `kode_motor` (`kode_motor`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
