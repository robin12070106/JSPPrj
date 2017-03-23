package com.sjcorp.web.entity;

import com.sjcorp.web.entity.Notice;

public class NoticeView extends Notice{
	
	String writerName;
	int commentCount;
	
	
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	
}
