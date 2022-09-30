package com.example.hello.controllers;

import com.example.hello.model.MessageHello;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonFactoryBuilder;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ExternalApiController {

    @GetMapping("/helloex/{language}")
    String getExternal(Model model, @PathVariable(value = "language") String language) throws IOException, InterruptedException {

        String skracenica = dajSkreacenicu(language);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://google-translate1.p.rapidapi.com/language/translate/v2"))
                .header("content-type", "application/x-www-form-urlencoded")
                .header("Accept-Encoding", "application/gzip")
                .header("X-RapidAPI-Key", "7a8bc64897msh3c57d7419adca42p1fe99ejsn8031b3214d0b")
                .header("X-RapidAPI-Host", "google-translate1.p.rapidapi.com")
                .method("POST", HttpRequest.BodyPublishers.ofString("q=Hello%2C%20world!&target="+ skracenica + "&source=en"))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());


        if(skracenica != null){
            model.addAttribute("message", response.body().toString().split("translatedText")[1].split("\"}")[0].substring(3));
        }else{
            model.addAttribute("message", "nema tog jezika");
        }

        return "hey";
    }

    private String dajSkreacenicu(String language) {

        ArrayList<String> lista = new ArrayList<>();
        lista.add("Afrikaans\taf");
        lista.add("Japanese\tja");
        lista.add("Korean\tko");
        lista.add("Bulgarian\tbg");
        lista.add("Lithuanian\tlt");
        lista.add("Catalan\tca");
        lista.add("Turkish\ttr");
        lista.add("Thai\tth");
        lista.add("Greek\tel");
        lista.add("Tamil\tta");
        lista.add("German\tde");
        lista.add("Swedish\tsv");
        lista.add("Georgian\tka");
        lista.add("Filipino\ttl");

        for (String s : lista)
            if(s.split("\t")[0].equalsIgnoreCase(language))
                return s.split("\t")[1];

        return null;
    }


}
