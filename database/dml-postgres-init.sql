INSERT INTO public."user" (login, "name", "password", email, celphone) VALUES('antoniolazaro', 'Antonio Lazaro', '123456','antonio.lazaro@teste.com', '5571988765432');
INSERT INTO public."user" (login, "name", "password", email, celphone) VALUES('teste', 'Teste Santos', 'teste','teste@teste.com', '5571988765678');
INSERT INTO public.tag ("name", description) VALUES('Java','Agrupar itens que falem sobre Java');
INSERT INTO public.tag ("name", description) VALUES('Python','Agrupar itens que falem sobre Python');
INSERT INTO public.tag ("name", description) VALUES('SQL','Agrupar itens que falem sobre SQL');
INSERT INTO public.article (title, short_description, "content", user_login, time_reading_average) VALUES('Teste Java', 'Artigo falando sobre testes', 'Esse artigo visa explicar', 'antoniolazaro',1.0);
INSERT INTO public.article (title, short_description, "content", user_login, time_reading_average) VALUES('Teste Geral', 'Artigo falando sobre testes geral', 'Esse artigo visa explicar', 'antoniolazaro',2.0);
INSERT INTO public.article (title, short_description, "content", user_login, time_reading_average) VALUES('Teste Geral 2', 'Artigo falando sobre testes geral', 'Esse artigo visa explicar', 'teste',2.0);


INSERT INTO public.article_tag (article_id, tag_id) VALUES(1,1);
INSERT INTO public.article_tag (article_id, tag_id) VALUES(1,2);
INSERT INTO public.article_tag (article_id, tag_id) VALUES(2,3);
INSERT INTO public.article_tag (article_id, tag_id) VALUES(3,1);
INSERT INTO public.article_tag (article_id, tag_id) VALUES(3,2);
INSERT INTO public.article_tag (article_id, tag_id) VALUES(3,3);

INSERT INTO public."comment" (user_login, article_id,"content") VALUES('teste',1,'Comentário 1');
INSERT INTO public."comment" (user_login, article_id,comment_origin,"content") VALUES('teste',1,1,'Comentário 2');
INSERT INTO public."comment" (user_login, article_id,"content") VALUES('antoniolazaro',3,'Comentário 3');


INSERT INTO public.followers (user_login, user_login_follower) VALUES('teste', 'antoniolazaro');

