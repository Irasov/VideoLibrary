package com.epam.irasov.videolibrary;

import com.epam.irasov.videolibrary.dao.DaoFactory;
import com.epam.irasov.videolibrary.dao.MovieDao;
import com.epam.irasov.videolibrary.entity.Movie;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

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
        if(requestBd.equals("find by id")) {
            String id = request.getParameter("id");
            movie = movieDao.findById(Long.parseLong(id)/*1L*/);
            session = request.getSession();
            session.setAttribute("movie", movie);
        }
        daoFactory.endTx();
        daoFactory.close();
        RequestDispatcher dispatcher  = request.getRequestDispatcher("/result.jsp");
        dispatcher.forward(request,response);
    }
}
