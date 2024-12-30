package com.example.demo;

import java.io.IOException;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EducationCounsellingWebsiteApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EducationCounsellingWebsiteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 String url = "http://localhost:8080/home"; // Your app's URL
	        openBrowser(url);
	}

	
	private void openBrowser(String url) throws IOException {
        String os = System.getProperty("os.name").toLowerCase();
        
        if (os.contains("win")) {
            // Windows
			 Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url); 
			/* Runtime.getRuntime().exec("chrome " + url); */
        } else if (os.contains("mac")) {
            // macOS
            Runtime.getRuntime().exec("open " + url);
        } else if (os.contains("nix") || os.contains("nux")) {
            // Linux
            Runtime.getRuntime().exec("xdg-open " + url);
        }
    }
}
