package ua.lviv.cinema.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.Movie;
import ua.lviv.cinema.entity.Moviehall;
import ua.lviv.cinema.entity.Schedule;
import ua.lviv.cinema.entity.Seance;

public interface SeanceService {
	void save(Seance seance);

	Seance findOne(Integer id);
	
	List<Seance> findAll();

	void delete(Seance seance);

	void update(Seance seance);
	
	List<Seance> allSeancesOfMoviehall(Moviehall moviehall);

	List<Seance> allSeancesOfMovie(Cinema cinema, Movie movie);

	List<Seance> allSeancesOfDay(Cinema cinema,LocalDate date);
	
	Seance findByMoviehallAndTime(Moviehall moviehall, LocalDateTime startTime);

//	void saveSeancesOverPeriod(Movie movie, LocalDateTime startTime, LocalDateTime endTime, Schedule schedule,
//			int price);

	void saveAllSeances(Movie movie, List<LocalDateTime> times, Schedule schedule, int price);
	
	void deleteAllSeances(Movie movie, List<LocalDateTime> times, Moviehall moviehall);
	
	void deleteAllSeances(List<Seance> seances);
	
	Seance findByIdWithSeats(Integer id);

}
