# CineRegister22

This repository contains a student project created for an ongoing lecture on object-oriented programming with Java at HWR Berlin (summer term 2022).

> :warning: This code is for educational purpose only. Do not rely on it!

## Abstract

With the CineRegister22 you can book or reserve tickets at a cinema.

### Most Important Features

1. The program imports all Movies and Shows from a movielist.txt file. The file is built like a CSV.
2. The program imports and builds digital halls for every show out of the folder "halls".
3. The program saves booked or reserved seats into the corresponding hall. (Only during runtime).


4. All movies and corresponding shows can be printed to the console.
5. Halls can be printed to the console.
6. A receipt can be printed to the console.
7. A receipt can be saved to the users download-folder.


8. The User can choose the movie (independent of upper or lower case).
9. The User can choose a day and time (show).
10. The User can book as many seats as wanted, as long as there are enough seats.

### Most Interesting Problems During Development

In our opinion, the most interesting problems we encountered are importing data from given
files and parsing them, building the Halls or Movies and converting a two-dimensional arrayList
into a printable table (string) with empty slots.



## Feature List

| Number | Feature         | Tests                         |
|--------|-----------------|-------------------------------|
| 1      | MovieCollection | MovieCollectionTest (3 Tests) |
| 2      | MovieBuilder    | MovieBuilderTest (1 Test)     |
| 3      | Movie           | MovieTest (11 Tests)          |
| 4      | ShowBuilder     | ShowBuilderTest (1 Test)      |
| 5      | Show            | ShowTest (4 Tests)            |
| 6      | Hall            | HallTest (9 Tests)            |
| 7      | Seat            | SeatTest (15 Tests)           |
| 8      | Receipt         | ReceiptTest (9 Tests)         |
| 9      | Main            | MainTest (4 Tests)            |


## Additional Dependencies


| Number | Dependency Name | Dependency Description                                                       | Why is it necessary?                                             |
|--------|-----------------|------------------------------------------------------------------------------|------------------------------------------------------------------|
| 1      | java.util.*     | https://docs.oracle.com/javase/8/docs/api/java/util/package-summary.html     | Usage of ArrayLists and Scanners to import Movie- and Hall-Data. |
| 2      | java.junit.*    | creating unit tests                                                          | Implementing of automated tests.                                 |
| 3      | java.io.*       | https://docs.oracle.com/javase/7/docs/api/java/io/package-summary.html       | Importing of files.                                              |
| 4      | java.nio.file.* | https://docs.oracle.com/javase/8/docs/api/java/nio/file/package-summary.html | Saving of receipt to dowloads-folder.                            |

## Instructions


You can start CineRegister22 by starting the manual test in "MainTest". The started Programm will guide you.

> :note: You need to activate inputs to the test console.
 
1. In IntelliJ: Help > Edit Custom VM Options
2. Add the following to the opened "ideav64.vmoptions" file:
 
````
-Deditable.java.test.console=true
````


