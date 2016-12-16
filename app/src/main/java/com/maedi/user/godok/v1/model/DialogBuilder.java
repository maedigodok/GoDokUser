package com.maedi.user.godok.v1.model;

public class DialogBuilder {
	
	private String title;
	private String message;
	public int icon;
	
	public DialogBuilder(String title, int icon, String message){
		this.setTitle(title);
		this.setIcon(icon);
		this.setMessage(message);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getIcon(){
		return icon;
	}
	
	public void setIcon(int icon){
		this.icon = icon;
	}

}
