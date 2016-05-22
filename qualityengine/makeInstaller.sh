#!/bin/bash
mvn clean install -DskipTests=true
mvn dependency:copy-dependencies
mvn assembly:single