# MLA Citation Machine

This project provides a small command line program that generates a basic MLA style citation for a web page.

## Usage

Run the application and provide a URL through standard input. The program will download the page, attempt to detect author, title, website name and publication date from common HTML meta tags, and print a citation string.

```
$ echo "https://example.com" | ./gradlew run
```

The output will resemble:

```
Author Name. "Article Title." Website Name, 2024-03-14, https://example.com
```

The extraction heuristics are simple and may not work for every site but should handle many common news pages.
