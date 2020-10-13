module randonneesv2 {
	exports org.cedam.application.randonnees.entity;
	exports org.cedam.application.randonnees.entityV6;
	exports org.cedam.application.randonnees;
	exports org.cedam.application.randonnees.dao;
	exports org.cedam.application.randonnees.service.controller;
	exports org.cedam.application.randonnees.business;
	exports org.cedam.application.randonnees.entity.config;

	requires java.persistence;
	requires spring.beans;
	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.context;
	requires spring.core;
	requires spring.data.commons;
	requires spring.data.jpa;
	requires spring.orm;
	requires spring.tx;
	requires spring.web;
	requires tomcat.embed.core;
}