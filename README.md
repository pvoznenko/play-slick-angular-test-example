# Play Slick AngularJS Bootstrap H2 Tests Example

[![Build Status](https://travis-ci.org/pvoznenko/play-slick-angular-test-example.svg)](https://travis-ci.org/pvoznenko/play-slick-angular-test-example)

Main goal of this Example is to show how to test Play Framework in memory using H2 and Slick and keep MySQL as main database.

Also contain one-page application RequireJS + AngularJS with Bootstrap, MySQL and Slick.

This is an Example Scala Play application. Application built on [Play Framework](http://www.playframework.com) (Scala), [Slick](http://slick.typesafe.com/), 
[Webjars](https://github.com/webjars), [AngularJS](https://angularjs.org/), [RequireJS](http://requirejs.org), 
for test using [Specs2](http://etorreborre.github.io/specs2/) that runs in [H2](http://www.h2database.com) in-memory database.

As base template for application used [Marius Soutier's](https://github.com/mariussoutier) ["Example application for Play+AngularJS+RequireJS"](https://github.com/mariussoutier/play-angular-require-seed).

## Features
1. [Playframework 2](http://www.playframework.com), [WebJars](http://www.webjars.org),
   [RequireJS](http://www.requirejs.org) and [AngularJS](http://www.angularjs.org) together;
2. In running mode using [Slick](http://slick.typesafe.com/) for work with [MySQL](http://www.mysql.com/);
3. For testing application using [Specs2](http://etorreborre.github.io/specs2/) and run all tests in [H2](http://www.h2database.com) in-memory database;
4. For frontend application using [Bootstrap](http://getbootstrap.com/) with [ngTable](http://bazalt-cms.com/ng-table/) and for DatePickers [Angular UI Bootstrap](http://angular-ui.github.io/).

## Installation

* You do need a JDK 7+ (e.g. [http://www.oracle.com/technetwork/java/javase/downloads/index.html](http://www.oracle.com/technetwork/java/javase/downloads/index.html));
* Install sbt ([http://www.scala-sbt.org/release/docs/Getting-Started/Setup.html](http://www.scala-sbt.org/release/docs/Getting-Started/Setup.html));
* Install mysql server.

## Activator 

You can get this example through [Activator](https://typesafe.com/activator).
For more information please use following url that explains how to get this template on your computer 
step-by-step: [https://typesafe.com/activator/template/play-slick-angular-test-example](https://typesafe.com/activator/template/play-slick-angular-test-example)

## Configuration
* Create mysql database 
* Modify config `conf/application.conf`

## Run

To run application, call command:

```
$ sbt run
```

Then you can find application on following url: [http://localhost:9000/](http://localhost:9000/)

## Run Tests

To run tests, call command:

```
$ sbt test
```

## Copyright

Copyright (C) 2014 Pavlo Voznenko.

Distributed under the MIT License.
