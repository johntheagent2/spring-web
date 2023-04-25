package com.designpatternfinal.springweb;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class SpringWebApplication {
	public static void main(String[] args) throws IOException, InterruptedException, ApiException {
		SpringApplication.run(SpringWebApplication.class, args);
	}

}
