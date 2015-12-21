Feature: Page Scrape

  Scenario: Scrape data from listing page
    Given a page is loaded
    When the page is parsed
    Then there are 7 result pages returned with a total value of 15.10
    And the following data is parsed from the pages
      | index | title                                                   | description | unit price | size    |
      | 0     | Sainsbury's Apricot Ripe & Ready x5                     | Apricots    | 3.50       | 34.92kb |
      | 1     | Sainsbury's Avocado Ripe & Ready XL Loose 300g          | Avocados    | 1.50       | 35.51kb |
      | 2     | Sainsbury's Avocado, Ripe & Ready x2                    | Avocados    | 1.80       | 39.5kb  |
      | 3     | Sainsbury's Avocados, Ripe & Ready x4                   | Avocados    | 3.20       | 35.54kb |
      | 4     | Sainsbury's Conference Pears, Ripe & Ready x4 (minimum) | Conference  | 1.50       | 35.21kb |
      | 5     | Sainsbury's Golden Kiwi x4                              | Gold Kiwi   | 1.80       | 35.3kb  |
      | 6     | Sainsbury's Kiwi Fruit, Ripe & Ready x4                 | Kiwi        | 1.80       | 36.08kb |