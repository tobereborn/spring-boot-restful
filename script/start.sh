#!/usr/bin/env bash

app_dir=$(cd $(dirname "$0")/..;pwd)
log_dir=${app_dir}/logs
conf_dir=${app_dir}/conf

java_home=/opt/jdk/jdk1.8.0_73
jar=${app_dir}/target/spring-boot-restful-1.0-SNAPSHOT.jar

echo "app_dir: $app_dir"
echo "log_dir: $log_dir"
echo "conf_dir: $conf_dir"

${java_home}/bin/java  -Dlog.dir=${log_dir} \
     -jar ${jar} \
     com.github.tbr.spring.Application \
     --spring.config.location=${conf_dir}/application.yml \
     --logging.config=${conf_dir}/logback.xml



