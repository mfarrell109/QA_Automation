package base.Utility;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.openqa.selenium.json.Json;

/* The purpose of this class is to create a utility that can enable QA to test different endpoints
 * using different CRUD requests using Java 11 library for this WebUtility */
public class WebUtility {
	
	/* Here is a WebClient that uses url and verb. */
	public HttpURLConnection WebClient(String url, String verb) throws MalformedURLException, IOException {
		HttpURLConnection httpClient = (HttpURLConnection) 
                URI.create(
                    new StringBuilder(url)
                .toString())
                .toURL()                
                .openConnection();
		httpClient.setRequestMethod(verb);
		return httpClient;
	}
	
}
