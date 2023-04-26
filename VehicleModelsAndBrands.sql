--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2023-04-26 23:05:31

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3332 (class 1262 OID 16465)
-- Name: VehicleModelsAndBrands; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "VehicleModelsAndBrands" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_Germany.1252';


ALTER DATABASE "VehicleModelsAndBrands" OWNER TO postgres;

\connect "VehicleModelsAndBrands"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 216 (class 1259 OID 16476)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 214 (class 1259 OID 16466)
-- Name: model; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.model (
    id bigint NOT NULL,
    engine_power double precision NOT NULL,
    name character varying(100) NOT NULL,
    vehicle_brand_id bigint NOT NULL
);


ALTER TABLE public.model OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16471)
-- Name: vehicle_brand; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vehicle_brand (
    id bigint NOT NULL,
    name character varying(100) NOT NULL,
    price_segment character varying(255)
);


ALTER TABLE public.vehicle_brand OWNER TO postgres;

--
-- TOC entry 3324 (class 0 OID 16466)
-- Dependencies: 214
-- Data for Name: model; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.model VALUES (2, 326, 'BMW IX', 1);
INSERT INTO public.model VALUES (3, 653, 'BMW XM', 1);


--
-- TOC entry 3325 (class 0 OID 16471)
-- Dependencies: 215
-- Data for Name: vehicle_brand; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.vehicle_brand VALUES (1, 'BMW', 'Low');


--
-- TOC entry 3333 (class 0 OID 0)
-- Dependencies: 216
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 3, true);


--
-- TOC entry 3178 (class 2606 OID 16470)
-- Name: model model_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.model
    ADD CONSTRAINT model_pkey PRIMARY KEY (id);


--
-- TOC entry 3180 (class 2606 OID 16475)
-- Name: vehicle_brand vehicle_brand_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vehicle_brand
    ADD CONSTRAINT vehicle_brand_pkey PRIMARY KEY (id);


--
-- TOC entry 3181 (class 2606 OID 16477)
-- Name: model fkdrjn5pstltn4c4o3nexhsjiwc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.model
    ADD CONSTRAINT fkdrjn5pstltn4c4o3nexhsjiwc FOREIGN KEY (vehicle_brand_id) REFERENCES public.vehicle_brand(id) ON DELETE CASCADE;


-- Completed on 2023-04-26 23:05:32

--
-- PostgreSQL database dump complete
--

