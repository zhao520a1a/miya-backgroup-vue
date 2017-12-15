package com.miya.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author 赵金鑫
 * @date 2017年11月07日
 */
@Data
@Builder
public class AdminInfo {
    private String user_name;
    private String create_time;
    private String admin;
    private int id;
    private String avatar;
}
