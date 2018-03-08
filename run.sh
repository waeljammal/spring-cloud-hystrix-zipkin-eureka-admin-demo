#!/usr/bin/env bash

mvn compile
mvn package
docker-compose build
docker-compose up