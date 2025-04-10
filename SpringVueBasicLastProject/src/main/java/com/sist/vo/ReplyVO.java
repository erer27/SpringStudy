package com.sist.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private int no,bno,group_id,goupsteps,group_tab,root,depth;
	private String id,name,msg,dbday;
	private Date regdate;
}
