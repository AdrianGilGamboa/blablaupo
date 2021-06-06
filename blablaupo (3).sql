-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-06-2021 a las 23:30:22
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `blablaupo`
--
CREATE DATABASE IF NOT EXISTS `blablaupo` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `blablaupo`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `anuncios`
--

CREATE TABLE `anuncios` (
  `ID_ANUNCIO` int(11) NOT NULL,
  `COSTE` float NOT NULL,
  `ANUNCIANTE` varchar(255) NOT NULL,
  `FECHA_INICIO` date NOT NULL,
  `FECHA_FIN` date NOT NULL,
  `MULTIMEDIA` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `anuncios`
--

INSERT INTO `anuncios` (`ID_ANUNCIO`, `COSTE`, `ANUNCIANTE`, `FECHA_INICIO`, `FECHA_FIN`, `MULTIMEDIA`) VALUES
(5, 50, 'Pilot', '2020-05-10', '2020-07-10', 'Pilot - Bolígrafos!');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `coche`
--

CREATE TABLE `coche` (
  `MATRICULA` varchar(10) NOT NULL,
  `COLOR` varchar(255) NOT NULL,
  `MODELO` varchar(255) NOT NULL,
  `MARCA` varchar(255) NOT NULL,
  `DNI_CONDUCTOR` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `coche`
--

INSERT INTO `coche` (`MATRICULA`, `COLOR`, `MODELO`, `MARCA`, `DNI_CONDUCTOR`) VALUES
('2874GMB', 'Negro', 'RS7', 'Audi', '12345678Z'),
('3897GCD', 'Gris Clarito', '308', 'Peugeot', '28983187J');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cupones`
--

CREATE TABLE `cupones` (
  `NUMERO_CUPON` varchar(255) NOT NULL,
  `DESC_CUPON` varchar(255) NOT NULL,
  `FECHA_FIN` date NOT NULL,
  `FECHA_INICIO` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cupones`
--

INSERT INTO `cupones` (`NUMERO_CUPON`, `DESC_CUPON`, `FECHA_FIN`, `FECHA_INICIO`) VALUES
('gBL3q', '20.0', '2020-10-10', '2020-07-10');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservas`
--

CREATE TABLE `reservas` (
  `F_RESERVA` datetime NOT NULL,
  `DNI_PASAJERO` varchar(20) NOT NULL,
  `ID_VIAJE` int(11) NOT NULL,
  `ID_RESERVA` int(11) NOT NULL,
  `NUMERO_CUPON` varchar(255) DEFAULT NULL,
  `COSTE_FINAL` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `reservas`
--

INSERT INTO `reservas` (`F_RESERVA`, `DNI_PASAJERO`, `ID_VIAJE`, `ID_RESERVA`, `NUMERO_CUPON`, `COSTE_FINAL`) VALUES
('2020-02-10 14:56:00', '12345678Z', 11, 64, NULL, 40);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seguros`
--

CREATE TABLE `seguros` (
  `EMPRESA` varchar(255) NOT NULL,
  `TIPO` varchar(255) NOT NULL,
  `DESCRIPCION` varchar(255) NOT NULL,
  `ID_SEGURO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `seguros`
--

INSERT INTO `seguros` (`EMPRESA`, `TIPO`, `DESCRIPCION`, `ID_SEGURO`) VALUES
('Mutuamadrid', 'Todo Riesgo', 'El mejor seguro de tu vida!', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `DNI` varchar(20) NOT NULL,
  `NOMBRE` varchar(255) NOT NULL,
  `APELLIDOS` varchar(255) NOT NULL,
  `TELEFONO` int(11) NOT NULL,
  `EMAIL` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `TIPO` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`DNI`, `NOMBRE`, `APELLIDOS`, `TELEFONO`, `EMAIL`, `PASSWORD`, `TIPO`) VALUES
('12345678Z', 'Manu', 'Molina', 695874512, 'manu@gmail.com', 'manuel', 'Si'),
('28983187J', 'Adrian', 'Gil Gamboa', 695529887, 'adrian@gmail.com', 'adrian', 'Si'),
('5', 'Admin', 'Admin', 5, 'admin@gmail.com', 'admin', 'Admin');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `valoraciones`
--

CREATE TABLE `valoraciones` (
  `ID_VALORACION` int(11) NOT NULL,
  `ID_RESERVA` int(11) NOT NULL,
  `PUNTUACION` int(11) NOT NULL,
  `DESCRIPCION` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `valoraciones`
--

INSERT INTO `valoraciones` (`ID_VALORACION`, `ID_RESERVA`, `PUNTUACION`, `DESCRIPCION`) VALUES
(2, 64, 8, 'Buen viajecito');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `viajes`
--

CREATE TABLE `viajes` (
  `ID_VIAJE` int(11) NOT NULL,
  `ID_SEGURO` int(11) NOT NULL,
  `DNI_CONDUCTOR` varchar(20) NOT NULL,
  `HORA_SALIDA` datetime NOT NULL,
  `HORA_LLEGADA` datetime NOT NULL,
  `ORIGEN` varchar(255) NOT NULL,
  `DESTINO` varchar(255) NOT NULL,
  `COSTE` float NOT NULL,
  `NUM_PASAJEROS` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `viajes`
--

INSERT INTO `viajes` (`ID_VIAJE`, `ID_SEGURO`, `DNI_CONDUCTOR`, `HORA_SALIDA`, `HORA_LLEGADA`, `ORIGEN`, `DESTINO`, `COSTE`, `NUM_PASAJEROS`) VALUES
(11, 2, '28983187J', '2020-02-10 14:56:00', '2020-02-10 14:56:00', 'Barcelona', 'Madrid', 40, 1),
(12, 2, '12345678Z', '2021-08-10 14:56:00', '2021-08-10 19:56:00', 'Barcelona', 'UPO', 30, 4);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `anuncios`
--
ALTER TABLE `anuncios`
  ADD PRIMARY KEY (`ID_ANUNCIO`);

--
-- Indices de la tabla `coche`
--
ALTER TABLE `coche`
  ADD PRIMARY KEY (`MATRICULA`),
  ADD KEY `FK_USUARIO` (`DNI_CONDUCTOR`);

--
-- Indices de la tabla `cupones`
--
ALTER TABLE `cupones`
  ADD PRIMARY KEY (`NUMERO_CUPON`);

--
-- Indices de la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD PRIMARY KEY (`ID_RESERVA`),
  ADD KEY `FK_PASAJERO` (`DNI_PASAJERO`),
  ADD KEY `FK_VIAJE` (`ID_VIAJE`),
  ADD KEY `FK_CUPON` (`NUMERO_CUPON`);

--
-- Indices de la tabla `seguros`
--
ALTER TABLE `seguros`
  ADD PRIMARY KEY (`ID_SEGURO`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`DNI`);

--
-- Indices de la tabla `valoraciones`
--
ALTER TABLE `valoraciones`
  ADD PRIMARY KEY (`ID_VALORACION`),
  ADD KEY `FK_RESERVA` (`ID_RESERVA`);

--
-- Indices de la tabla `viajes`
--
ALTER TABLE `viajes`
  ADD PRIMARY KEY (`ID_VIAJE`),
  ADD KEY `FK_CONDUCTOR` (`DNI_CONDUCTOR`),
  ADD KEY `FK_SEGURO` (`ID_SEGURO`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `anuncios`
--
ALTER TABLE `anuncios`
  MODIFY `ID_ANUNCIO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `reservas`
--
ALTER TABLE `reservas`
  MODIFY `ID_RESERVA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;

--
-- AUTO_INCREMENT de la tabla `seguros`
--
ALTER TABLE `seguros`
  MODIFY `ID_SEGURO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `valoraciones`
--
ALTER TABLE `valoraciones`
  MODIFY `ID_VALORACION` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `viajes`
--
ALTER TABLE `viajes`
  MODIFY `ID_VIAJE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `coche`
--
ALTER TABLE `coche`
  ADD CONSTRAINT `FK_USUARIO` FOREIGN KEY (`DNI_CONDUCTOR`) REFERENCES `usuarios` (`DNI`);

--
-- Filtros para la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD CONSTRAINT `FK_CUPON` FOREIGN KEY (`NUMERO_CUPON`) REFERENCES `cupones` (`NUMERO_CUPON`),
  ADD CONSTRAINT `FK_PASAJERO` FOREIGN KEY (`DNI_PASAJERO`) REFERENCES `usuarios` (`DNI`),
  ADD CONSTRAINT `FK_VIAJE` FOREIGN KEY (`ID_VIAJE`) REFERENCES `viajes` (`ID_VIAJE`);

--
-- Filtros para la tabla `valoraciones`
--
ALTER TABLE `valoraciones`
  ADD CONSTRAINT `FK_RESERVA` FOREIGN KEY (`ID_RESERVA`) REFERENCES `reservas` (`ID_RESERVA`);

--
-- Filtros para la tabla `viajes`
--
ALTER TABLE `viajes`
  ADD CONSTRAINT `FK_CONDUCTOR` FOREIGN KEY (`DNI_CONDUCTOR`) REFERENCES `usuarios` (`DNI`),
  ADD CONSTRAINT `FK_SEGURO` FOREIGN KEY (`ID_SEGURO`) REFERENCES `seguros` (`ID_SEGURO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
