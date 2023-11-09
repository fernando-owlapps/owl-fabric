package com.owlapps.samarony.model;

import org.springframework.data.annotation.Id;

public class DatabaseImageSequence {
	
	@Id
    private String id;
 
    private long seq;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}

	@Override
	public String toString() {
		return "databaseImageSequence [id=" + id + ", seq=" + seq + "]";
	}
    
}