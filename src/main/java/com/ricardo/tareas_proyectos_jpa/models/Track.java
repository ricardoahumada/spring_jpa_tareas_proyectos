package com.ricardo.tareas_proyectos_jpa.models;

import com.ricardo.tareas_proyectos_jpa.constraints.SerialNumber;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Track {

	@NotNull
	@Size(min=3, max=20, message="Title must be btwn 3 and 20")
	@SerialNumber
	String title;
	
	@NotNull
	@Size(min=3, max=20, message="Singer  must be btwn 3 and 20")
	String singer;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	@Override
	public String toString() {
		return "Track [title=" + title + ", singer=" + singer + "]";
	}

}
