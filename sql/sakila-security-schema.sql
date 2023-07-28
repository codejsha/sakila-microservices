-- Sakila Sample Database Schema (for security tables)
-- This is written for microservices application.

-- Copyright 2023 Jinseong Ha
--
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
--
--     http://www.apache.org/licenses/LICENSE-2.0
--
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.

SET NAMES utf8mb4;
SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'TRADITIONAL';

DROP SCHEMA IF EXISTS sakila;
CREATE SCHEMA sakila;
USE sakila;

--
-- Table structure for table `authority`
--

CREATE TABLE authority
(
    authority_id SMALLINT UNSIGNED                                            NOT NULL AUTO_INCREMENT,
    email        VARCHAR(50)                                                  NOT NULL,
    password     VARCHAR(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin        NOT NULL,
    authority    SET ('ROLE_READ', 'ROLE_WRITE', 'ROLE_MANAGE', 'ROLE_ADMIN') NOT NULL,
    PRIMARY KEY (authority_id),
    UNIQUE KEY idx_unique_email (email)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;
