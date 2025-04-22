package com.sist.vo;
import java.util.*;

import lombok.Data;

@Data
public class ReserveVO {
	private int rno,isreserve,fno;
	private String userid,rday,rtime,rinwon,dbday;
	private Date regdate;
	private FoodVO fvo=new FoodVO();
	private MemberVO mvo=new MemberVO();
}
