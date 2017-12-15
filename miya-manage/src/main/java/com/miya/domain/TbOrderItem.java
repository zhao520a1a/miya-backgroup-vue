package com.miya.domain;


import com.springboot.ping.mybatis.annotation.Pk;
import com.springboot.ping.mybatis.annotation.Table;
import com.springboot.ping.mybatis.extend.entity.BaseModel;
import lombok.*;

/*订单-商品信息详情*/
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Table("tb_order_item")
public class TbOrderItem extends BaseModel {
    @Pk
    private String id;

    private String itemId;

    private String orderId;

    private Integer num;

    private String title;

    private Long price;

    private Long totalFee;

    private String picPath;


    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }


    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }


    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }


    public void setPicPath(String picPath) {
        this.picPath = picPath == null ? null : picPath.trim();
    }
}