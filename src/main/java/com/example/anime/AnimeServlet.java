package com.example.anime;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AnimeServlet", urlPatterns = {"/animes"})
public class AnimeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Anime> animeList = Main.readListAnime("/Users/ericanunes/downloads/anime_list2.csv");
        String animeMaisBarato = Main.AnimeBarato(animeList);

        request.setAttribute("animeList", animeList);
        request.setAttribute("animeMaisBarato", animeMaisBarato);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
    }

