package com.miya.domain;

import com.springboot.ping.mybatis.annotation.Pk;
import com.springboot.ping.mybatis.annotation.Table;
import com.springboot.ping.mybatis.extend.entity.BaseTimeModel;
import lombok.*;


@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Table("tb_item_param_item")
public class TbItemParamItem extends BaseTimeModel {
    @Pk
    private Long id;

    private Long itemId;

    private String paramData;

    public void setParamData(String paramData) {
        this.paramData = paramData == null ? null : paramData.trim();
    }
}