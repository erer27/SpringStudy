package com.sist.vo;

import lombok.Data;

@Data
public class GoodVO {
   private int no,hit,goods_discount,price,replycount,likecount;
   private String goods_name,goods_sub,goods_price,
           goods_first_price,goods_delivery,goods_poster;
}
