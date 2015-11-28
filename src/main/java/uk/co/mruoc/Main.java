package uk.co.mruoc;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Main {

    private static final String URL = "http://www.sainsburys.co.uk/webapp/wcs/stores/servlet/CategoryDisplay" +
            "?listView=true&orderBy=FAVOURITES_FIRST&parent_category_rn=12518&top_category=12518&" +
            "langId=44&beginIndex=0&pageSize=20&catalogId=10137&searchTerm=&categoryId=185749&listId=&storeId=10151&" +
            "promotionId=#langId=44&storeId=10151&catalogId=10137&categoryId=185749&parent_category_rn=12518&" +
            "top_category=12518&pageSize=20&orderBy=FAVOURITES_FIRST&searchTerm=&beginIndex=0&hideFilters=true";

    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect(URL).get();
        System.out.println(document.toString());
    }

}
