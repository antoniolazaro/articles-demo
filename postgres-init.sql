CREATE TABLE "user"
(
  "login" varchar(50) NOT NULL,
  "name" varchar(200) not null,
  "password" varchar(20) not null,
  "email" varchar(100) not null,
  "celphone" varchar(20) null,
  created_at timestamp default now(),
  last_update_at timestamp default now(),
  last_access_at timestamp default now(),
  last_publication_at timestamp null,
  PRIMARY KEY (login)
);


CREATE TABLE "tag"
(
  "id" serial NOT NULL,
  "name" varchar(30) not null,
  "description" varchar(100) null,
  created_at timestamp default now(),
  PRIMARY KEY (id),
  unique("name")
);

CREATE INDEX idx_tag_name  ON tag (name ASC);

CREATE TABLE "article"
(
  "id" serial NOT NULL,
  "title" varchar(200) not null,
  "short_description" varchar(100) null,
  "content" text not null,
  user_login varchar(50),
   created_at timestamp default now(),
   last_update_at timestamp default now(),
   last_view_at timestamp default now(),
   time_reading_average decimal not null,
  PRIMARY KEY (id),
  CONSTRAINT fk_article_user FOREIGN KEY (user_login)
      REFERENCES "user" (login) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO action,
    unique(title,user_login));
   
CREATE INDEX idx_article_title  ON article (title ASC);
      
 CREATE TABLE "comment"
(
  "id" serial NOT NULL,
   user_login varchar(50) not null,
   article_id integer not null,
   comment_origin integer null,
   content text not null,
   created_at timestamp default now(),   
  PRIMARY KEY (id),
  CONSTRAINT fk_comment_user FOREIGN KEY (user_login)
      REFERENCES "user" (login) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO action,
      CONSTRAINT fk_comment_article FOREIGN KEY (article_id)
      REFERENCES article (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT fk_comment_comment FOREIGN KEY (comment_origin)
      REFERENCES "comment" (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION); 
      
   CREATE TABLE "article_tag"
(
   article_id integer not null,
   tag_id integer not null,
  PRIMARY KEY (article_id,tag_id),
  CONSTRAINT fk_article_tag_a FOREIGN KEY (article_id)
      REFERENCES article (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO action,
  CONSTRAINT fk_article_tag_t FOREIGN KEY (tag_id)
      REFERENCES tag (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO action);
    
    CREATE TABLE "followers"
(
   user_login varchar(50) not null,
   user_login_follower varchar(50) not null,
   created_at timestamp default now(),
  PRIMARY KEY (user_login,user_login_follower),
   CONSTRAINT fk_followers_user FOREIGN KEY (user_login)
      REFERENCES "user" (login) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO action,
   CONSTRAINT fk_followers_user_follower FOREIGN KEY (user_login_follower)
      REFERENCES "user" (login) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO action); 
