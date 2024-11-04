-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-10-2024 a las 10:49:50
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tarea2dewes`
--
CREATE DATABASE IF NOT EXISTS `tarea2dwes` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `tarea2dwes`;
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `credenciales`
--

CREATE TABLE `credenciales` (
  `id` int(10) NOT NULL,
  `usuario` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejemplar`
--

CREATE TABLE `ejemplares` (
  `id` int(10) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `idPlanta` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensaje`
--

CREATE TABLE `mensajes` (
  `id` int(10) NOT NULL ,
  `fechahora` datetime NOT NULL,
  `mensaje` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `personas` (
  `id` int(10) NOT NULL,
  `admin` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  `idCredencial` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `planta`
--

CREATE TABLE `plantas` (
  `codigo` varchar(20) NOT NULL,
  `nombrecomun` varchar(40) NOT NULL,
  `nombrecientifico` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seguimiento`
--

CREATE TABLE `seguimiento` (
  `id_PK_ejemplar` int(10) NOT NULL,
  `id_PK_persona` int(10) NOT NULL,
  `id_PK_mensaje` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `credenciales`
--
ALTER TABLE `credenciales`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ejemplares`
--
ALTER TABLE `ejemplares`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_planta` (`idPlanta`);

--
-- Indices de la tabla `mensajes`
--
ALTER TABLE `mensajes`
  ADD PRIMARY KEY (`id`);
--
-- Indices de la tabla `personas`
--
ALTER TABLE `personas`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `fk_credenciales` (`idCredencial`);
--
-- Indices de la tabla `planta`
--
ALTER TABLE `plantas`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `seguimiento`
--
ALTER TABLE `seguimiento`
  ADD PRIMARY KEY (`id_PK_ejemplar`,`id_PK_persona`,`id_PK_mensaje`),
  ADD KEY `Ejemplar_id_FK` (`id_PK_ejemplar`),
  ADD KEY `Persona_id_FK` (`id_PK_persona`),
  ADD KEY `Mensaje_id_FK` (`id_PK_mensaje`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `personas`
--
ALTER TABLE `personas`
  ADD CONSTRAINT `fk_credenciales` FOREIGN KEY (`idCredencial`) REFERENCES `credenciales` (`id`);


--
-- Filtros para la tabla `ejemplares`
--
ALTER TABLE `ejemplares`
  ADD CONSTRAINT `fk_plantas` FOREIGN KEY (`idPlanta`) REFERENCES `plantas` (`codigo`);

-- Filtros para la tabla `personas`
--
ALTER TABLE `personas`
  ADD CONSTRAINT `fk_credencial` FOREIGN KEY (`idCredencial`) REFERENCES `credenciales` (`id`);
--


  
-- Filtros para la tabla `seguimiento`
--
ALTER TABLE `seguimiento`
  ADD CONSTRAINT `Ejemplar_id_FK` FOREIGN KEY (`id_PK_ejemplar`) REFERENCES `ejemplares` (`id`),
  ADD CONSTRAINT `Mensaje_id_FK` FOREIGN KEY (`id_PK_mensaje`) REFERENCES `mensajes` (`id`),
  ADD CONSTRAINT `Persona_id_FK` FOREIGN KEY (`id_PK_persona`) REFERENCES `personas` (`id`);


-- AUTO_INCREMENT de la tabla `credenciales`
--
ALTER TABLE `credenciales`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ejemplares`
--
ALTER TABLE `ejemplares`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `mensajes`
--
ALTER TABLE `mensajes`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `personas`
--
ALTER TABLE `personas`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

COMMIT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
