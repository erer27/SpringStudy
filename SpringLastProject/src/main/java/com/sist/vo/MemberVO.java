package com.sist.vo;

import java.util.*;

import lombok.Data;
// spring security
// => userid : username
// role => ROLE_ADMIN / ROLE_USER / ROLE_MANAGER ...
@Data
public class MemberVO {
	private int enable;// 활성화(1) , 휴먼계정
	private String userid,userpwd,username,sex,birthday,email,post,addr1,addr2,phone,content,msg,authority;
	private Date regdate,modifydate,lastlogin;
	
}
