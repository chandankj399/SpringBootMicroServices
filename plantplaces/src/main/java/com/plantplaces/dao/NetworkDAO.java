package com.plantplaces.dao;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Component;


@Component
public class NetworkDAO {
	
	public String request(String endpoint) throws Exception{
		StringBuilder sb = new StringBuilder();
		
		/**
		 * Return the data found at given endpoint
		 * @param endpoint a URL or other location where we can find the data
		 * @return All the data returned as one string 
		 * 
		 */
		
		URL url = new URL(endpoint);
		
		// open a conection to this URL
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		
		try {
		// read in the bytes
		InputStream inputStream = urlConnection.getInputStream();
		BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
		
		// read them as characters.
		InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		
		// read one line at a time
		String inputLine = bufferedReader.readLine();
		while (inputLine != null) {
			sb.append(inputLine);
			inputLine = bufferedReader.readLine();
		}
		}
		finally {
			urlConnection.disconnect();
		}
		
		
		return sb.toString();
	}

}
