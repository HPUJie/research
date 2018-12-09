package com.hapi.dynamicproxy;

/**
 * config interfaces, map the config properties file:
 * db.url =
 * db.validation = true
 * db.pool.size = 100
 */
public interface IConfig {

    @Value("db.url")
    String dbUrl();

    @Value("db.validation")
    boolean isValidated();

    @Value("db.pool.size")
    int poolSize();

}