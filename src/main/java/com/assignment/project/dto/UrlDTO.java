package com.assignment.project.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UrlDTO {

    @NotEmpty
    public String url;

}
