package com.miya.dto;

import lombok.*;

/**
 * @author 赵金鑫
 * @date 2017年10月24日
 */
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RespUser {
    private String username;

    private String phone;

    private String email;

    private String create_time;

    private String update_time;
}
