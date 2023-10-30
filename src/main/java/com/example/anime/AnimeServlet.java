package com.example.anime;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AnimeServlet", urlPatterns = {"/animes"})
public class AnimeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("iniciando servidor...");
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        List<Anime> animeList = Main.readListAnime("/Users/ericanunes/downloads/anime_list2.csv");
        String animeMaisBarato = Main.AnimeBarato(animeList);

        out.println("Animes Listados:");
        for (Anime anime : animeList) {
            out.println(anime);
            out.println("Valor total: " + anime.calculoPrice());
        }
        out.println("O anime mais barato da lista é:" + animeMaisBarato);

        out.close();
        System.out.println("final servlet...");
    }

    }

