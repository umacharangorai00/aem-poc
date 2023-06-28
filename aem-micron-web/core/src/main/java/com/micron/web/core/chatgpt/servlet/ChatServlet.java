package com.micron.web.core.chatgpt.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.micron.web.core.chatgpt.beans.ChatGptRequest;
import com.micron.web.core.chatgpt.beans.ChatGptResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

@Component( immediate = true, service = Servlet.class)
@SlingServletPaths({ ChatServlet.SERVLET_PATH })
public class ChatServlet extends SlingSafeMethodsServlet {

    private static final Logger LOGGER = Logger.getLogger(ChatServlet.class.getName());
    protected static final String SERVLET_PATH = "/bin/chat";
    private static final String CHATGPT_API_ENDPOINT = "https://api.openai.com/v1/chat/completions";

    private static final HttpClient client = HttpClients.createDefault();
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        String prompt = request.getParameter("prompt");
        String message = generateMessage(prompt);
        response.getWriter().write(message);
    }

    private static String generateMessage(String prompt) throws IOException {

            // Generate the chat message using ChatGPT API
            String requestBody = MAPPER.writeValueAsString(new ChatGptRequest(prompt,"gpt-3.5-turbo","user"));
            HttpPost request = new HttpPost(CHATGPT_API_ENDPOINT);
            request.addHeader("Authorization", "Bearer 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");
            request.addHeader("Content-Type", "application/json");
            request.setEntity(new StringEntity(requestBody));
            System.out.println("requestBody: "+requestBody);
            HttpResponse response = client.execute(request);
            ChatGptResponse chatGptResponse = MAPPER.readValue(EntityUtils.toString(response.getEntity()), ChatGptResponse.class);
            String message = chatGptResponse.getChoices().get(0).getMessage().getContent();
                 
            return message;     

    }

        
    public static void main(String[] args) {
        try {
            System.out.println(generateMessage("What is Adobe AEM"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}

