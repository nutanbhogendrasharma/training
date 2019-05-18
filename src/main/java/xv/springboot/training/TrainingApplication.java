package xv.springboot.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xv.springboot.training.repositories.OrganizationRepository;
import xv.springboot.training.repositories.StudentRepository;
import xv.springboot.training.entities.Organization;
import xv.springboot.training.entities.Student;

@SpringBootApplication
public class TrainingApplication extends SpringBootServletInitializer{
	
	@Autowired 
	private StudentRepository studentRepository;
	
	@Autowired
	private OrganizationRepository organizationRepository;

	private static final Logger logger = LoggerFactory.getLogger(TrainingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TrainingApplication.class, args);
		logger.info("Hello Spring Boot");
	}
	
	@Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
	
	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		// TODO Auto-generated method stub
		return application.sources(TrainingApplication.class);
	}

	

	@Bean
	CommandLineRunner runner() {
		return args -> {
			
			//add organization data to h2 database
			Organization organization1 = new Organization("Lucknow University" , "Changed Delhi University to Lucknow University");
			Organization organization2 = new Organization("Karnatak University" , "Karnatak University");
			Organization organization3 = new Organization("University of Delhi" , "The University of Delhi was established in February, 1922. ");
			Organization organization4 = new Organization("North Eastern Hill University" , "The North Eastern Hill University (NEHU) was established in 1973.");
			Organization organization5 = new Organization("Assam University" , "Assam University was established in 1994 at Silchar.");
			Organization organization6 = new Organization("Tezpur University" , "Tezpur University, a teaching and residential University located at Napaam, Tezpur (Assam), was set up in January, 1994.");
			Organization organization7 = new Organization("Mizoram University" , "The Central University of Mizoram was established on July 2, 2000 by the Mizoram University Act, 2000 as a Central University.");
			Organization organization8 = new Organization("Nagaland University" , "The Central University of Nagaland was established by the Government of India in 1994 with campuses at Kohima, Dimapur, Lumami and Medziphema. ");
			Organization organization9 = new Organization("University of Allahabad" , "The University of Allahabad, set up in 1887, is one of the oldest and most prestigious universities in the country.");

			organizationRepository.save(organization1);
			organizationRepository.save(organization2);
			organizationRepository.save(organization3);
			organizationRepository.save(organization4);
			organizationRepository.save(organization5);
			organizationRepository.save(organization6);
			organizationRepository.save(organization7);
			organizationRepository.save(organization8);
			organizationRepository.save(organization9);
			
			
			//save student data to h2 database
			studentRepository.save(new Student("Srinivas", "Male", "BE", 25, organization2));
			studentRepository.save(new Student("Nesha", "Female", "BE", 20, organization2));
			studentRepository.save(new Student("Seema", "Female", "BTech", 30, organization2));
			studentRepository.save(new Student("Suraj", "Male", "Electrical Engineer", 35, organization1));
		};
	}
}
