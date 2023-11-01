package com.example.anime;
public class PriceAnimeDesconto extends Anime {
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