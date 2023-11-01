package com.example.anime;
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