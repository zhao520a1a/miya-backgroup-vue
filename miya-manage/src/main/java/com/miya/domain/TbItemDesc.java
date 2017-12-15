package com.miya.domain;

import com.springboot.ping.mybatis.annotation.Pk;
import com.springboot.ping.mybatis.annotation.Table;
import com.springboot.ping.mybatis.extend.entity.BaseTimeModel;
import lombok.*;

/* 商品描述信息 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Table("tb_item_desc")
public class TbItemDesc extends BaseTimeModel {
    @Pk
    private Long itemId;

    private String itemDesc;


    //注意：用builder建立对象时不起作用
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc == null ? null : itemDesc.trim();
    }

    public static void main(String[] args) {
        TbItemDesc o = TbItemDesc.builder().itemId(123L).itemDesc("   fsd sdadf    ").build();
        String i = o.getItemDesc();
        TbItemDesc  j = new TbItemDesc();
        j.setItemDesc("   fsd sdadf    ");
        System.out.println(i);
        System.out.println(new String("   fsd sdadf    ").trim());
        System.out.println(j.getItemDesc());
        System.out.println(o.toString());
    }
}