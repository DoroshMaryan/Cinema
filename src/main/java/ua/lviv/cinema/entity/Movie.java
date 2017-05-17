package ua.lviv.cinema.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Movie implements Comparable<Movie> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String title;
	private int minutes;

	// Enum
	private String country;

	private LocalDate releaseDateFrom;
	private LocalDate releaseDateTo;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "cinema_movie",
	joinColumns = @JoinColumn(name = "movie_id"),
	inverseJoinColumns = @JoinColumn(name = "cinema_id"))
	private List<Cinema> cinemas = new ArrayList<>();

	public Movie() {
	}

	public Movie(String title, int minutes, LocalDate releaseDateFrom) {
		this.title = title;
		this.minutes = minutes;
		//this.cinemas = cinema;
		this.releaseDateFrom = releaseDateFrom;
	}

	public Movie(String title, int minutes, String country, LocalDate releaseDateFrom, LocalDate releaseDateTo) {
		super();
		this.title = title;
		this.minutes = minutes;
		this.country = country;
		this.releaseDateFrom = releaseDateFrom;
		this.releaseDateTo = releaseDateTo;
		//this.cinema = cinema;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LocalDate getReleaseDateFrom() {
		return releaseDateFrom;
	}

	public void setReleaseDateFrom(LocalDate releaseDateFrom) {
		this.releaseDateFrom = releaseDateFrom;
	}

	public LocalDate getReleaseDateTo() {
		return releaseDateTo;
	}

	public void setReleaseDateTo(LocalDate releaseDateTo) {
		this.releaseDateTo = releaseDateTo;
	}
	
	public List<Cinema> getCinemas() {
		return cinemas;
	}
	
	public void setCinemas(List<Cinema> cinemas) {
		this.cinemas = cinemas;
	}

	@Override
	public int compareTo(Movie o) {
		return this.getReleaseDateFrom().compareTo(o.getReleaseDateFrom());
	}
	
	public void addCinema(Cinema cinema) {
		this.cinemas.add(cinema);
		cinema.getMovies().add(this);
	}

	
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", minutes=" + minutes + ", country=" + country
				+ ", releaseDateFrom=" + releaseDateFrom +  "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (id != other.id)
			return false;
		return true;
	}

}