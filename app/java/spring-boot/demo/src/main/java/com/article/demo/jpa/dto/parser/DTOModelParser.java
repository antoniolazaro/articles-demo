package com.article.demo.jpa.dto.parser;

import java.util.ArrayList;
import java.util.List;

public interface DTOModelParser<K extends DTOInterface, V extends ModelInterface> {

  K convertModelToDTO(V item);

  V convertDTOToModel(K item);

  default List<K> convertListModelToListDTO(List<V> itens) {
    List<K> itensDTO = new ArrayList<>();
    itens.forEach(item -> itensDTO.add(convertModelToDTO(item)));
    return itensDTO;
  }

  default List<V> convertListDTOToListModel(List<K> itens) {
    List<V> itensModel = new ArrayList<>();
    itens.forEach(item -> itensModel.add(convertDTOToModel(item)));
    return itensModel;
  }
}