package com.article.demo.jpa.domain.tag.controller;

import com.article.demo.jpa.domain.tag.controller.TagController;
import com.article.demo.jpa.domain.tag.dto.TagDTO;
import com.article.demo.jpa.domain.tag.model.Tag;
import com.article.demo.jpa.domain.tag.service.TagService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

@WebMvcTest(TagController.class)
public class TagControllerTest {

  @MockBean
  private TagService tagService;
  @Autowired
  private ObjectMapper mapper;
  @Autowired
  private MockMvc mockMvc;

  @Test
  public void it_should_return_created_tag() throws Exception {
    Tag tag = new Tag();
    tag.setName("New Tag");
    TagDTO tagDTO = new TagDTO(1, "New Tag");

    when(tagService.save(tag)).thenReturn(tagDTO);

    mockMvc.perform(post("/api/jpa/tag").contentType("application/json").content(mapper.writeValueAsString(tagDTO)))
        .andExpect(status().isOk());
  }

}