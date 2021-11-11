package Ecommerce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import Ecommerce.dao.CategoryRepository;
import Ecommerce.dao.ProductRepository;
import Ecommerce.entities.Category;
import Ecommerce.entities.Product;

import java.util.Random;
import net.bytebuddy.utility.RandomString;

@SpringBootApplication
public class LightEcomV1Application implements CommandLineRunner {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(LightEcomV1Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Product.class,Category.class);


	}
}

