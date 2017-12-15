package com.miya.domain;

import com.springboot.ping.mybatis.annotation.Pk;
import com.springboot.ping.mybatis.annotation.Table;
import com.springboot.ping.mybatis.extend.entity.BaseTimeModel;
import lombok.*;


/* 商品参数信息 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Table("tb_item_param")
public class TbItemParam extends BaseTimeModel {
    @Pk
    private Long id;

    private Long itemCatId;

    private String paramData;

    public void setParamData(String paramData) {
        this.paramData = paramData == null ? null : paramData.trim();
    }
}