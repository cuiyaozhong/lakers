package com.microservice.cyz.dto;

import lombok.Data;

/**
 * @author 崔耀中
 * @since 2020-12-23
 */
@Data
public class TreeNodeDTO {

    private int data;

    private TreeNodeDTO leftChild;

    private TreeNodeDTO rightChild;

    public TreeNodeDTO(int data) {
        this.data = data;
    }
}
