package com.example.anime;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Anime {
    private String title;
    private double score;
    private String ranking;
    private String genres;
    private double price;
    private double desconto;
    public Anime(String title, double score, String ranking, String genres, double price, double desconto) {
        this.title = title;
        this.score = score;
        this.ranking = ranking;
        this.genres = genres;
        this.price = price;
        this.desconto = desconto;
    }

    public String getTitle() {
        return title;
    }

    public double getScore() {
        return score;
    }

    public String getRanking(){
        return ranking;
    }

    public String getGenres(){
        return genres;
    }

    public double getPrice(){
        return price;
    }

    public double calculoPrice(){
        return price;
    }


    @Override
    public String toString() {
        return "Anime_list{" +
                "title='" + title + '\'' +
                ", score=" + score +
                ", ranking=" + ranking + '\'' +
                ", genres=" + genres + '\'' +
                ", price=" + price + '\'' +
                '}';
    }
}

class PriceAnimeDesconto extends Anime {
    private double desconto;

    public PriceAnimeDesconto(String title, double score, String ranking, String genres, double price, double desconto){
        super(title, score, ranking, genres, price, desconto);
        this.desconto = desconto;
    }

    public double animeDesconto(){
        return desconto;
    }

    @Override
    public double calculoPrice(){
        return super.calculoPrice() - desconto;
    }

    @Override
    public String toString(){
        return "Anime_listComDesconto{" +
                "title='" + getTitle() + '\'' +
                ", score=" + getScore() +
                ", ranking=" + getRanking() + '\'' +
                ", genres=" + getGenres() + '\'' +
                ", price=" + getPrice() + '\'' +
                ", desconto=" + desconto + '\'' +
                '}';
    }
}




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