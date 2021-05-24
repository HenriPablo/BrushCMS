--
-- PostgreSQL database dump
--

-- Dumped from database version 11.12 (Ubuntu 11.12-1.pgdg16.04+1)
-- Dumped by pg_dump version 11.12 (Ubuntu 11.12-1.pgdg16.04+1)

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

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: album; Type: TABLE; Schema: public; Owner: tomekpilot
--

CREATE TABLE public.album (
    id integer NOT NULL,
    name character varying,
    description character varying(500)
);


ALTER TABLE public.album OWNER TO tomekpilot;

--
-- Name: album_id_seq; Type: SEQUENCE; Schema: public; Owner: tomekpilot
--

CREATE SEQUENCE public.album_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.album_id_seq OWNER TO tomekpilot;

--
-- Name: album_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: tomekpilot
--

ALTER SEQUENCE public.album_id_seq OWNED BY public.album.id;


--
-- Name: album_image; Type: TABLE; Schema: public; Owner: tomekpilot
--

CREATE TABLE public.album_image (
    album_id integer NOT NULL,
    image_id integer NOT NULL
);


ALTER TABLE public.album_image OWNER TO tomekpilot;

--
-- Name: author; Type: TABLE; Schema: public; Owner: tomekpilot
--

CREATE TABLE public.author (
    username character varying(50) NOT NULL,
    password character varying(50) NOT NULL,
    email character varying(50) NOT NULL,
    author_id integer NOT NULL
);


ALTER TABLE public.author OWNER TO tomekpilot;

--
-- Name: TABLE author; Type: COMMENT; Schema: public; Owner: tomekpilot
--

COMMENT ON TABLE public.author IS 'basic information abou the author';


--
-- Name: COLUMN author.username; Type: COMMENT; Schema: public; Owner: tomekpilot
--

COMMENT ON COLUMN public.author.username IS 'story author''s User Name';


--
-- Name: COLUMN author.password; Type: COMMENT; Schema: public; Owner: tomekpilot
--

COMMENT ON COLUMN public.author.password IS 'user''s password, to be encrypted';


--
-- Name: COLUMN author.email; Type: COMMENT; Schema: public; Owner: tomekpilot
--

COMMENT ON COLUMN public.author.email IS 'author''s email';


--
-- Name: authorities; Type: TABLE; Schema: public; Owner: tomekpilot
--

CREATE TABLE public.authorities (
    username character varying(50) NOT NULL,
    authority character varying(50) NOT NULL
);


ALTER TABLE public.authorities OWNER TO tomekpilot;

--
-- Name: comment; Type: TABLE; Schema: public; Owner: tomekpilot
--

CREATE TABLE public.comment (
    content_page_id integer NOT NULL,
    commenter character varying NOT NULL,
    body text NOT NULL,
    entered_on date DEFAULT now() NOT NULL,
    email character varying(50),
    id integer NOT NULL,
    website character varying(250)
);


ALTER TABLE public.comment OWNER TO tomekpilot;

--
-- Name: comment_id_seq; Type: SEQUENCE; Schema: public; Owner: tomekpilot
--

CREATE SEQUENCE public.comment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.comment_id_seq OWNER TO tomekpilot;

--
-- Name: comment_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: tomekpilot
--

ALTER SEQUENCE public.comment_id_seq OWNED BY public.comment.id;


--
-- Name: content_page; Type: TABLE; Schema: public; Owner: tomekpilot
--

