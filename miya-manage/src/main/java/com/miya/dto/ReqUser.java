package com.miya.dto;

import lombok.*;

/**
 * @author 赵金鑫
 * @date 2017年10月24日
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReqUser {
    @NonNull
    private String user_name;
    @NonNull
    private String password;
}
