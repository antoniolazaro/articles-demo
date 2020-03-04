CREATE TABLE "user" (
   "login" varchar(50) NOT NULL,
   "name" varchar(200) NOT NULL,
   "password" varchar(20) NOT NULL,
   "email" varchar(100) NOT NULL,
   "celphone" varchar(20) NULL,
   created_at timestamp DEFAULT now(),
   last_update_at timestamp DEFAULT now(),
   last_access_at timestamp DEFAULT now(),
   last_publication_at timestamp DEFAULT now(),
   PRIMARY KEY (LOGIN)
);

CREATE TABLE "tag" (
   "id" serial NOT NULL,
   "name" varchar(30) NOT NULL,
   "description" varchar(100) NULL,
   created_at timestamp DEFAULT now(),
   PRIMARY KEY (id),
   UNIQUE ("name")
);

CREATE INDEX idx_tag_name ON tag (name ASC);

CREATE TABLE "article" (
   "id" serial NOT NULL,
   "title" varchar(200) NOT NULL,
   "short_description" varchar(100) NULL,
   "content" text NOT NULL,
   user_login varchar(50),
   created_at timestamp DEFAULT now(),
   last_update_at timestamp DEFAULT now(),
   last_view_at timestamp DEFAULT now(),
   time_reading_average decimal NOT NULL,
   PRIMARY KEY (id),
   CONSTRAINT fk_article_user FOREIGN KEY (user_login) REFERENCES "user" (LOGIN) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO action,
   UNIQUE (title, user_login)
);

CREATE INDEX idx_article_title ON article (title ASC);

CREATE TABLE "comment" (
   "id" serial NOT NULL,
   user_login varchar(50) NOT NULL,
   article_id integer NOT NULL,
   comment_origin integer NULL,
   content text NOT NULL,
   created_at timestamp DEFAULT now(),
   PRIMARY KEY (id),
   CONSTRAINT fk_comment_user FOREIGN KEY (user_login) REFERENCES "user" (LOGIN) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO action,
   CONSTRAINT fk_comment_article FOREIGN KEY (article_id) REFERENCES article (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT fk_comment_comment FOREIGN KEY (comment_origin) REFERENCES "comment" (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE "article_tag" (
   article_id integer NOT NULL,
   tag_id integer NOT NULL,
   PRIMARY KEY (article_id, tag_id),
   CONSTRAINT fk_article_tag_a FOREIGN KEY (article_id) REFERENCES article (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO action,
   CONSTRAINT fk_article_tag_t FOREIGN KEY (tag_id) REFERENCES tag (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO action
);

CREATE TABLE "followers" (
   user_login varchar(50) NOT NULL,
   user_login_follower varchar(50) NOT NULL,
   created_at timestamp DEFAULT now(),
   PRIMARY KEY (user_login, user_login_follower),
   CONSTRAINT fk_followers_user FOREIGN KEY (user_login) REFERENCES "user" (LOGIN) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO action,
   CONSTRAINT fk_followers_user_follower FOREIGN KEY (user_login_follower) REFERENCES "user" (LOGIN) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO action
);

