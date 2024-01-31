package com.abc;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Hello {

	static public void startDownload(List<String> urlList, WebDriver driver ) {

		System.out.println("stating download services");
		for (String url : urlList) {
			System.out.println("Downloading " + url);
			driver.get(url);

			WebElement downloadButton = driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/a"));
			downloadButton.click();
			System.out.println("Downloaded " + url);	
		}
	}

	public static void main(String[] args) {

		

		WebDriver driver = new ChromeDriver();

		
		ArrayList<String> urlLinks = new ArrayList<String>();



		for (int i = 1; i < 8; i++) {

			System.out.println("Page " + i + "---------------------------------");
			driver.get("https://www.pagalworld.online/indias-raw-star-2014-mp3-songs/files/p-" + i + ".html");
			
		WebElement parentContainer = driver.findElement(By.className("files-list"));
		

		List<WebElement> allValues = parentContainer.findElements(By.className("cat-list"));


			for (WebElement e : allValues) {
				// System.out.println(e.getText());
				WebElement x = e.findElement(By.tagName("a"));
				// System.out.println(x.getAttribute("href").toString());
				String url = x.getAttribute("href").toString();
				urlLinks.add(url);
				// System.out.println("--------------------------------------------");
			}

		}
		for (String str : urlLinks) {
			System.out.println(str);
			System.out.println("-------------------------------------------------------------------------");

		}

		System.out.println("total number of songs are:" + urlLinks.size());

		// startDownload(urlLinks, driver);
	
	
	}

}
