package com.circuitree;

import com.circuitree.html.HtmlGenerator;
import com.circuitree.ui.LoadingScreen;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;

public class Main {
    private static final String USERNAME = "atlee-circuitree";
    private static final String PAGES_URL = "https://aciner.github.io/CircuitreeCommitManager";

    public static void main(String[] args) throws IOException {
        LoadingScreen loading = new LoadingScreen();

        HtmlGenerator.writeToFile(HtmlGenerator.generate(USERNAME), new File("docs/index.html"));

        loading.close();

        Desktop.getDesktop().browse(URI.create(PAGES_URL));
    }
}
