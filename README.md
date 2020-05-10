# San Jose State University

## Course: CMPE172/Spring 2020

### Team Members
Antoine Ngu

Johnny Phenglavong

Thomas Wang

# Project Introduction
This is a simple photo gallery utilzing enterprise tools and software to help with deployment and future scalability in mine.

# Sample Screenshots
![1](https://i.imgur.com/z8FRzs7.png)
![1](https://i.imgur.com/7VpMmWc.png)
![1](https://i.imgur.com/JeGhidy.png)
![1](https://i.imgur.com/7NF7m5q.png)
![1](https://i.imgur.com/KDSJvix.png)
![1](https://i.imgur.com/ZYQ4fLL.png)

# Prerequisites

Before you can build this project, you must install and configure the following dependencies on your machine:

1. [Node.js][]: We use Node to run a development web server and build the project.
   Depending on your system, you can install Node either from source or as a pre-packaged bundle.

After installing Node, you should be able to run the following command to install development tools.
You will only need to run this command when dependencies change in [package.json](package.json).

    npm install
    
# How to Run Locally    

Run the following commands in two separate terminals to create a blissful development experience where your browser
auto-refreshes when files change on your hard drive.

    ./mvnw
    npm start

The `npm run` command will list all of the scripts available to run for this project.

# UML Diagram
![1](https://imgur.com/URBDd8q.png)

TODO: SEQUENCE

# Schema
Because this was a simple application, the schema mirrors the UML Diagram.
![1](https://imgur.com/URBDd8q.png)
![1](https://imgur.com/u8ZhqrP)
![1](https://imgur.com/gfk8dsI)
![1](https://imgur.com/gikoXAL)
![1](https://imgur.com/LJRxA9E)
![1](https://imgur.com/I47QDwH)

# Database Queries
All database queries are handled by JPA to uncouple platform from specific type of database.

## Photos
```Java
    @Query(value = "select distinct photo from Photo photo left join fetch photo.tags",
        countQuery = "select count(distinct photo) from Photo photo")
    Page<Photo> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct photo from Photo photo left join fetch photo.tags")
    List<Photo> findAllWithEagerRelationships();

    @Query("select photo from Photo photo left join fetch photo.tags where photo.id =:id")
    Optional<Photo> findOneWithEagerRelationships(@Param("id") Long id);
 ```
## Albums
```Java
    @Query("select album from Album album where album.user.login = ?#{principal.username}")
    List<Album> findByUserIsCurrentUser();
```

# Mid tier APIs
## Album, Photo, and Tag
### POST /albums /photos /tags
Create entity
### PUT /albums /photos /tags
Update entity
### GET /albums /photos /tags with /{OPTIONAL_ID}
Get entity
If ID is provided, get entity with specified ID
### DELETE /albums /photos /tags /{ID} (Required)
Delete entity of specified type and provided ID

# UI data transport
JSON is utilized as the data transport between the frontend and the backend code vs REST APIs
