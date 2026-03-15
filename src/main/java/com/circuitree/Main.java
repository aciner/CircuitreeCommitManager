package com.circuitree;

import com.circuitree.html.HtmlGenerator;
import com.circuitree.server.LocalServer;
import com.circuitree.ui.LoadingScreen;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;

public class Main {
    private static final String  USERNAME    = "atlee-circuitree";
    private static final boolean USE_PAGES   = true;
    private static final boolean DEBUG_LOCAL = false;

    public static void main(String[] args) throws IOException {
        LoadingScreen loading = new LoadingScreen();

        String html = HtmlGenerator.generate(USERNAME);
        HtmlGenerator.writeToFile(html, new File("docs/index.html"));

        loading.close();

        if (DEBUG_LOCAL) {
            LocalServer server = new LocalServer(html);
            server.start();
            Desktop.getDesktop().browse(URI.create("http://localhost:" + server.getPort()));
        } else if (USE_PAGES) {
            Desktop.getDesktop().browse(URI.create("https://aciner.github.io/CircuitreeCommitManager/"));
        } else {
            LocalServer server = new LocalServer(html);
            server.start();
            Desktop.getDesktop().browse(URI.create("http://localhost:" + server.getPort()));
        }
    }
}
