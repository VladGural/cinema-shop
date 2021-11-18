package demo.spring.dao.impl;

import demo.spring.dao.AbstractDao;
import demo.spring.dao.MovieDao;
import demo.spring.model.Movie;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDaoImpl extends AbstractDao<Movie> implements MovieDao {
    public MovieDaoImpl(SessionFactory factory) {
        super(factory, Movie.class);
    }
}
