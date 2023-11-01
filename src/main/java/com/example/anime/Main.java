package com.example.anime;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String path1 = "/Users/ericanunes/downloads/anime_list2.csv";

        List<Anime> anime = readListAnime(path1);

        String animeMaisBarato = AnimeBarato(anime);

        System.out.println("ANIMES LISTADOS :");
        anime.forEach(a -> {
            System.out.println(a);
            System.out.println("valor total: " + a.calculoPrice());
        });
    }

    public static String AnimeBarato(List<Anime> anime) {
        String animeMaisBarato = anime.stream().min(Comparator.comparing(x -> x.getPrice())).get().getTitle();
        System.out.println("O anime mais barato da lista hoje é:" + animeMaisBarato);
        return animeMaisBarato;
    }


    public static List<Anime> readListAnime(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.lines()
                    .skip(1) //
                    .filter(line -> !line.isEmpty())
                    .map(line -> {
                        String[] parte = line.split(",");
                        String title = parte[0];
                        double score = Double.parseDouble(parte[1]);
                        String ranking = parte[2];
                        String genres = parte[3];
                        double price = Double.parseDouble(parte[4]);
                        double desconto = Double.parseDouble(parte[5].trim());
                        return new PriceAnimeDesconto(title, score, ranking, genres, price, desconto);
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}