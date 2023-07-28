-- Sakila Sample Database Schema (for actor and film tables)
-- Modified from version 1.4 for microservices application

-- Copyright (c) 2006, 2022, Oracle and/or its affiliates.

-- Redistribution and use in source and binary forms, with or without
-- modification, are permitted provided that the following conditions are
-- met:

-- * Redistributions of source code must retain the above copyright notice,
--   this list of conditions and the following disclaimer.
-- * Redistributions in binary form must reproduce the above copyright
--   notice, this list of conditions and the following disclaimer in the
--   documentation and/or other materials provided with the distribution.
-- * Neither the name of Oracle nor the names of its contributors may be used
--   to endorse or promote products derived from this software without
--   specific prior written permission.

-- THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
-- IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
-- THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
-- PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
-- CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
-- EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
-- PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
-- PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
-- LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
-- NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
-- SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

SET NAMES utf8mb4;
SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'TRADITIONAL';

SET @VAL_LANGUAGE_ID_START = 1, @VAL_LANGUAGE_ID_END = 6;
SET @VAL_CATEGORY_ID_START = 1, @VAL_CATEGORY_ID_END = 16;

DROP SCHEMA IF EXISTS sakila;
CREATE SCHEMA sakila;
USE sakila;

--
-- Table structure for table `actor`
--

CREATE TABLE actor
(
    actor_id   SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(45)       NOT NULL,
    last_name  VARCHAR(45)       NOT NULL,
    PRIMARY KEY (actor_id),
    KEY idx_actor_last_name (last_name)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Table structure for table `film`
--

CREATE TABLE film
(
    film_id              SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
    title                VARCHAR(128)      NOT NULL,
    description          TEXT                                                                 DEFAULT NULL,
    release_year         YEAR                                                                 DEFAULT NULL,
    language_id          TINYINT UNSIGNED  NOT NULL,
    original_language_id TINYINT UNSIGNED                                                     DEFAULT NULL,
    rental_duration      TINYINT UNSIGNED  NOT NULL                                           DEFAULT 3,
    rental_rate          DECIMAL(4, 2)     NOT NULL                                           DEFAULT 4.99,
    length               SMALLINT UNSIGNED                                                    DEFAULT NULL,
    replacement_cost     DECIMAL(5, 2)     NOT NULL                                           DEFAULT 19.99,
    rating               ENUM ('G','PG','PG-13','R','NC-17')                                  DEFAULT 'G',
    special_features     SET ('Trailers','Commentaries','Deleted Scenes','Behind the Scenes') DEFAULT NULL,
    PRIMARY KEY (film_id),
    KEY idx_title (title),
    KEY idx_fk_language_id (language_id),
    KEY idx_fk_original_language_id (original_language_id),
    CHECK ( language_id BETWEEN VAL_LANGUAGE_ID_START AND VAL_LANGUAGE_ID_END ),
    CHECK ( original_language_id BETWEEN VAL_LANGUAGE_ID_START AND VAL_LANGUAGE_ID_END )
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Table structure for table `film_actor`
--

CREATE TABLE film_actor
(
    actor_id SMALLINT UNSIGNED NOT NULL,
    film_id  SMALLINT UNSIGNED NOT NULL,
    PRIMARY KEY (actor_id, film_id),
    KEY idx_fk_film_id (film_id),
    CONSTRAINT fk_film_actor_actor FOREIGN KEY (actor_id) REFERENCES actor (actor_id) ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT fk_film_actor_film FOREIGN KEY (film_id) REFERENCES film (film_id) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Table structure for table `film_category`
--

CREATE TABLE film_category
(
    film_id     SMALLINT UNSIGNED NOT NULL,
    category_id TINYINT UNSIGNED  NOT NULL,
    PRIMARY KEY (film_id, category_id),
    CONSTRAINT fk_film_category_film FOREIGN KEY (film_id) REFERENCES film (film_id) ON DELETE RESTRICT ON UPDATE CASCADE,
    CHECK ( category_id BETWEEN VAL_CATEGORY_ID_START AND VAL_CATEGORY_ID_END )
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Table structure for table `film_text`
--

CREATE TABLE film_text
(
    film_id     SMALLINT     NOT NULL,
    title       VARCHAR(255) NOT NULL,
    description TEXT,
    PRIMARY KEY (film_id),
    FULLTEXT KEY idx_title_description (title, description)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;
