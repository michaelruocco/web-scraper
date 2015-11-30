# Web Scraper

This project is an attempt to solve a programming problem that requires data to be
scrape from the following web page:

http://www.sainsburys.co.uk/webapp/wcs/stores/servlet/CategoryDisplay?listView=true&orderBy=FAVOURITES_FIRST&parent_category_rn=12518&top_category=12518&langId=44&beginIndex=0&pageSize=20&catalogId=10137&searchTerm=&categoryId=185749&listId=&storeId=10151&promotionId=#langId=44&storeId=10151&catalogId=10137&categoryId=185749&parent_category_rn=12518&top_category=12518&pageSize=20&orderBy=FAVOURITES_FIRST&searchTerm=&beginIndex=0&hideFilters=true

The data should be returned in the form of a JSON array of all the products listed
on the page. The data should contain the size (in kb) of the linked HTML for each product
(no assets) and the description to display in the JSON.

Each element in the JSON results array should contain ‘title’, ‘unit_price’, ‘size’ and ‘description’ keys corresponding
to items in the table. Additionally, there should be a total field which is a sum of all unit prices on the page.

## Running the application and tests

The project is built with gradle and assumes the use of Java 8. As long as your JAVA_HOME variable is pointing to
a Java 8 JDK you should be able to build the application, run all tests and execute the application by running:

```
./gradlew clean build run
```

If you are on windows you can omit the './'

This application has only been tested on mac and windows, to run on unix you will need to add
the linux selenium driver and reconfigure the Driver Service Factory use the appropriate driver if
running on linux.