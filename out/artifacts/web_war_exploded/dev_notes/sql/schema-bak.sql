-- Table: album

-- DROP TABLE album;

CREATE TABLE album
(
  id serial NOT NULL,
  "name" character varying,
  description character varying(500),
  CONSTRAINT album_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE album OWNER TO postgres;




--
-- PostgreSQL database dump
--

-- Started on 2011-02-13 20:30:44 EST

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- TOC entry 340 (class 2612 OID 25155)
-- Name: plpgsql; Type: PROCEDURAL LANGUAGE; Schema: -; Owner: -
--

CREATE PROCEDURAL LANGUAGE plpgsql;


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 1527 (class 1259 OID 25156)
-- Dependencies: 6
-- Name: author; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE author (
    username character varying(50) NOT NULL,
    password character varying(50) NOT NULL,
    email character varying(50) NOT NULL,
    author_id integer NOT NULL
);


--
-- TOC entry 1867 (class 0 OID 0)
-- Dependencies: 1527
-- Name: TABLE author; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON TABLE author IS 'basic information abou the author';


--
-- TOC entry 1868 (class 0 OID 0)
-- Dependencies: 1527
-- Name: COLUMN author.username; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN author.username IS 'story author''s User Name';


--
-- TOC entry 1869 (class 0 OID 0)
-- Dependencies: 1527
-- Name: COLUMN author.password; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN author.password IS 'user''s password, to be encrypted';


--
-- TOC entry 1870 (class 0 OID 0)
-- Dependencies: 1527
-- Name: COLUMN author.email; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN author.email IS 'author''s email';


--
-- TOC entry 1528 (class 1259 OID 25159)
-- Dependencies: 6
-- Name: authorities; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE authorities (
    username character varying(50) NOT NULL,
    authority character varying(50) NOT NULL
);


--
-- TOC entry 1529 (class 1259 OID 25162)
-- Dependencies: 1824 6
-- Name: comment; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE comment (
    content_page_id integer NOT NULL,
    commenter character varying NOT NULL,
    body text NOT NULL,
    entered_on date DEFAULT now() NOT NULL,
    email character varying(50),
    id integer NOT NULL,
    website character varying(250)
);


--
-- TOC entry 1530 (class 1259 OID 25169)
-- Dependencies: 1529 6
-- Name: comment_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE comment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1871 (class 0 OID 0)
-- Dependencies: 1530
-- Name: comment_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE comment_id_seq OWNED BY comment.id;


--
-- TOC entry 1531 (class 1259 OID 25171)
-- Dependencies: 1826 1827 6
-- Name: content_page; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE content_page (
    id integer NOT NULL,
    navigation_section_id integer,
    meta_description character varying(500),
    meta_keywords character varying(500),
    content text,
    title character varying(250),
    sub_title character varying(500),
    allow_comments boolean DEFAULT false,
    completion boolean DEFAULT false,
    link_href character varying(250),
    link_label character varying(250),
    content_page_display_order integer NOT NULL,
    modified timestamp without time zone
);


--
-- TOC entry 1546 (class 1259 OID 25287)
-- Dependencies: 6
-- Name: content_page_comment; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE content_page_comment (
    content_page_id integer NOT NULL,
    comment_id integer NOT NULL
);


--
-- TOC entry 1532 (class 1259 OID 25179)
-- Dependencies: 1531 6
-- Name: content_page_content_page_display_order_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE content_page_content_page_display_order_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1872 (class 0 OID 0)
-- Dependencies: 1532
-- Name: content_page_content_page_display_order_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE content_page_content_page_display_order_seq OWNED BY content_page.content_page_display_order;


--
-- TOC entry 1533 (class 1259 OID 25181)
-- Dependencies: 1531 6
-- Name: content_page_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE content_page_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1873 (class 0 OID 0)
-- Dependencies: 1533
-- Name: content_page_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE content_page_id_seq OWNED BY content_page.id;


--
-- TOC entry 1534 (class 1259 OID 25183)
-- Dependencies: 6
-- Name: content_page_image_css; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE content_page_image_css (
    content_page_name character varying,
    css character varying,
    image_name character varying(50)
);


--
-- TOC entry 1874 (class 0 OID 0)
-- Dependencies: 1534
-- Name: TABLE content_page_image_css; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON TABLE content_page_image_css IS 'style sheet data for images used as content page decorations, or as inline parts of a page.';


--
-- TOC entry 1875 (class 0 OID 0)
-- Dependencies: 1534
-- Name: COLUMN content_page_image_css.css; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN content_page_image_css.css IS 'style sheet info itself';


--
-- TOC entry 1535 (class 1259 OID 25189)
-- Dependencies: 6
-- Name: content_page_order; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE content_page_order (
    id integer NOT NULL,
    "position" integer
);


--
-- TOC entry 1536 (class 1259 OID 25192)
-- Dependencies: 6
-- Name: content_page_tag; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE content_page_tag (
    tag_id integer,
    content_page_id integer NOT NULL
);


--
-- TOC entry 1537 (class 1259 OID 25195)
-- Dependencies: 6
-- Name: image; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE image (
    id integer NOT NULL,
    src character varying NOT NULL,
    alt character varying(250) NOT NULL,
    description character varying(500),
    width integer,
    height integer
);


--
-- TOC entry 1538 (class 1259 OID 25201)
-- Dependencies: 1537 6
-- Name: image_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE image_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1876 (class 0 OID 0)
-- Dependencies: 1538
-- Name: image_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE image_id_seq OWNED BY image.id;


-- Table: album_image

-- DROP TABLE album_image;

CREATE TABLE album_image
(
  album_id integer NOT NULL,
  image_id integer NOT NULL,
  CONSTRAINT album_image_album_id_fkey FOREIGN KEY (album_id)
      REFERENCES album (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT album_image_image_id_fkey FOREIGN KEY (image_id)
      REFERENCES image (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE album_image OWNER TO postgres;



--
-- TOC entry 1539 (class 1259 OID 25203)
-- Dependencies: 6
-- Name: navigation; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE navigation (
    id integer NOT NULL
);


--
-- TOC entry 1540 (class 1259 OID 25206)
-- Dependencies: 1539 6
-- Name: navigation_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE navigation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1877 (class 0 OID 0)
-- Dependencies: 1540
-- Name: navigation_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE navigation_id_seq OWNED BY navigation.id;


--
-- TOC entry 1541 (class 1259 OID 25208)
-- Dependencies: 1832 6
-- Name: navigation_section; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE navigation_section (
    id integer NOT NULL,
    label character varying(250) NOT NULL,
    href character varying(250) DEFAULT '#'::character varying NOT NULL,
    navigation_id integer
);


--
-- TOC entry 1542 (class 1259 OID 25215)
-- Dependencies: 6 1541
-- Name: navigation_section_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE navigation_section_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1878 (class 0 OID 0)
-- Dependencies: 1542
-- Name: navigation_section_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE navigation_section_id_seq OWNED BY navigation_section.id;


--
-- TOC entry 1543 (class 1259 OID 25217)
-- Dependencies: 6
-- Name: tag; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE tag (
    id integer NOT NULL,
    description character varying(250) NOT NULL
);


--
-- TOC entry 1544 (class 1259 OID 25220)
-- Dependencies: 6 1543
-- Name: tags_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE tags_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1879 (class 0 OID 0)
-- Dependencies: 1544
-- Name: tags_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE tags_id_seq OWNED BY tag.id;


--
-- TOC entry 1545 (class 1259 OID 25222)
-- Dependencies: 6
-- Name: users; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE users (
    username character varying(50) NOT NULL,
    password character varying(250) NOT NULL,
    enabled boolean NOT NULL
);


--
-- TOC entry 1825 (class 2604 OID 25225)
-- Dependencies: 1530 1529
-- Name: id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE comment ALTER COLUMN id SET DEFAULT nextval('comment_id_seq'::regclass);


--
-- TOC entry 1828 (class 2604 OID 25226)
-- Dependencies: 1533 1531
-- Name: id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE content_page ALTER COLUMN id SET DEFAULT nextval('content_page_id_seq'::regclass);


--
-- TOC entry 1829 (class 2604 OID 25227)
-- Dependencies: 1532 1531
-- Name: content_page_display_order; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE content_page ALTER COLUMN content_page_display_order SET DEFAULT nextval('content_page_content_page_display_order_seq'::regclass);


--
-- TOC entry 1830 (class 2604 OID 25228)
-- Dependencies: 1538 1537
-- Name: id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE image ALTER COLUMN id SET DEFAULT nextval('image_id_seq'::regclass);


--
-- TOC entry 1831 (class 2604 OID 25229)
-- Dependencies: 1540 1539
-- Name: id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE navigation ALTER COLUMN id SET DEFAULT nextval('navigation_id_seq'::regclass);


--
-- TOC entry 1833 (class 2604 OID 25230)
-- Dependencies: 1542 1541
-- Name: id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE navigation_section ALTER COLUMN id SET DEFAULT nextval('navigation_section_id_seq'::regclass);


--
-- TOC entry 1834 (class 2604 OID 25231)
-- Dependencies: 1544 1543
-- Name: id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE tag ALTER COLUMN id SET DEFAULT nextval('tags_id_seq'::regclass);


--
-- TOC entry 1836 (class 2606 OID 25233)
-- Dependencies: 1528 1528
-- Name: authorities_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY authorities
    ADD CONSTRAINT authorities_pkey PRIMARY KEY (username);


--
-- TOC entry 1839 (class 2606 OID 25235)
-- Dependencies: 1529 1529
-- Name: comment_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY comment
    ADD CONSTRAINT comment_pkey PRIMARY KEY (id);


--
-- TOC entry 1843 (class 2606 OID 25237)
-- Dependencies: 1535 1535
-- Name: content_page_order_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY content_page_order
    ADD CONSTRAINT content_page_order_pkey PRIMARY KEY (id);


--
-- TOC entry 1841 (class 2606 OID 25239)
-- Dependencies: 1531 1531
-- Name: content_page_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY content_page
    ADD CONSTRAINT content_page_pkey PRIMARY KEY (id);


--
-- TOC entry 1845 (class 2606 OID 25241)
-- Dependencies: 1537 1537
-- Name: image_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY image
    ADD CONSTRAINT image_pkey PRIMARY KEY (id);


--
-- TOC entry 1847 (class 2606 OID 25243)
-- Dependencies: 1539 1539
-- Name: navigation_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY navigation
    ADD CONSTRAINT navigation_pkey PRIMARY KEY (id);


--
-- TOC entry 1849 (class 2606 OID 25245)
-- Dependencies: 1541 1541
-- Name: navigation_section_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY navigation_section
    ADD CONSTRAINT navigation_section_pkey PRIMARY KEY (id);


--
-- TOC entry 1851 (class 2606 OID 25247)
-- Dependencies: 1543 1543
-- Name: tags_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY tag
    ADD CONSTRAINT tags_pkey PRIMARY KEY (id);


--
-- TOC entry 1853 (class 2606 OID 25249)
-- Dependencies: 1545 1545
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (username);


--
-- TOC entry 1837 (class 1259 OID 25250)
-- Dependencies: 1528 1528
-- Name: ix_auth_username; Type: INDEX; Schema: public; Owner: -; Tablespace: 
--

CREATE UNIQUE INDEX ix_auth_username ON authorities USING btree (username, authority);


--
-- TOC entry 1855 (class 2606 OID 25282)
-- Dependencies: 1531 1529 1840
-- Name: comment_content_page_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY comment
    ADD CONSTRAINT comment_content_page_id_fkey FOREIGN KEY (content_page_id) REFERENCES content_page(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1861 (class 2606 OID 25295)
-- Dependencies: 1529 1546 1838
-- Name: content_page_comment_comment_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY content_page_comment
    ADD CONSTRAINT content_page_comment_comment_id_fkey FOREIGN KEY (comment_id) REFERENCES comment(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1860 (class 2606 OID 25290)
-- Dependencies: 1531 1840 1546
-- Name: content_page_comment_content_page_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY content_page_comment
    ADD CONSTRAINT content_page_comment_content_page_id_fkey FOREIGN KEY (content_page_id) REFERENCES content_page(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1856 (class 2606 OID 25256)
-- Dependencies: 1848 1541 1531
-- Name: content_page_navigation_section_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY content_page
    ADD CONSTRAINT content_page_navigation_section_id_fkey FOREIGN KEY (navigation_section_id) REFERENCES navigation_section(id);


--
-- TOC entry 1857 (class 2606 OID 25261)
-- Dependencies: 1536 1840 1531
-- Name: content_page_tag_content_page_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY content_page_tag
    ADD CONSTRAINT content_page_tag_content_page_id_fkey FOREIGN KEY (content_page_id) REFERENCES content_page(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1858 (class 2606 OID 25266)
-- Dependencies: 1543 1536 1850
-- Name: content_page_tag_tag_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY content_page_tag
    ADD CONSTRAINT content_page_tag_tag_id_fkey FOREIGN KEY (tag_id) REFERENCES tag(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1854 (class 2606 OID 25271)
-- Dependencies: 1852 1545 1528
-- Name: fk_authorities_users; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY authorities
    ADD CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users(username);


--
-- TOC entry 1859 (class 2606 OID 25276)
-- Dependencies: 1539 1541 1846
-- Name: navigation_section_navigation_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY navigation_section
    ADD CONSTRAINT navigation_section_navigation_id_fkey FOREIGN KEY (navigation_id) REFERENCES navigation(id);


--
-- TOC entry 1866 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: -
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2011-02-13 20:30:44 EST

--
-- PostgreSQL database dump complete
--

