package assignment3;

import java.util.Date;

public class Media {
	private String name;
	private String genre;
	private String type;
	private double criticScore;
	private Date releaseDate;
	
	public Media() {
		this.name = "<blank>";
		this.genre = "<blank>";
		this.type = "<blank>";
		this.criticScore = -1;
	}
	
	public Media(String name, String genre, String type, double criticScore, Date releaseDate) {
		this.name = name;
		this.genre = genre;
		this.type = type;
		this.criticScore = criticScore;
		this.releaseDate = releaseDate;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getCriticScore() {
		return criticScore;
	}

	public void setCriticScore(double criticScore) {
		this.criticScore = criticScore;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	

}
