package pro.ofitserov.msaaml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pro.ofitserov.msaaml.backend.Dao;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.StringVendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@EnableSwagger2
public class MsaAmlApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaAmlApplication.class, args);
    }

    @Bean
    public Dao dao() {
        return new Dao();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("pro.ofitserov.msaaml"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo()).useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "MSA#AML",
                "Service MSA#AML",
                null,
                null,
                null,
                null,
                null,
                Stream.of(new StringVendorExtension("Company", "ofitserov.pro")).collect(Collectors.toList())
        );
    }
}
