package app.igesa;

import app.igesa.upload.FilesStorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import app.igesa.metiers.AuditorAwareImpl;
import javax.annotation.Resource;

@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@SpringBootApplication
public class MultiwebsitesApplication implements CommandLineRunner {
	@Resource
	FilesStorageService storageService;

		@Bean
	    public AuditorAware<String> auditorAware() {
	        return new AuditorAwareImpl();
	    }
		  public static void main(String[] args) {
		SpringApplication.run(MultiwebsitesApplication.class, args);
	}
	@Override
	public void run(String... arg) throws Exception {
		storageService.deleteAll();
		storageService.init();
	}

}