CREATE TABLE public.content_page (
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


ALTER TABLE public.content_page OWNER TO tomekpilot;

--
-- Name: content_page_album; Type: TABLE; Schema: public; Owner: tomekpilot
--

CREATE TABLE public.content_page_album (
    content_page_id integer,
    album_id integer
);


ALTER TABLE public.content_page_album OWNER TO tomekpilot;

--
-- Name: content_page_comment; Type: TABLE; Schema: public; Owner: tomekpilot
--

CREATE TABLE public.content_page_comment (
    content_page_id integer NOT NULL,
    comment_id integer NOT NULL
);


ALTER TABLE public.content_page_comment OWNER TO tomekpilot;

--
-- Name: content_page_content_page_display_order_seq; Type: SEQUENCE; Schema: public; Owner: tomekpilot
--

CREATE SEQUENCE public.content_page_content_page_display_order_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.content_page_content_page_display_order_seq OWNER TO tomekpilot;

--
-- Name: content_page_content_page_display_order_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: tomekpilot
--

ALTER SEQUENCE public.content_page_content_page_display_order_seq OWNED BY public.content_page.content_page_display_order;


--
-- Name: content_page_id_seq; Type: SEQUENCE; Schema: public; Owner: tomekpilot
--

CREATE SEQUENCE public.content_page_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.content_page_id_seq OWNER TO tomekpilot;

--
-- Name: content_page_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: tomekpilot
--

ALTER SEQUENCE public.content_page_id_seq OWNED BY public.content_page.id;


--
-- Name: content_page_image_css; Type: TABLE; Schema: public; Owner: tomekpilot
--

CREATE TABLE public.content_page_image_css (
    content_page_name character varying,
    css character varying,
    image_name character varying(50)
);


ALTER TABLE public.content_page_image_css OWNER TO tomekpilot;

--
-- Name: TABLE content_page_image_css; Type: COMMENT; Schema: public; Owner: tomekpilot
--

COMMENT ON TABLE public.content_page_image_css IS 'style sheet data for images used as content page decorations, or as inline parts of a page.';


--
-- Name: COLUMN content_page_image_css.css; Type: COMMENT; Schema: public; Owner: tomekpilot
--

COMMENT ON COLUMN public.content_page_image_css.css IS 'style sheet info itself';


--
-- Name: content_page_main_pix; Type: TABLE; Schema: public; Owner: tomekpilot
--

CREATE TABLE public.content_page_main_pix (
    content_page_id integer NOT NULL,
    main_pix_id integer NOT NULL
);


ALTER TABLE public.content_page_main_pix OWNER TO tomekpilot;

--
-- Name: content_page_order; Type: TABLE; Schema: public; Owner: tomekpilot
--

CREATE TABLE public.content_page_order (
    id integer NOT NULL,
    "position" integer
);


ALTER TABLE public.content_page_order OWNER TO tomekpilot;

--
-- Name: content_page_tag; Type: TABLE; Schema: public; Owner: tomekpilot
--

CREATE TABLE public.content_page_tag (
    tag_id integer,
    content_page_id integer NOT NULL
);


ALTER TABLE public.content_page_tag OWNER TO tomekpilot;

--
-- Name: image; Type: TABLE; Schema: public; Owner: tomekpilot
--

CREATE TABLE public.image (
    id integer NOT NULL,
    src character varying NOT NULL,
    alt character varying(250) NOT NULL,
    description character varying(500),
    width integer,
    height integer
);


ALTER TABLE public.image OWNER TO tomekpilot;

--
-- Name: image_id_seq; Type: SEQUENCE; Schema: public; Owner: tomekpilot
--

CREATE SEQUENCE public.image_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.image_id_seq OWNER TO tomekpilot;

--
-- Name: image_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: tomekpilot
--

ALTER SEQUENCE public.image_id_seq OWNED BY public.image.id;


--
-- Name: navigation; Type: TABLE; Schema: public; Owner: tomekpilot
--

CREATE TABLE public.navigation (
    id integer NOT NULL,
    label character varying(250),
    code character varying(250)
);


ALTER TABLE public.navigation OWNER TO tomekpilot;

--
-- Name: navigation_id_seq; Type: SEQUENCE; Schema: public; Owner: tomekpilot
--

CREATE SEQUENCE public.navigation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.navigation_id_seq OWNER TO tomekpilot;

--
-- Name: navigation_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: tomekpilot
--

ALTER SEQUENCE public.navigation_id_seq OWNED BY public.navigation.id;


--
-- Name: navigation_section; Type: TABLE; Schema: public; Owner: tomekpilot
--

CREATE TABLE public.navigation_section (
    id integer NOT NULL,
    label character varying(250) NOT NULL,
    href character varying(250) DEFAULT '#'::character varying NOT NULL,
    navigation_id integer
);


ALTER TABLE public.navigation_section OWNER TO tomekpilot;

--
-- Name: navigation_section_id_seq; Type: SEQUENCE; Schema: public; Owner: tomekpilot
--

CREATE SEQUENCE public.navigation_section_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.navigation_section_id_seq OWNER TO tomekpilot;

--
-- Name: navigation_section_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: tomekpilot
--

ALTER SEQUENCE public.navigation_section_id_seq OWNED BY public.navigation_section.id;


--
-- Name: setting_id_seq; Type: SEQUENCE; Schema: public; Owner: tomekpilot
--

CREATE SEQUENCE public.setting_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.setting_id_seq OWNER TO tomekpilot;

--
-- Name: setting; Type: TABLE; Schema: public; Owner: tomekpilot
--

CREATE TABLE public.setting (
    id integer DEFAULT nextval('public.setting_id_seq'::regclass) NOT NULL,
    label character varying NOT NULL,
    value character varying,
    settings_group_id integer,
    hint character varying,
    code character varying
);


ALTER TABLE public.setting OWNER TO tomekpilot;

--
-- Name: settings_group_id_seq; Type: SEQUENCE; Schema: public; Owner: tomekpilot
--

CREATE SEQUENCE public.settings_group_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.settings_group_id_seq OWNER TO tomekpilot;

--
-- Name: settings_group; Type: TABLE; Schema: public; Owner: tomekpilot
--

CREATE TABLE public.settings_group (
    id integer DEFAULT nextval('public.settings_group_id_seq'::regclass) NOT NULL,
    name character varying(255) NOT NULL,
    code character varying(255) NOT NULL,
    parent_id integer
);


ALTER TABLE public.settings_group OWNER TO tomekpilot;

--
-- Name: settings_group_id_seq1; Type: SEQUENCE; Schema: public; Owner: tomekpilot
--

CREATE SEQUENCE public.settings_group_id_seq1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.settings_group_id_seq1 OWNER TO tomekpilot;

--
-- Name: settings_group_id_seq1; Type: SEQUENCE OWNED BY; Schema: public; Owner: tomekpilot
--

ALTER SEQUENCE public.settings_group_id_seq1 OWNED BY public.settings_group.id;


--
-- Name: tag; Type: TABLE; Schema: public; Owner: tomekpilot
--

CREATE TABLE public.tag (
    id integer NOT NULL,
    description character varying(250) NOT NULL
);


ALTER TABLE public.tag OWNER TO tomekpilot;

--
-- Name: tags_id_seq; Type: SEQUENCE; Schema: public; Owner: tomekpilot
--

CREATE SEQUENCE public.tags_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tags_id_seq OWNER TO tomekpilot;

--
-- Name: tags_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: tomekpilot
--

ALTER SEQUENCE public.tags_id_seq OWNED BY public.tag.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: tomekpilot
--

CREATE TABLE public.users (
    username character varying(50) NOT NULL,
    password character varying(250) NOT NULL,
    enabled boolean NOT NULL
);


ALTER TABLE public.users OWNER TO tomekpilot;

--
-- Name: album id; Type: DEFAULT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.album ALTER COLUMN id SET DEFAULT nextval('public.album_id_seq'::regclass);


--
-- Name: comment id; Type: DEFAULT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.comment ALTER COLUMN id SET DEFAULT nextval('public.comment_id_seq'::regclass);


--
-- Name: content_page id; Type: DEFAULT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.content_page ALTER COLUMN id SET DEFAULT nextval('public.content_page_id_seq'::regclass);


--
-- Name: content_page content_page_display_order; Type: DEFAULT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.content_page ALTER COLUMN content_page_display_order SET DEFAULT nextval('public.content_page_content_page_display_order_seq'::regclass);


--
-- Name: image id; Type: DEFAULT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.image ALTER COLUMN id SET DEFAULT nextval('public.image_id_seq'::regclass);


--
-- Name: navigation id; Type: DEFAULT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.navigation ALTER COLUMN id SET DEFAULT nextval('public.navigation_id_seq'::regclass);


--
-- Name: navigation_section id; Type: DEFAULT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.navigation_section ALTER COLUMN id SET DEFAULT nextval('public.navigation_section_id_seq'::regclass);


--
-- Name: tag id; Type: DEFAULT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.tag ALTER COLUMN id SET DEFAULT nextval('public.tags_id_seq'::regclass);


--
-- Data for Name: album; Type: TABLE DATA; Schema: public; Owner: tomekpilot
--

COPY public.album (id, name, description) FROM stdin;
5	testalbum2	test album 2
6	Test Album 3	testing new album form
\.


--
-- Data for Name: album_image; Type: TABLE DATA; Schema: public; Owner: tomekpilot
--

COPY public.album_image (album_id, image_id) FROM stdin;
6	87
6	91
6	94
\.


--
-- Data for Name: author; Type: TABLE DATA; Schema: public; Owner: tomekpilot
--

COPY public.author (username, password, email, author_id) FROM stdin;
tomekpilot	3YEvPLX8VUoziDMg29i0qxh60PU=	tomek_pilot@yahoo.com	0
tomekpilot	3YEvPLX8VUoziDMg29i0qxh60PU=	tomek_pilot@yahoo.com	0
\.


--
-- Data for Name: authorities; Type: TABLE DATA; Schema: public; Owner: tomekpilot
--

COPY public.authorities (username, authority) FROM stdin;
\.


--
-- Data for Name: comment; Type: TABLE DATA; Schema: public; Owner: tomekpilot
--

COPY public.comment (content_page_id, commenter, body, entered_on, email, id, website) FROM stdin;
\.


--
-- Data for Name: content_page; Type: TABLE DATA; Schema: public; Owner: tomekpilot
--

COPY public.content_page (id, navigation_section_id, meta_description, meta_keywords, content, title, sub_title, allow_comments, completion, link_href, link_label, content_page_display_order, modified) FROM stdin;
70	20	some description	some keywordss	article content body	some article title	nice subtitle	f	f	some_link_href	link label	0	2013-11-20 07:49:21.17
64	20	default description	default meta tags	drawing &amp;nbsp; body contents&amp;nbsp;&lt;img alt="alternative text" id="74" src="http://localhost:8080/bandp/art/upload/thm/1596590.jpg" /&gt;&amp;nbsp;And a litle edit test	updated article title	drawing section sub title	f	f	drawing	drawing	0	2013-11-21 21:37:15.453
67	28	default description	default meta tags	<div style="clear:both">faslfkja;slfj &nbsp; &nbsp; jsdfja sj fasfjafs fas fa f adf asf a &nbsp;fg dfg asf asf as dfa sf sdf asdf as sd fasd fa sf asdf asdf asd fasd fasd fa sdf asd fasd f asdf asd f asdf asd fasd f asdf asd fa sdf asdf as df asf asd fa sdf sadf asd f asdf asd fsd f f sdfsd sdf asd fa sdf asdf sdaf sda f sdaf sdaf sda fsd</div><div style="clear:both"><br></div><div style="clear:both"><img src="/brush/art/upload/thm/Air_mail._15_c.jpg"><br></div><div style="clear:both"><br></div><div style="clear:both">asdf</div><div style="clear:both"><img src="/brush/art/upload/thm/Starry_Night_Over_the_Rhone.jpg"><br></div><div style="clear:both">asf</div><div style="clear:both">as</div><div style="clear:both">fa</div><div style="clear:both">sdf</div><div style="clear:both">asdf</div><div style="clear:both">asd</div><p>\r\n</p>	1st article	1st article title	f	f	1starticle	1st article	0	2013-07-07 15:20:14.201
68	28		default meta tags	articles home page	articles pages	articles page	f	f	articles	articles	0	2013-01-22 22:30:07.574
41	27	some description	some keywordss	painting body contents	Painting	SUB TITLE: painting	f	f	painting	painting	0	2013-02-14 22:38:26.842
65	20	default description	default meta tags	artwork body contents	artwork home page	artwork home page - sub title	f	f	artwork	artwork	0	2013-02-24 10:58:03.947
\.


--
-- Data for Name: content_page_album; Type: TABLE DATA; Schema: public; Owner: tomekpilot
--

COPY public.content_page_album (content_page_id, album_id) FROM stdin;
67	5
64	5
\.


--
-- Data for Name: content_page_comment; Type: TABLE DATA; Schema: public; Owner: tomekpilot
--

COPY public.content_page_comment (content_page_id, comment_id) FROM stdin;
\.


--
-- Data for Name: content_page_image_css; Type: TABLE DATA; Schema: public; Owner: tomekpilot
--

COPY public.content_page_image_css (content_page_name, css, image_name) FROM stdin;
Insert_Update_troubleshoot	position:absolute;\n\ntop: 0;\n\nleft: 150px;\n\nborder: 1px solid red;	IMGP0010.jpg
Insert_Update_troubleshoot	position:absolute;\n\ntop: 0;\n\nleft: 150px;\n\nborder: 1px solid red;	IMGP0010.jpg
\.


--
-- Data for Name: content_page_main_pix; Type: TABLE DATA; Schema: public; Owner: tomekpilot
--

COPY public.content_page_main_pix (content_page_id, main_pix_id) FROM stdin;
67	87
65	93
70	96
64	97
\.


--
-- Data for Name: content_page_order; Type: TABLE DATA; Schema: public; Owner: tomekpilot
--

COPY public.content_page_order (id, "position") FROM stdin;
320	54
326	61
322	57
321	55
312	56
308	47
319	43
\.


--
-- Data for Name: content_page_tag; Type: TABLE DATA; Schema: public; Owner: tomekpilot
--

COPY public.content_page_tag (tag_id, content_page_id) FROM stdin;
36	41
36	65
36	67
23	70
23	64
\.


--
-- Data for Name: image; Type: TABLE DATA; Schema: public; Owner: tomekpilot
--

COPY public.image (id, src, alt, description, width, height) FROM stdin;
95	Fleet_Air_Arm_pilots_and_a_Gloster_Gladiator_at_HMS_SPARROWHAWK,_the_Royal_Naval_Air_Station_at_Hatston_on_Orkney,_April_1942._A8220.jpg	fleet air	fleet air	794	599
96	image_name	alternative text	Image description	100	100
97	image_name	alternative text	Image description	100	100
87	2008_04_15-PlaneFood.jpg	samich	samich pix test	504	342
88	Dougal-Photo-Dec-30,-10-27-14-PM.jpg	dougster	dougall	450	600
89	Dougal-Photo-Dec-30,-10-27-14-PM.jpg	dougster	dougall	450	600
90	disapprovers-9-3-12.jpg	disapprovers	Painting of abstruct disapproving rabbits	3311	2626
91	Clone of DSCF3005-1600x900.JPG	cinnamon painted	First Cinnamon Painting	1600	900
92	Starry_Night_Over_the_Rhone.jpg	stary night	starry night	2000	1333
93	Air_mail._15_c.jpg	air mail	air mail	1968	1224
94	air-mail-stamp-1.jpg	air mail 2	air mail 2	873	519
\.


--
-- Data for Name: navigation; Type: TABLE DATA; Schema: public; Owner: tomekpilot
--

COPY public.navigation (id, label, code) FROM stdin;
9	header	header
11	footer	footer
13	sideNav1	sideNav1
22	sideNav2	sideNav2
23	smallHeader	smallHeader
24	smallFooter	smallFooter
\.


--
-- Data for Name: navigation_section; Type: TABLE DATA; Schema: public; Owner: tomekpilot
--

COPY public.navigation_section (id, label, href, navigation_id) FROM stdin;
20	services	services	11
27	artwork	artwork	9
28	articles	articles	9
\.


--
-- Data for Name: setting; Type: TABLE DATA; Schema: public; Owner: tomekpilot
--

COPY public.setting (id, label, value, settings_group_id, hint, code) FROM stdin;
92	pix.width	116	199	width of pix	pix.width
\.


--
-- Data for Name: settings_group; Type: TABLE DATA; Schema: public; Owner: tomekpilot
--

COPY public.settings_group (id, name, code, parent_id) FROM stdin;
196	setting group 2 name in setup	setting_group_2_code_in_setup	\N
197	setting group 322	setting_group_3	\N
199	pix	pix	\N
\.


--
-- Data for Name: tag; Type: TABLE DATA; Schema: public; Owner: tomekpilot
--

COPY public.tag (id, description) FROM stdin;
3	hibernate fun
36	article
23	tet tag description
37	nt
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: tomekpilot
--

COPY public.users (username, password, enabled) FROM stdin;
tomek	d732f770633a605ac549d9d87fff015d	t
\.


--
-- Name: album_id_seq; Type: SEQUENCE SET; Schema: public; Owner: tomekpilot
--

SELECT pg_catalog.setval('public.album_id_seq', 6, true);


--
-- Name: comment_id_seq; Type: SEQUENCE SET; Schema: public; Owner: tomekpilot
--

SELECT pg_catalog.setval('public.comment_id_seq', 14, true);


--
-- Name: content_page_content_page_display_order_seq; Type: SEQUENCE SET; Schema: public; Owner: tomekpilot
--

SELECT pg_catalog.setval('public.content_page_content_page_display_order_seq', 21, true);


--
-- Name: content_page_id_seq; Type: SEQUENCE SET; Schema: public; Owner: tomekpilot
--

SELECT pg_catalog.setval('public.content_page_id_seq', 70, true);


--
-- Name: image_id_seq; Type: SEQUENCE SET; Schema: public; Owner: tomekpilot
--

SELECT pg_catalog.setval('public.image_id_seq', 97, true);


--
-- Name: navigation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: tomekpilot
--

SELECT pg_catalog.setval('public.navigation_id_seq', 25, true);


--
-- Name: navigation_section_id_seq; Type: SEQUENCE SET; Schema: public; Owner: tomekpilot
--

SELECT pg_catalog.setval('public.navigation_section_id_seq', 29, true);


--
-- Name: setting_id_seq; Type: SEQUENCE SET; Schema: public; Owner: tomekpilot
--

SELECT pg_catalog.setval('public.setting_id_seq', 92, true);


--
-- Name: settings_group_id_seq; Type: SEQUENCE SET; Schema: public; Owner: tomekpilot
--

SELECT pg_catalog.setval('public.settings_group_id_seq', 199, true);


--
-- Name: settings_group_id_seq1; Type: SEQUENCE SET; Schema: public; Owner: tomekpilot
--

SELECT pg_catalog.setval('public.settings_group_id_seq1', 14, true);


--
-- Name: tags_id_seq; Type: SEQUENCE SET; Schema: public; Owner: tomekpilot
--

SELECT pg_catalog.setval('public.tags_id_seq', 37, true);


--
-- Name: album album_pkey; Type: CONSTRAINT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.album
    ADD CONSTRAINT album_pkey PRIMARY KEY (id);


--
-- Name: authorities authorities_pkey; Type: CONSTRAINT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.authorities
    ADD CONSTRAINT authorities_pkey PRIMARY KEY (username);


--
-- Name: comment comment_pkey; Type: CONSTRAINT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT comment_pkey PRIMARY KEY (id);


--
-- Name: content_page_order content_page_order_pkey; Type: CONSTRAINT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.content_page_order
    ADD CONSTRAINT content_page_order_pkey PRIMARY KEY (id);


--
-- Name: content_page content_page_pkey; Type: CONSTRAINT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.content_page
    ADD CONSTRAINT content_page_pkey PRIMARY KEY (id);


--
-- Name: image image_pkey; Type: CONSTRAINT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.image
    ADD CONSTRAINT image_pkey PRIMARY KEY (id);


--
-- Name: navigation navigation_pkey; Type: CONSTRAINT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.navigation
    ADD CONSTRAINT navigation_pkey PRIMARY KEY (id);


--
-- Name: navigation_section navigation_section_pkey; Type: CONSTRAINT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.navigation_section
    ADD CONSTRAINT navigation_section_pkey PRIMARY KEY (id);


--
-- Name: setting setting_pkey; Type: CONSTRAINT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.setting
    ADD CONSTRAINT setting_pkey PRIMARY KEY (id);


--
-- Name: settings_group settings_group_pkey; Type: CONSTRAINT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.settings_group
    ADD CONSTRAINT settings_group_pkey PRIMARY KEY (id);


--
-- Name: tag tags_pkey; Type: CONSTRAINT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.tag
    ADD CONSTRAINT tags_pkey PRIMARY KEY (id);


--
-- Name: setting unique_label; Type: CONSTRAINT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.setting
    ADD CONSTRAINT unique_label UNIQUE (label);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (username);


--
-- Name: ix_auth_username; Type: INDEX; Schema: public; Owner: tomekpilot
--

CREATE UNIQUE INDEX ix_auth_username ON public.authorities USING btree (username, authority);


--
-- Name: album_image album_image_album_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.album_image
    ADD CONSTRAINT album_image_album_id_fkey FOREIGN KEY (album_id) REFERENCES public.album(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: album_image album_image_image_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.album_image
    ADD CONSTRAINT album_image_image_id_fkey FOREIGN KEY (image_id) REFERENCES public.image(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: comment comment_content_page_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT comment_content_page_id_fkey FOREIGN KEY (content_page_id) REFERENCES public.content_page(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: content_page_album content_page_album_album_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.content_page_album
    ADD CONSTRAINT content_page_album_album_id_fkey FOREIGN KEY (album_id) REFERENCES public.album(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: content_page_album content_page_album_content_page_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.content_page_album
    ADD CONSTRAINT content_page_album_content_page_id_fkey FOREIGN KEY (content_page_id) REFERENCES public.content_page(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: content_page_comment content_page_comment_comment_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.content_page_comment
    ADD CONSTRAINT content_page_comment_comment_id_fkey FOREIGN KEY (comment_id) REFERENCES public.comment(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: content_page_comment content_page_comment_content_page_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.content_page_comment
    ADD CONSTRAINT content_page_comment_content_page_id_fkey FOREIGN KEY (content_page_id) REFERENCES public.content_page(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: content_page_main_pix content_page_main_pix_content_page_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.content_page_main_pix
    ADD CONSTRAINT content_page_main_pix_content_page_id_fkey FOREIGN KEY (content_page_id) REFERENCES public.content_page(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: content_page_main_pix content_page_main_pix_main_pix_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.content_page_main_pix
    ADD CONSTRAINT content_page_main_pix_main_pix_id_fkey FOREIGN KEY (main_pix_id) REFERENCES public.image(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: content_page content_page_navigation_section_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.content_page
    ADD CONSTRAINT content_page_navigation_section_id_fkey FOREIGN KEY (navigation_section_id) REFERENCES public.navigation_section(id);


--
-- Name: content_page_tag content_page_tag_content_page_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.content_page_tag
    ADD CONSTRAINT content_page_tag_content_page_id_fkey FOREIGN KEY (content_page_id) REFERENCES public.content_page(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: content_page_tag content_page_tag_tag_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.content_page_tag
    ADD CONSTRAINT content_page_tag_tag_id_fkey FOREIGN KEY (tag_id) REFERENCES public.tag(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: authorities fk_authorities_users; Type: FK CONSTRAINT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.authorities
    ADD CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES public.users(username);


--
-- Name: navigation_section navigation_section_navigation_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.navigation_section
    ADD CONSTRAINT navigation_section_navigation_id_fkey FOREIGN KEY (navigation_id) REFERENCES public.navigation(id);


--
-- Name: setting setting_settings_group_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.setting
    ADD CONSTRAINT setting_settings_group_id_fkey FOREIGN KEY (settings_group_id) REFERENCES public.settings_group(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: settings_group settings_group_parent_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: tomekpilot
--

ALTER TABLE ONLY public.settings_group
    ADD CONSTRAINT settings_group_parent_id_fkey FOREIGN KEY (parent_id) REFERENCES public.settings_group(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

