package com.pawan.thNov;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class WatchlistItem {
	
	@NotBlank(message ="Please enter the title")
	private String Title;
	private String Rating;
	private String Priority;
	
	@Size(max=50, message ="Comment should be maximum of 50 characters")
	private String Comment;
	private Integer ID;
	
	public WatchlistItem(String title, String rating, String priority, String comment, Integer iD) {
		super();
		Title = title;
		Rating = rating;
		Priority = priority;
		Comment = comment;
		ID = iD;
	}

	

	public WatchlistItem() {
		
	}



	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getRating() {
		return Rating;
	}

	public void setRating(String rating) {
		Rating = rating;
	}

	public String getPriority() {
		return Priority;
	}

	public void setPriority(String priority) {
		Priority = priority;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}
	
	

}
