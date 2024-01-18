package com.example.saltfrontend.controller;

import com.example.saltfrontend.model.Konsumen;
import com.example.saltfrontend.model.SearchFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.context.WebContext;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
public class IndexController {

    @GetMapping("/")
    public String index(@ModelAttribute SearchFilter searchFilter){
        System.out.println(searchFilter.toString());
        return "index";
    }

    @PostMapping("/add")
    public String addKonsumen(@ModelAttribute Konsumen konsumen) {
        konsumen.setId(0);
        konsumen.setTglRegistrasi("");
        System.out.println(konsumen.toString());

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/konsumen/add"))
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(konsumen.toString()))
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return "index";
    }

    @PostMapping("/search")
    public String search(@ModelAttribute SearchFilter searchFilter, Model model) throws JsonProcessingException {
        if (searchFilter.getIdfilter() == null) {
            searchFilter.setIdfilter("0");
        }
        System.out.println(searchFilter.toString());

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/konsumen/search"))
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(searchFilter.toString()))
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> res = new ArrayList<>();
        res = mapper.readValue(response.body(), new TypeReference<List<Map<String, Object>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        });
        System.out.println(res);
        model.addAttribute("listdata", res);
        System.out.println(model);
        return "index";
    }
}
