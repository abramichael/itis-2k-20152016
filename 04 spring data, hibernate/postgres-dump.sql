--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.3
-- Dumped by pg_dump version 9.3.3
-- Started on 2016-04-14 09:57:53

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 174 (class 3079 OID 11750)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1954 (class 0 OID 0)
-- Dependencies: 174
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 171 (class 1259 OID 221598)
-- Name: groups; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE groups (
    id integer NOT NULL,
    name character varying(15) NOT NULL
);


ALTER TABLE public.groups OWNER TO postgres;

--
-- TOC entry 170 (class 1259 OID 221596)
-- Name: group_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE group_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.group_id_seq OWNER TO postgres;

--
-- TOC entry 1955 (class 0 OID 0)
-- Dependencies: 170
-- Name: group_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE group_id_seq OWNED BY groups.id;


--
-- TOC entry 173 (class 1259 OID 221606)
-- Name: students; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE students (
    id integer NOT NULL,
    name character varying(30) NOT NULL,
    year integer,
    group_id integer NOT NULL
);


ALTER TABLE public.students OWNER TO postgres;

--
-- TOC entry 172 (class 1259 OID 221604)
-- Name: students_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE students_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.students_id_seq OWNER TO postgres;

--
-- TOC entry 1956 (class 0 OID 0)
-- Dependencies: 172
-- Name: students_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE students_id_seq OWNED BY students.id;


--
-- TOC entry 1829 (class 2604 OID 221601)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY groups ALTER COLUMN id SET DEFAULT nextval('group_id_seq'::regclass);


--
-- TOC entry 1830 (class 2604 OID 221609)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY students ALTER COLUMN id SET DEFAULT nextval('students_id_seq'::regclass);


--
-- TOC entry 1957 (class 0 OID 0)
-- Dependencies: 170
-- Name: group_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('group_id_seq', 9, true);


--
-- TOC entry 1944 (class 0 OID 221598)
-- Dependencies: 171
-- Data for Name: groups; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY groups (id, name) FROM stdin;
1	11-405
2	11-402
3	11-401
9	09-53a
\.


--
-- TOC entry 1946 (class 0 OID 221606)
-- Dependencies: 173
-- Data for Name: students; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY students (id, name, year, group_id) FROM stdin;
1	Khramov	1996	1
2	Mironov	1996	3
3	Sharipova	1995	3
4	Vladimirov	1996	3
5	Skobelev	1996	3
6	Lonina	1996	3
8	Lazarev	1996	3
9	Khadeev	1996	2
10	Egorov	1996	2
11	Tlitova	1996	2
12	Gilmanova	1996	1
13	Gilyazova	1996	1
\.


--
-- TOC entry 1958 (class 0 OID 0)
-- Dependencies: 172
-- Name: students_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('students_id_seq', 17, true);


--
-- TOC entry 1832 (class 2606 OID 221603)
-- Name: group_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY groups
    ADD CONSTRAINT group_pkey PRIMARY KEY (id);


--
-- TOC entry 1834 (class 2606 OID 221611)
-- Name: students_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY students
    ADD CONSTRAINT students_pkey PRIMARY KEY (id);


--
-- TOC entry 1835 (class 2606 OID 221612)
-- Name: students_group_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY students
    ADD CONSTRAINT students_group_id_fkey FOREIGN KEY (group_id) REFERENCES groups(id);


--
-- TOC entry 1953 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-04-14 09:57:53

--
-- PostgreSQL database dump complete
--

