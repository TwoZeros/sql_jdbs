package ru.twozeros.jdbctask1.repository;

import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class ProductRepositrory {
    private final static String SCRIPT_FILE_NAME = "selectScript.sql";
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public String getProductName(String name) {
        final String sql = read(SCRIPT_FILE_NAME);
        return namedParameterJdbcTemplate.queryForList(sql,
                Map.of("name", name),
                String.class).toString();
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
