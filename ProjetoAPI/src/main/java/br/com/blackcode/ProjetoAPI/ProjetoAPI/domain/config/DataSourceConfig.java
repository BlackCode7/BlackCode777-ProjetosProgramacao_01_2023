package br.com.blackcode.ProjetoAPI.ProjetoAPI.domain.config;

import lombok.Getter;
import lombok.Setter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Getter
@Setter
@Configuration
@PropertySources({
        @PropertySource("classpath:/datasource.properties"),
        @PropertySource(value = "classpath:/datasource-${spring.profiles.active}.properties", ignoreResourceNotFound = true)
})
@MapperScan(basePackages = {"br.com.blackcode.ProjetoAPI.ProjetoAPI.domain.mapper"})
@EntityScan(basePackages = {"br.com.blackcode.ProjetoAPI.ProjetoAPI.domain.entity"})
@EnableJpaRepositories(basePackages = {"br.com.blackcode.ProjetoAPI"})
public class DataSourceConfig {
}
