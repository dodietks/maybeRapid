package com.example.MaybeRapid.domain;

import javax.persistence.GeneratedValue;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class BaseModel {

  @Id
  @GeneratedValue
  private long id;
  private Boolean active;
}
