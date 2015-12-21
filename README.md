# Web Scraper

This project is an attempt to solve a programming problem that requires data to be
scrape from the following web pages:

http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html

http://www.sainsburys.co.uk/webapp/wcs/stores/servlet/CategoryDisplay?listView=true&orderBy=FAVOURITES_FIRST&parent_category_rn=12518&top_category=12518&langId=44&beginIndex=0&pageSize=20&catalogId=10137&searchTerm=&categoryId=185749&listId=&storeId=10151&promotionId=#langId=44&storeId=10151&catalogId=10137&categoryId=185749&parent_category_rn=12518&top_category=12518&pageSize=20&orderBy=FAVOURITES_FIRST&searchTerm=&beginIndex=0&hideFilters=true

The data should be returned in the form of a JSON array of all the products listed
on the page. The data should contain the size (in kb) of the linked HTML for each product
(no assets) and the description to display in the JSON.

Each element in the JSON results array should contain ‘title’, ‘unit_price’, ‘size’ and ‘description’ keys corresponding
to items in the table. Additionally, there should be a total field which is a sum of all unit prices on the page.

## Running the application and tests

The project is built with gradle and assumes the use of Java 8. As long as your JAVA_HOME variable is pointing to
a Java 8 JDK you should be able to build the application. You can execute the code by running the
following commands:

```
gradlew clean build                     //runs all unit tests
gradlew clean build cucumber            //runs all unit tests followed by integration tests
gradlew clean build run                 //runs the application
```

The integration tests are required because it was not possible to create reliably running unit tests
based around connecting to a web page that exists on the web and is not under my control. It should also
be noted that the integration tests will fail if any of the pages referenced are modified. The integration tests
process both a dynamically loaded and statically loaded listing page found at the following urls respectively:

static: http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html

dynamic: http://www.sainsburys.co.uk/webapp/wcs/stores/servlet/CategoryDisplay?listView=true&orderBy=FAVOURITES_FIRST&parent_category_rn=12518&top_category=12518&langId=44&beginIndex=0&pageSize=20&catalogId=10137&searchTerm=&categoryId=185749&listId=&storeId=10151&promotionId=#langId=44&storeId=10151&catalogId=10137&categoryId=185749&parent_category_rn=12518&top_category=12518&pageSize=20&orderBy=FAVOURITES_FIRST&searchTerm=&beginIndex=0&hideFilters=true

The application has only been tested on mac and windows and a linux mint distro and has worked without issues. If you
encounter issues running the code, please feel free to let me know.