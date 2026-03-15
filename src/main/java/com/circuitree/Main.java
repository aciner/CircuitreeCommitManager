package com.circuitree;

import com.circuitree.html.HtmlGenerator;
import com.circuitree.server.LocalServer;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;

public class Main {
    private static final String USERNAME = "atlee-circuitree";

    public static void main(String[] args) throws IOException {
        String html = HtmlGenerator.generate(USERNAME);

        // Write docs/index.html for GitHub Pages
        HtmlGenerator.writeToFile(html, new File("docs/index.html"));
        System.out.println("Written to docs/index.html");

        // Also serve locally
        new LocalServer(html).start();
        Desktop.getDesktop().browse(URI.create("http://localhost:8080"));
    }
}
