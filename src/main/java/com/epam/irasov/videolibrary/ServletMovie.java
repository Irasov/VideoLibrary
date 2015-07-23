package com.epam.irasov.videolibrary;

import com.epam.irasov.videolibrary.dao.DaoFactory;
import com.epam.irasov.videolibrary.dao.MovieDao;
import com.epam.irasov.videolibrary.entity.Movie;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static java.time.format.DateTimeFormatter.ofPattern;

@javax.servlet.annotation.WebServlet(name = "ServletMovie")
public class ServletMovie extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String requestBd = request.getParameter("request");
        DaoFactory daoFactory = DaoFactory.getInstance();
        daoFactory.beginTx();
        MovieDao movieDao = daoFactory.newMovieDao();
        HttpSession session;
        Movie movie;
        switch (requestBd) {
            case "find by id": {
                String id = request.getParameter("id");
                movie = movieDao.findById(Long.parseLong(id));
                session = request.getSession();
                session.setAttribute("movie", movie);
                daoFactory.endTx();
                daoFactory.close();
                RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
                dispatcher.forward(request, response);
                break;
            }
            case "remove": {
                LocalDate release = LocalDate.parse(request.getParameter("date"), ofPattern("yyyy-MM-dd"));
                movieDao.removeByDate(release);
                session = request.getSession();
                session.setAttribute("release", release);
                daoFactory.endTx();
                daoFactory.close();
                RequestDispatcher dispatcher = request.getRequestDispatcher("/remove.jsp");
                dispatcher.forward(request, response);
                break;
            }
            case "count": {
                int count = Integer.parseInt(request.getParameter("count"));
                List<Movie.Member> members = movieDao.selectMember(count);
                session = request.getSession();
                session.setAttribute("members", members);
                daoFactory.endTx();
                daoFactory.close();
                RequestDispatcher dispatcher = request.getRequestDispatcher("/find-by-count-movie.jsp");
                dispatcher.forward(request, response);
                break;
            }
        }
    }
}
