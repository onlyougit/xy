package com.sptwin.xy.dto;

import lombok.Data;

import java.util.List;

@Data
public class LeftMenuResponseDTO {
    private Integer id;

    private String permissionName;

    private Integer parentId;

    private String permission;

    private String type;

    private String url;

    private List<LeftMenuResponseDTO> list;
}
