package com.example.MaybeRapid.domain;

import lombok.Data;

@Data
public class Visitor extends BaseModel {

  private String name;
  private String surname;
  private Number document;
  private String unity;
}
