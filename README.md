# Web Scraper

[![Build Status](https://travis-ci.org/michaelruocco/web-scraper.svg?branch=master)](https://travis-ci.org/michaelruocco/web-scraper)
[![Coverage Status](https://coveralls.io/repos/michaelruocco/web-scraper/badge.svg?branch=master&service=github)](https://coveralls.io/github/michaelruocco/web-scraper?branch=master)
[![Dependency Status](https://www.versioneye.com/user/projects/5678902d107997003e0011d8/badge.svg?style=flat)](https://www.versioneye.com/user/projects/5678902d107997003e0011d8)

This project is an attempt to solve a programming problem that requires data to be
scraped from the following web page:

http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html

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
gradlew clean build cucumber            //runs all unit tests followed by integration test
gradlew clean build run                 //runs the application
```

The integration test are required because it was not possible to create reliably running unit tests
based around connecting to a web page that exists on the web and is not under my control. It should also
be noted that the integration test will fail if any of the pages referenced are modified. The integration test
processes a statically loaded listing page found at the following url:

static: http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html

The application has only been tested on mac and windows and a linux mint distro and has worked without issues. If you
encounter issues running the code, please feel free to let me know.