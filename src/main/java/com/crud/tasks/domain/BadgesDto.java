package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BadgesDto {
	
	@JsonProperty("votes")
	private int votes;
	
	@JsonProperty("attachmentsByType")
	private AttachmentsByType attachments;
	
	public BadgesDto(){
	
	}
	
	public BadgesDto(int votes, AttachmentsByType attachments) {
		
		this.votes = votes;
		this.attachments = attachments;
	}
	
	public int getVotes() {
		return votes;
	}
	
	public AttachmentsByType getAttachments() {
		return attachments;
	}
}
